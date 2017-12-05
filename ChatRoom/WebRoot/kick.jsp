<%@ page language="java" import="test707.chatroom.*" pageEncoding="gb2312"%>

<%	
	request.setCharacterEncoding("gb2312");
	ChatRoomMgr crm = new ChatRoomMgr();
	String[] names = request.getParameterValues("names");
	for(int i=0; i<names.length; i++) {
System.out.println(names[i]);
		crm.logout(names[i]);
	}
	out.println("<script>parent.alert(\"Ãﬂ»À≥…π¶\")</script>");
	out.println("<script>parent.location.reload()</script>");
 %>
