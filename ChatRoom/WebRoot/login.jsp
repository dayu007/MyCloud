<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>

<html>
	<head>
		<title>��¼</title>
		<link href="CSS/style.css" rel="stylesheet">
		<script type="text/javascript">
    	function chkempty() {
    		if(document.form1.user.value=="") {
    			alert("�û��ǳƲ��ܿ�");
    			document.form1.user.focus();
    			return false;
    		} 
    		if(document.form1.pass.value=="") {
    			alert("���벻��Ϊ��");
    			document.form1.pass.focus();
    			return false;
    		} else {
    			return true;
    		}
    		
    	}
    </script>
	</head>
	<body>
		<form action="logincheck.jsp" method="post" name="form1"
			onSubmit="return chkempty()">

<table width="363" height="224" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login.jpg">
  <tr>
    <td><table width="358" border="0">
      <tr>
        <td height="73">&nbsp;</td>
      </tr>
    </table>
      <table width="238" height="67" border="0" align="center"
>
      <tr>
        <td width="59" height="29"> �� �ƣ� </td>
        <td width="98"><input type="text" name="user" width="50" /></td>
        <td width="67"><input type="submit" value="��¼" /></td>
      </tr>
      <tr>
        <td height="32"> �� �룺 </td>
        <td><input type="password" name="pass" width="50"/></td>
        <td><input type="submit" value="ע��" /></td>
      </tr>
    </table></td>
  </tr>
</table>

	
	
	
	</body>
</html>
