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
    // 如: http://localhost:3000/room/room_1, roomID为room_1
    var url = socket.request.headers.referer;
    var splited = url.split('/');
    var roomID = splited[splited.length - 1];   // 获取房间ID
    var user ;

    function User(name,userId,isfrom){
        this.name=name
        this.userId=userId
        this.isfrom=isfrom
    }

    socket.on('join', function (data) {
        user=new User(data.userName,data.userId,data.isfrom)

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
        // 加入房间
        socket.join(roomID);
        // 通知房间内人员
        socketIO.to(roomID).emit('sys', user.name + ' 进入聊天室', roomInfo[roomID]);

        //如果该房间禁言，则发送状态
        if(istalk[roomID]){
            socketIO.to(roomID).emit('shutup', '');
        }

        //console.log(user.name + '加入了' + roomID);
    });

    socket.on('leave', function () {
        socket.emit('disconnect');
    });

    socket.on('disconnect', function () {
        // 从房间名单中移除
        var index = roomInfo[roomID].indexOf(user);
        if (index !== -1) {
            roomInfo[roomID].splice(index, 1);
        }

        socket.leave(roomID);    // 退出房间
        socketIO.to(roomID).emit('sys', user.name + '退出了房间', roomInfo[roomID]);
        //console.log(user.name + '退出了' + roomID);
    });

    // 接收用户消息,发送相应的房间
    socket.on('message', function (msg) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }

        // 判断当前房间是否禁言中
        if (istalk[roomID]) {
            // socketIO.to(roomID).emit('shutup', msg);
        }else{
            socketIO.to(roomID).emit('msg', user, msg);
        }

    });

    //老师禁言操作
    socket.on('shutup', function (msg) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }
        istalk[roomID]=true
        socketIO.to(roomID).emit('shutup', msg);
        socketIO.to(roomID).emit('sys', user.name + ' 开启禁言', roomInfo[roomID]);
    });

    // 老师取消禁言
    socket.on('talk', function (msg) {
        // 验证如果用户不在房间内则不给发送
        if (roomInfo[roomID].indexOf(user) === -1) {
            return false;
        }
        istalk[roomID]=false
        //console.log('istalk[roomID]=talk=='+istalk[roomID])
        socketIO.to(roomID).emit('talk', msg);//解除禁言操作
        // 通知房间内人员
        socketIO.to(roomID).emit('sys', user.name + ' 解除禁言', roomInfo[roomID]);
    });

});

// room page
router.get('/room/student/:param/:roomID', function (req, res) {
    var roomID = req.params.roomID;

    // 渲染页面数据(见views/room.hbs)
    res.render('student', {
        roomID: roomID,
        users: roomInfo[roomID]
    });
});
// room page
router.get('/room/teacher/:param/:roomID', function (req, res) {
    var roomID = req.params.roomID;

    // 渲染页面数据(见views/room.hbs)
    res.render('teacher2', {
        roomID: roomID,
        users: roomInfo[roomID]
    });
});

app.use('/', router);

server.listen(3000, function () {
    console.log('server listening on port 3000');
});
