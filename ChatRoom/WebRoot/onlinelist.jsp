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
  //判断用户是否在这个房间中，虽然session存在，但是useronline需要进一步验证，如果useronline中没有，说明已经被T出房间或其他情况
  if(!roomMgr.isAtRoom((String)session.getAttribute("_USER"),(String)session.getAttribute("_CHAT_ROOM"))) {
  	out.println("<script>parent.alert(\"对不起，你已经离开了房间\")</script>");
  	out.println("<script>parent.inputFrame.body.onunload=\"\"</script>");
  	out.println("<script>parent.document.location.href='changeroom.jsp'</script>");
  	return;//如果不存在，不执行以下语句
  }
  //判断用户是否断开连接
  if(session.getAttribute("_USER") == null) {
  	out.println("<script>parent.alert(\"对不起，你已经断开连接\")</script>");
  	out.println("<script>parent.parent.document.location.href='login.jsp'</script>");
  	return;
  }
  String chatroom = (String)session.getAttribute("_CHAT_ROOM");
%>
  用户列表 [<%=list.countUser(chatroom)%>]<br>
  <a href="#" onClick="return msgTo('所有人');">所有人</a><br>
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
