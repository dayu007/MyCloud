<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@include file="sessioncheck.jsp" %>
<html>
  <head>
  <title>房间列表</title>
  <link href="CSS/style.css" rel="stylesheet">
  </head>
  <body align="center">
  <jsp:useBean id="uonline" class="test707.chatroom.UserOnline"></jsp:useBean>
  <!--  Html Marquee移动文字  -->
  <marquee bgcolor=aaaaee>欢迎光临！<%=session.getAttribute("_USER")%>,你好！欢迎登陆网络本112聊天室，祝您聊天愉快！</marquee>
  <form action="roomlistdeal.jsp" method=post>
	<input type=radio name=chatroom value="java讨论区" checked>
        java讨论区 [<%=uonline.countUser("java讨论区")%>]人<p>
	<input type=radio name=chatroom value="网络安全讨论区">
        网络安全讨论区 [<%=uonline.countUser("网络安全讨论区")%>]人<p>
    <input type=radio name=chatroom value="休闲讨论区" checked>
        休闲讨论区 [<%=uonline.countUser("休闲讨论区")%>]人<p>
    <input type=radio name=chatroom value="毕业设计讨论区">
        毕业设计讨论区 [<%=uonline.countUser("毕业设计讨论区")%>]人<p>
	<input type=submit value="点击进入聊天室">
  </form>
  </body>
</html>
