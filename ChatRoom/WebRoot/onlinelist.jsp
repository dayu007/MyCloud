<%@ page language="java" import="test707.chatroom.DBConn,java.sql.*" pageEncoding="gb2312"%>
<jsp:useBean id="roomMgr" class="test707.chatroom.ChatRoomMgr"></jsp:useBean>
<jsp:useBean id="list" class="test707.chatroom.UserOnline"></jsp:useBean>
<html>
  <head>
  <script type="text/javascript">
    function refresh() {
		setTimeout("window.location.reload()",8000);
    }
    
    function msgTo(sb) {
    	parent.inputFrame.inputForm.msgto.value=sb;
    	return true;
    }
  </script>
 </head>
<body onload="refresh()">
 <%
  //�ж��û��Ƿ�����������У���Ȼsession���ڣ�����useronline��Ҫ��һ����֤�����useronline��û�У�˵���Ѿ���T��������������
  if(!roomMgr.isAtRoom((String)session.getAttribute("_USER"),(String)session.getAttribute("_CHAT_ROOM"))) {
  	out.println("<script>parent.alert(\"�Բ������Ѿ��뿪�˷���\")</script>");
  	out.println("<script>parent.inputFrame.body.onunload=\"\"</script>");
  	out.println("<script>parent.document.location.href='changeroom.jsp'</script>");
  	return;//��������ڣ���ִ���������
  }
  //�ж��û��Ƿ�Ͽ�����
  if(session.getAttribute("_USER") == null) {
  	out.println("<script>parent.alert(\"�Բ������Ѿ��Ͽ�����\")</script>");
  	out.println("<script>parent.parent.document.location.href='login.jsp'</script>");
  	return;
  }
  String chatroom = (String)session.getAttribute("_CHAT_ROOM");
%>
  �û��б� [<%=list.countUser(chatroom)%>]<br>
  <a href="#" onClick="return msgTo('������');">������</a><br>
<%
	DBConn conn = new DBConn();
	String sql = "select * from useronline where chatroom=?";
	PreparedStatement pStmt = conn.prepareStmt(sql);
	pStmt.setString(1,(String)session.getAttribute("_CHAT_ROOM"));
	ResultSet rs = conn.executeQuery();
	while(rs.next()) {
		String username = rs.getString("username");
%>
	[<a href="#" onClick="return msgTo('<%=username%>');"><%=username%></a>]<br>
<%
	}
 %>
  </body>
</html>
