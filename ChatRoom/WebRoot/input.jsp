<%@ page language="java" pageEncoding="gb2312"%>
<html>
  <head>
    <script language="javascript">
    	//检测msg是否为空
		function checkForm() {
    		if(document.inputForm.msg.value.length==0) {
    			alert("提交的消息不能为空");
    			document.inputForm.msg.focus();
    			return false;
    		} else {
    			//onunload设置为空，
    			//document.body.onunload="";
    			document.inputForm.msg.focus();
    			return true;
    		}
    	}
    	
    	//用户离开房间跳转到logout.jsp处理
    	function userLogout() {
   			top.window.location="logout.jsp";
   			return true;
    	}
    	//更换房间，跳转到changeroom.jsp处理
    	function changeRoom() {
    		//onunload设置为空，这样离开本页不至于直接跳转到login.jsp
    		document.body.onunload="";
			top.window.location="changeroom.jsp";
   			return true;
		}
		//弹出窗口，显示管理员高级功能	
  		function openWindow(url) {
			var newWin = window.open(url,"","toolbar=no,statur=no,scrollbars=yes,menubar=no,width=450,height=320");
			return false;
		}
  </script>
  </head>
  <!-- 退出本页，或关闭浏览器时会调用 -->
  <body onunload="return userLogout()">
  	<form name="inputForm" target="theIframe" action="sendmsg.jsp" method="post" >
	<table border="0" align="left" cellpadding="0" cellspacing="0">
	<tr valign="top">  
	对<input type="text" name="msgto" size="8" value="所有人" readonly>
	动作表情<select name="chataction" size="1">
	 	<option value="说：" selected>说话</option>
		<option value="紧紧地握着手说：">握手</option>
		<option value="笑呵呵地说：">微笑</option>
		<option value="直接一个飞吻，说：">飞吻</option>
        <option  value="冷不丁使用一招‘冰河爆裂破’，车砸，再补一个‘霜冻新星’，最后补上一刀说道：">CGN</option>
        </select>
		<input type="checkbox" name="secret"  value="yes">悄悄话
    <a href="manager.jsp" onClick="return openWindow(this.href);">高级功能</a>
    <tr>
    <td><input type="text" name="msg" size=60> 
    <td> &nbsp;颜色<select name="color">
			 <option  style="color:#000000"value="#000000">黑色</option>
			 <option style="color:#FF0000" value="FF0000">红色</option>
			 <option style="color:#00CC00" value="#00CC00">绿色</option>
			 <option style="color:#0066CC" value="#0066CC">蓝色</option>
			 <option style="color:#FF3300" value="#FF3300">橙色</option>
			 </select>	
	<input type="submit" name = "submit" value="提交" onClick="return checkForm();"> 
	</table>
	<input type="button" value="切换聊天室" onClick="return changeRoom();">
	<input type="button" value="离开聊天室" onClick="return userLogout();">
<iframe id="theIframe" name="theIframe" width="0" height="0"></iframe>
	</form>
  </body>
</html>
