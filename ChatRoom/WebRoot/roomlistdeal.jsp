<%@ page language="java"  pageEncoding="gb2312"%>
<%@include file="sessioncheck.jsp" %>
<jsp:useBean id="useronline" class="test707.chatroom.UserOnline" />

<html>
  <head>
  </head>
  <body>
  <%
  	request.setCharacterEncoding("gb2312");
  	String chatroom = request.getParameter("chatroom");
  	//ÉèÖÃchatroomµÄsessionÊôÐÔ
  	session.setAttribute("_CHAT_ROOM",chatroom);
  	useronline.addUserOnline(chatroom ,(String)session.getAttribute("_USER"));
  	response.sendRedirect("chatframe.jsp");
  %>
  </body>
</html>
