<%@ page language="java" pageEncoding="gb2312"%>
<jsp:useBean id="crm" class="test707.chatroom.ChatRoomMgr" />
  <% 
  //JS���ñ�ҳ �����û���useronline�б���ɾ��
  crm.logout((String)session.getAttribute("_USER"));
  //sessionʧЧ
  session.invalidate();	
  //��ת����¼ҳ��
  response.sendRedirect("login.jsp");
   %>
