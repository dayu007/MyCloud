<%@ page language="java" pageEncoding="gb2312"%>
<jsp:useBean id="crm" class="test707.chatroom.ChatRoomMgr" />
  <% 
  //JS调用本页 将此用户从useronline列表中删除
  crm.logout((String)session.getAttribute("_USER"));
  //session失效
  session.invalidate();	
  //跳转到登录页面
  response.sendRedirect("login.jsp");
   %>
