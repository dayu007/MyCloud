<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<%@include file="sessioncheck.jsp" %>
<html>
<title><%=(String)session.getAttribute("_CHAT_ROOM")%></title>
<!-- ÉèÖÃ¿ò¼Ü -->
<frameset rows="*,130">
	<frameset cols="*,180">
		<frame name="showFrame"  src="showmsg.jsp" scrolling="auto">
		<frame name="userListFrame" src="onlinelist.jsp" scrolling="auto">
	</frameset>
	<frame name="inputFrame" src="input.jsp">
</frameset>
</html>
