<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@include file="sessioncheck.jsp" %>
<html>
  <head>
  <title>�����б�</title>
  <link href="CSS/style.css" rel="stylesheet">
  </head>
  <body align="center">
  <jsp:useBean id="uonline" class="test707.chatroom.UserOnline"></jsp:useBean>
  <!--  Html Marquee�ƶ�����  -->
  <marquee bgcolor=aaaaee>��ӭ���٣�<%=session.getAttribute("_USER")%>,��ã���ӭ��½���籾112�����ң�ף��������죡</marquee>
  <form action="roomlistdeal.jsp" method=post>
	<input type=radio name=chatroom value="java������" checked>
        java������ [<%=uonline.countUser("java������")%>]��<p>
	<input type=radio name=chatroom value="���簲ȫ������">
        ���簲ȫ������ [<%=uonline.countUser("���簲ȫ������")%>]��<p>
    <input type=radio name=chatroom value="����������" checked>
        ���������� [<%=uonline.countUser("����������")%>]��<p>
    <input type=radio name=chatroom value="��ҵ���������">
        ��ҵ��������� [<%=uonline.countUser("��ҵ���������")%>]��<p>
	<input type=submit value="�������������">
  </form>
  </body>
</html>
