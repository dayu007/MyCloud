<%@ page language="java"  pageEncoding="gb2312"%>
<jsp:useBean id="checker" class="test707.chatroom.UserInfoMgr" /> 
<jsp:useBean id="register" class="test707.chatroom.UserInfoMgr" /> 
<%
	request.setCharacterEncoding("gb2312");
	//表单接收参数用户名密码user,pass 空值判断已经在login.jsp通过JS实现
	String user  = request.getParameter("user");
	String pass = request.getParameter("pass");
	//验证用户名密码，判断返回值来确定验证成功与否
	String checkOut = checker.check(user,pass); 
	if(checkOut.equals("_LOGIN_SUCCEED")) {
		//登陆成功有设置session属性 _USER,_LOGIN
		session.setAttribute("_USER",user);
		session.setAttribute("_LOGIN", "_SUCCEED");
		//跳转到成功页面
		response.sendRedirect("roomlist.jsp");
	} else if(checkOut.equals("_WRONG_PASS")) {
		out.println("您输入的用户或密码错误，请重新输入");
		if(session.getAttribute("_LOGIN") != null) {
			session.removeAttribute("_LOGIN");
		}
	} else if(checkOut.equals("_WRONG_USER")) {
		response.sendRedirect("register.jsp");
	/*
		//如果输入用户名在数据库中不存，直接注册
		if(register.savaToDB(user,pass)) {
			session.setAttribute("_USER",user);
			session.setAttribute("_LOGIN", "_SUCCEED");
			//跳转到成功页面
			response.sendRedirect("roomlist.jsp");
		}
		*/
	}
%>

