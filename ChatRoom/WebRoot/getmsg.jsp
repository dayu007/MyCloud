<html>
<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="java.util.*"%>
<%@ page import="test707.chatroom.*"%>
<jsp:useBean id="msg" class="test707.chatroom.Msg" />
<head>
<!-- jsʵ��ˢ�£������� ÿ2��ˢ��һ��ҳ��-->
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
	//String chatroom = "̸��˵��"; //��ʱ����sessionȡֵ
	//��ȡ����
	ArrayList msgs = msg.getTopMsg(35,chatroom);
	//�ж���ֵ �����δ�ӡ����
	if(msgs==null){
%>
		<h2>...</h2>
<%
	}else{
		Iterator iter = msgs.iterator() ;
		while(iter.hasNext()){
		Msg m = (Msg)iter.next();
			if(m.getMsgfrom().equals("ϵͳ����")) {
				msgString += "<div>"+m.getMsgfrom()+": "+m.getMsgcontent()+"</div>";
			} else if(m.getSecret() == 0) {
				msgString += "<div>"+m.getMsgfrom()+" �� "+m.getMsgto()+" "+m.getChataction()
				+""+m.getMsgcontent()+"</div>";
			} else if(m.getMsgfrom().equals(username) || m.getMsgto().equals(username)) {
				msgString += "<div><font color='red'>[���Ļ�]</font>"+m.getMsgfrom()+" �� "+m.getMsgto()+" "+m.getChataction()
				+""+m.getMsgcontent()+"</div>";
			}
		}
	}
%>
<script language="javascript">
	//showmsg.jsp��<span id ="loadContent"> �������Ӧ��
	parent.loadContent.innerHTML="<%=msgString%>";
	//parent.location.hash="position";
</script>
</body>
</html>

