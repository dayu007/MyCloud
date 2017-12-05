<html>
<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="java.util.*"%>
<%@ page import="test707.chatroom.*"%>
<jsp:useBean id="msg" class="test707.chatroom.Msg" />
<head>
<!-- js实现刷新，无声音 每2秒刷新一次页面-->
<script language="javascript">
function myRefresh() {
	 var timeoutid = setTimeout("window.location.reload()",2000);
}
</script> 
</head>
<body onload="myRefresh()">

<%
	request.setCharacterEncoding("GB2312") ;
	String msgString = "";
	String username = (String)session.getAttribute("_USER");
	String chatroom = (String)session.getAttribute("_CHAT_ROOM");
	//String chatroom = "谈天说地"; //暂时不用session取值
	//获取容器
	ArrayList msgs = msg.getTopMsg(35,chatroom);
	//判断有值 并依次打印出来
	if(msgs==null){
%>
		<h2>...</h2>
<%
	}else{
		Iterator iter = msgs.iterator() ;
		while(iter.hasNext()){
		Msg m = (Msg)iter.next();
			if(m.getMsgfrom().equals("系统公告")) {
				msgString += "<div>"+m.getMsgfrom()+": "+m.getMsgcontent()+"</div>";
			} else if(m.getSecret() == 0) {
				msgString += "<div>"+m.getMsgfrom()+" 对 "+m.getMsgto()+" "+m.getChataction()
				+""+m.getMsgcontent()+"</div>";
			} else if(m.getMsgfrom().equals(username) || m.getMsgto().equals(username)) {
				msgString += "<div><font color='red'>[悄悄话]</font>"+m.getMsgfrom()+" 对 "+m.getMsgto()+" "+m.getChataction()
				+""+m.getMsgcontent()+"</div>";
			}
		}
	}
%>
<script language="javascript">
	//showmsg.jsp中<span id ="loadContent"> 这是想对应的
	parent.loadContent.innerHTML="<%=msgString%>";
	//parent.location.hash="position";
</script>
</body>
</html>

