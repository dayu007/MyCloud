<%@ page language="java" import="test707.chatroom.*,java.sql.*" pageEncoding="gb2312"%>
<%
	ChatRoomMgr crm = new ChatRoomMgr();
	if(!crm.isAdmin((String)session.getAttribute("_USER"))) {
		out.println("<script>parent.alert(\"你不是管理员，不能使用此功能\")</script>");
		out.println("<script>location.href='javascript:window.close()'</script>");
		return;
	}
 %>
<html>
  <head>
    <title>管理员页面</title>
  </head>
  
  <body>

      <form action="kick.jsp" target="theFrame" method="post">
    	<table>
    	<tr><td>用户名</td><td>最近聊天时间</td><td>最近登录时间</td>
<%  
	DBConn conn = new DBConn();
	String sql = "select * from useronline";
	conn.prepareStmt(sql);
	ResultSet rs = conn.executeQuery();
	String username = "";
	String lastchattime = "";
	while(rs.next()) {
		username = rs.getString(3);
		lastchattime = rs.getString("lastchattime");
%>
<tr><td><input type="checkbox" name="names" value=<%=username%>><%=username %></td>
			<td><%=lastchattime%></td></tr>
<% 
	}
	/*
	sql = "select * from userinfo where username=?";
	PreparedStatement pStmt = conn.prepareStmt(sql);
	pStmt.setString(1,username);
	rs = conn.executeQuery();
	String lastlogintime = "";
	while(rs.next()) {
		lastlogintime = rs.getString("lastlogintime");
	}*/
	conn.close();
	
 %>	
    </table>
    <tr><input type="submit" value="踢之"></tr>
	<iframe id="theFrame" name="theFrame" width="0" height="0"></iframe>    
    </form>
  </body>
</html>
