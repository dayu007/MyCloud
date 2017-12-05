<%@ page language="java" pageEncoding="gb2312"%>
<jsp:useBean id="crm" class="test707.chatroom.ChatRoomMgr" />
  <% 
  //JS调用本页 将此用户从useronline列表中删除
  crm.logout((String)session.getAttribute("_USER"),(String)session.getAttribute("_CHAT_ROOM"));	
  response.sendRedirect("roomlist.jsp");
   %>
<!-- 本页任务：用户退出房间 并跳转到房间列表 -->

