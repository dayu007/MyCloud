//index.js
//获取应用实例
const app = getApp()

var helloData = { tName: 'NanJing' }

Page({
  data: {
    motto: 'Hello World!!',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    tName: helloData.tName,
    a: 1,
    b: 3,
    c: 5,
    userId: app.globalData.userId,
    names: ''
  }, changeName: function (e) {

    console.log( this)
    if (this.data.motto == ('Hello World!!')) {
      this.setData({
        motto: 'Hello 中国!!'
      }
      )
    } else {
      this.setData({
        motto: 'Hello World!!'
      })
    }
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    console.log('app.globalData.Name=' + app.globalData.Name)
    this.setData({
      names:app.globalData.Name
    })

    if (app.globalData.userInfo) {
      console.log('000000000000000')
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      console.log('111111111111111111111')
      console.log(app.globalData)
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  jumpLive: function (e) {
    // console.log('跳转页面 userId；'+app.globalData.userId)
    wx.redirectTo({
      url: '../live/live?userId='+app.globalData.userId+'&userName=小明',
    }) 
  },
  addInput:function(e){
    console.log(e.detail)
    this.setData({
      motto:e.detail.value
    })
  }
})

