<%@ page language="java"  pageEncoding="gb2312"%>
<jsp:useBean id="checker" class="test707.chatroom.UserInfoMgr" /> 
<jsp:useBean id="register" class="test707.chatroom.UserInfoMgr" /> 
<%
	request.setCharacterEncoding("gb2312");
	//�����ղ����û�������user,pass ��ֵ�ж��Ѿ���login.jspͨ��JSʵ��
	String user  = request.getParameter("user");
	String pass = request.getParameter("pass");
	//��֤�û������룬�жϷ���ֵ��ȷ����֤�ɹ����
	String checkOut = checker.check(user,pass); 
	if(checkOut.equals("_LOGIN_SUCCEED")) {
		//��½�ɹ�������session���� _USER,_LOGIN
		session.setAttribute("_USER",user);
		session.setAttribute("_LOGIN", "_SUCCEED");
		//��ת���ɹ�ҳ��
		response.sendRedirect("roomlist.jsp");
	} else if(checkOut.equals("_WRONG_PASS")) {
		out.println("��������û��������������������");
		if(session.getAttribute("_LOGIN") != null) {
			session.removeAttribute("_LOGIN");
		}
	} else if(checkOut.equals("_WRONG_USER")) {
		response.sendRedirect("register.jsp");
	/*
		//��������û��������ݿ��в��棬ֱ��ע��
		if(register.savaToDB(user,pass)) {
			session.setAttribute("_USER",user);
			session.setAttribute("_LOGIN", "_SUCCEED");
			//��ת���ɹ�ҳ��
			response.sendRedirect("roomlist.jsp");
		}
		*/
	}
%>

