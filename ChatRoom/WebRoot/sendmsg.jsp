<%@ page language="java"  pageEncoding="gb2312"%>
<jsp:useBean id="roomMgr" class="test707.chatroom.ChatRoomMgr"></jsp:useBean>
<jsp:useBean id="msgMgr" class="test707.chatroom.Msg"></jsp:useBean>
<html>
  <head>
  </head>
  <body>
    <%
  //�ж��û��Ƿ�����������У���Ȼsession���ڣ�����useronline��Ҫ��һ����֤�����useronline��û�У�˵���Ѿ���T��������������
  if(!roomMgr.isAtRoom((String)session.getAttribute("_USER"),(String)session.getAttribute("_CHAT_ROOM"))) {
  	out.println("<script>parent.alert(\"�Բ����㲻�����������\")</script>");
  	out.println("<script>parent.document.body.onunload=\"\"</script>");
  	out.println("<script>parent.parent.document.location.href='changeroom.jsp'</script>");
  	return;//��������ڣ���ִ���������
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
  //���������Ϊ��
  out.println("<script>parent.document.inputForm.msg.value=\"\"</script>");
  //����ˢ����ʾҳ��
  out.println("<script>parent.parent.showFrame.getmsg.location.reload()</script>");
   %>
  
  </body>
</html>
<!-- ��ҳ�������ж��û��Ƿ���useronline���У�����У�
			��������Ϣ���浽msginfo����,
			�����ϸ�����ʾҳ��getmsg.jsp-->