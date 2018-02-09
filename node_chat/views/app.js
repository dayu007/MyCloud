var express = require('express');
var path = require('path');
var IO = require('socket.io');
var router = express.Router();

var app = express();
var server = require('http').Server(app);
app.use(express.static(path.join(__dirname, 'public')));
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'hbs');

// 创建socket服务
var socketIO = IO(server);
// 房间用户名单
var roomInfo = {};
//是否禁言
var istalk = {}

socketIO.on('connection', function (socket) {
    // 获取请求建立socket连接的url
    // 如: http://localhost:xxxx/room/room_1, roomID为room_1
    var url = socket.request.headers.referer;
    var splited = url.split('/');
    var roomID = splited[splited.length - 1];   // 获取房间ID
    var user;

    function User(name, userId, isfrom, isconnected,ishandup) {
        this.name = name
        this.userId = userId
        this.isfrom = isfrom
        this.isconnected = isconnected
        this.ishandup=ishandup
    }

    socket.on('join', function (data) {
        user = new User(data.userName, data.userId, data.isfrom, 0,0)

        //改对象
        //user = data.userName;

        // 将用户昵称加入房间名单中
        if (!roomInfo[roomID]) {
            roomInfo[roomID] = [];
        }
        //如果istalk没有设置过禁言，这初始化
        if (!istalk[roomID]) {
            istalk[roomID] = false;
        }

        roomInfo[roomID].push(user);
        // 加入聊天室
        socket.join(roomID);
        // 通知聊天室内人员
        //socketIO.to(roomID).emit('sys', user.name + ' 进入聊天室', roomInfo[roomID]);
        socketIO.to(roomID).emit('sys', '', roomInfo[roomID]);

        //如果该聊天室禁言，则发送状态
        if (istalk[roomID]) {
            socketIO.to(roomID).emit('shutup', '');
        }

        //console.log(user.name + '加入了' + roomID);
    });

    socket.on('leave', function () {
        socket.emit('disconnect');
    });

    socket.on('disconnect', function () {
        // 从聊天室名单中移除
        var index = roomInfo[roomID].indexOf(user);
        if (index !== -1) {
            roomInfo[roomID].splice(index, 1);
        }

        socket.leave(roomID);    // 退出聊天室
        socketIO.to(roomID).emit('sys', '', roomInfo[roomID]);
        //socketIO.to(roomID).emit('sys', user.name + ' 退出了聊天室', roomInfo[roomID]);
        //console.log(user.name + '退出了' + roomID);
    });

    // 接收用户消息,发送相应的聊天室
    socket.on('message', function (msg) {
        // 验证如果用户不在聊天室内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        // 判断当前房间是否禁言中
        if (istalk[roomID]) {
            // socketIO.to(roomID).emit('shutup', msg);
        } else {
            socketIO.to(roomID).emit('msg', user, msg);
        }

    });

    //老师禁言操作
    socket.on('shutup', function (msg) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }
        istalk[roomID] = true
        socketIO.to(roomID).emit('shutup', msg);
        socketIO.to(roomID).emit('sys', user.name + ' 开启禁言', roomInfo[roomID]);
    });

    // 老师取消禁言
    socket.on('talk', function (msg) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }
        istalk[roomID] = false
        //console.log('istalk[roomID]=talk=='+istalk[roomID])
        socketIO.to(roomID).emit('talk', msg);//解除禁言操作
        // 通知房间内人员
        socketIO.to(roomID).emit('sys', user.name + ' 解除禁言', roomInfo[roomID]);
    });

    // 老师让学生发言
    socket.on('connect_stu', function (data) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        console.log('让学生 ' + data.name + ' 发言')
        socketIO.to(roomID).emit('connect_stu', data.userId);
        // 通知房间内人员
        socketIO.to(roomID).emit('sys', user.name + ' 让' + data.name + ' 发言', roomInfo[roomID]);
    });

    // 老师让学生关闭发言
    socket.on('disconnect_stu', function (data) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        console.log('让学生' + data.name + ' 关闭发言')
        socketIO.to(roomID).emit('disconnect_stu', data.userId);
        // 通知房间内人员
        socketIO.to(roomID).emit('sys', user.name + ' 让' + data.name + ' 断开发言', roomInfo[roomID]);
    });

    // 学生回应老师连接状态
    socket.on('connectingU', function (data) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }
        console.log("user.userId=" + user.userId)
        console.log("=" + user.name)
        console.log("=" + user.isconnected)

        user.isconnected = data.connect_status
        console.log("user.userId=" + data.connect_status)

        socketIO.to(roomID).emit('connectingU', data);
        if (user.isconnected == 0) {
            socketIO.to(roomID).emit('sys', data.name + ' 断开连接', roomInfo[roomID]);
        } else if (user.isconnected == 1) {
            socketIO.to(roomID).emit('sys', data.name + ' 正在连接', roomInfo[roomID]);
        }
    });

    // 老师取消所有学生连接
    socket.on('disconnect_all_student', function (userName) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        roomInfo[roomID].forEach(function (stu, index, array) {
            stu.isconnected = 0
        })
        socketIO.to(roomID).emit('sys', userName + ' 断开所有学生连接', roomInfo[roomID]);
        socketIO.to(roomID).emit('disconnect_stu', -1);
    });


    /**
     * 学生举手和放下举手事件
     */
    socket.on('ishandup', function (data) {
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }
        //data.ishandup=1举手,data.ishandup=2放下举手
        console.log('学生举手状态是：'+data.ishandup)
        user.ishandup=data.ishandup
        // 通知房间内人员
        socketIO.to(roomID).emit('ishandup', data,roomInfo[roomID]);
    });

    /**
     * 老师通知所有学生放下举手
     * param userName:老师名称
     */
    socket.on('put_down_all_hand', function (userName) {
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        roomInfo[roomID].forEach(function (stu, index, array) {
            stu.ishandup= 0
        })

        //给个标志，当学生接受的参数是-1，则表示需要放下举手
        socketIO.to(roomID).emit('put_down_all_hand', -1);
        // 通知房间内人员
        socketIO.to(roomID).emit('sys','', roomInfo[roomID]);
    });

    /**
     * 学生举手和放下举手事件
     */
    socket.on('handup_back', function (data) {
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        // 通知房间内人员
        socketIO.to(roomID).emit('handup_back', data);
    });

});

// student page
router.get('/room/student/:userId/:userName/:isfrom/:roomID', function (req, res) {
    var roomID = req.params.roomID;

    // 渲染页面数据(见views/room.hbs)
    res.render('student', {
        roomID: roomID,
        users: roomInfo[roomID]
    });
});

// student wechat page
router.get('/student/:userId/:userName/:isfrom/:roomID', function (req, res) {
    var roomID = req.params.roomID;

    // 渲染页面数据(见views/room.hbs)
    res.render('stu_chatroom', {
        roomID: roomID,
        users: roomInfo[roomID]
    });
});

// teacher page
router.get('/room/teacher/:param/:roomID', function (req, res) {
    var roomID = req.params.roomID;

    // 渲染页面数据(见views/room.hbs)
    res.render('teacher', {
        roomID: roomID,
        users: roomInfo[roomID]
    });
});

app.use('/', router);

server.listen(3303, function () {
    console.log('server listening on port 3303');
});


/**
 * 注明：sys事件：消息为空则表示不显示到学生和教师页面，只刷新教师页面
 */