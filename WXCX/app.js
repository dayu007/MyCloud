//app.js
App({
  /**变量 */
  globalData: {
    userInfo: null,
    userId: '',
    Name: ''
  },
  onLaunch: function () {
    var that = this

    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId

        if (res.code) {
          console.log('code==' + res.code)
          //发起网络请求
          wx.request({
            // url: 'https://test.com/onLogin',
            url: 'https://www.zuoye123.com/n_cloudmate/weixin/getuserid',
            data: {
              code: res.code
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            success: function (data) {
              console.log('初始化')
              // if(data.data==""){
              // console.log('请求数据为空')
              that.globalData.userId = '2',
              that.globalData.Name = '哪吒'
            }
          })
        } else {
          console.log('获取用户登录态失败！' + res.errMsg)
        }
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })

    wx.navigateToMiniProgram({
      appId: '',
      path: 'pages/index/index?id=123',
      extraData: {
        foo: 'bar'
      },
      envVersion: 'develop',
      success(res) {
        // 打开成功
      }
    })
  }
})