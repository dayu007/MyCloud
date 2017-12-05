<%@ page language="java"  pageEncoding="gb2312"%>
<jsp:useBean id="roomMgr" class="test707.chatroom.ChatRoomMgr"></jsp:useBean>
<jsp:useBean id="msgMgr" class="test707.chatroom.Msg"></jsp:useBean>
<html>
  <head>
  </head>
  <body>
    <%
  //判断用户是否在这个房间中，虽然session存在，但是useronline需要进一步验证，如果useronline中没有，说明已经被T出房间或其他情况
  if(!roomMgr.isAtRoom((String)session.getAttribute("_USER"),(String)session.getAttribute("_CHAT_ROOM"))) {
  	out.println("<script>parent.alert(\"对不起，你不在这个房间中\")</script>");
  	out.println("<script>parent.document.body.onunload=\"\"</script>");
  	out.println("<script>parent.parent.document.location.href='changeroom.jsp'</script>");
  	return;//如果不存在，不执行以下语句
  }
  request.setCharacterEncoding("gb2312");
  String chatroom = (String)session.getAttribute("_CHAT_ROOM");
  String msgfrom = (String)session.getAttribute("_USER");
  String msgto = request.getParameter("msgto");
  String chataction = request.getParameter("chataction");
  String msg = request.getParameter("msg");
  String color = request.getParameter("color");
  int secret = 0;
  if(request.getParameter("secret") != null) {
  	secret = 1;
  }
  msgMgr.setChatroom(chatroom);
  msgMgr.setMsgfrom(msgfrom);
  msgMgr.setMsgto(msgto);
  msgMgr.setChataction(chataction);
  msgMgr.setMsgcontent("<font color="+color+">"+msg+"</font>");
  msgMgr.setSecret(secret);
  msgMgr.saveToDB();
  //重置输入框为空
  out.println("<script>parent.document.inputForm.msg.value=\"\"</script>");
  //立即刷新显示页面
  out.println("<script>parent.parent.showFrame.getmsg.location.reload()</script>");
   %>
  
  </body>
</html>
<!-- 本页任务：先判断用户是否在useronline表中，如果有，
			将所发信息保存到msginfo表中,
			并马上更新显示页面getmsg.jsp-->