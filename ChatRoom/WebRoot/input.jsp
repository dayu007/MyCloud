<%@ page language="java" pageEncoding="gb2312"%>
<html>
  <head>
    <script language="javascript">
    	//���msg�Ƿ�Ϊ��
		function checkForm() {
    		if(document.inputForm.msg.value.length==0) {
    			alert("�ύ����Ϣ����Ϊ��");
    			document.inputForm.msg.focus();
    			return false;
    		} else {
    			//onunload����Ϊ�գ�
    			//document.body.onunload="";
    			document.inputForm.msg.focus();
    			return true;
    		}
    	}
    	
    	//�û��뿪������ת��logout.jsp����
    	function userLogout() {
   			top.window.location="logout.jsp";
   			return true;
    	}
    	//�������䣬��ת��changeroom.jsp����
    	function changeRoom() {
    		//onunload����Ϊ�գ������뿪��ҳ������ֱ����ת��login.jsp
    		document.body.onunload="";
			top.window.location="changeroom.jsp";
   			return true;
		}
		//�������ڣ���ʾ����Ա�߼�����	
  		function openWindow(url) {
			var newWin = window.open(url,"","toolbar=no,statur=no,scrollbars=yes,menubar=no,width=450,height=320");
			return false;
		}
  </script>
  </head>
  <!-- �˳���ҳ����ر������ʱ����� -->
  <body onunload="return userLogout()">
  	<form name="inputForm" target="theIframe" action="sendmsg.jsp" method="post" >
	<table border="0" align="left" cellpadding="0" cellspacing="0">
	<tr valign="top">  
	��<input type="text" name="msgto" size="8" value="������" readonly>
	��������<select name="chataction" size="1">
	 	<option value="˵��" selected>˵��</option>
		<option value="������������˵��">����</option>
		<option value="Ц�Ǻǵ�˵��">΢Ц</option>
		<option value="ֱ��һ�����ǣ�˵��">����</option>
        <option  value="�䲻��ʹ��һ�С����ӱ����ơ������ң��ٲ�һ����˪�����ǡ��������һ��˵����">CGN</option>
        </select>
		<input type="checkbox" name="secret"  value="yes">���Ļ�
    <a href="manager.jsp" onClick="return openWindow(this.href);">�߼�����</a>
    <tr>
    <td><input type="text" name="msg" size=60> 
    <td> &nbsp;��ɫ<select name="color">
			 <option  style="color:#000000"value="#000000">��ɫ</option>
			 <option style="color:#FF0000" value="FF0000">��ɫ</option>
			 <option style="color:#00CC00" value="#00CC00">��ɫ</option>
			 <option style="color:#0066CC" value="#0066CC">��ɫ</option>
			 <option style="color:#FF3300" value="#FF3300">��ɫ</option>
			 </select>	
	<input type="submit" name = "submit" value="�ύ" onClick="return checkForm();"> 
	</table>
	<input type="button" value="�л�������" onClick="return changeRoom();">
	<input type="button" value="�뿪������" onClick="return userLogout();">
<iframe id="theIframe" name="theIframe" width="0" height="0"></iframe>
	</form>
  </body>
</html>
