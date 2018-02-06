/**
 * 学生端
 * @param link
 * @param userId
 */
function callAndroid(link, userId) {
    /*约定的url协议为：js://webview?link=0&userId=100*/
    document.location = "js://webview?link=" + link + "&userId=" + userId;  //link=0关闭ovc,link=1打开
}

/**
 * 教师端 连接到某个学生
 * @param stuId
 */
function connect(stuId)
{
    jsTeaCallback.StartOvc(stuId);
}

/**
 * 教师端，关闭所有连接
 */
function disconnect_all()
{
    jsTeaCallback.CloseOvc();
}
