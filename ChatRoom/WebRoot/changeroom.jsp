<%@ page language="java" pageEncoding="gb2312"%>
<jsp:useBean id="crm" class="test707.chatroom.ChatRoomMgr" />
  <% 
  //JS���ñ�ҳ �����û���useronline�б���ɾ��
  crm.logout((String)session.getAttribute("_USER"),(String)session.getAttribute("_CHAT_ROOM"));	
  response.sendRedirect("roomlist.jsp");
   %>
<!-- ��ҳ�����û��˳����� ����ת�������б� -->

