<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>

<html>
	<head>
		<title>µÇÂ¼</title>
		<link href="CSS/style.css" rel="stylesheet">
		<script type="text/javascript">
    	function chkempty() {
    		if(document.form1.user.value=="") {
    			alert("ÓÃ»§êÇ³Æ²»ÄÜ¿Õ");
    			document.form1.user.focus();
    			return false;
    		} 
    		if(document.form1.pass.value=="") {
    			alert("ÃÜÂë²»ÄÜÎª¿Õ");
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
        <td width="59" height="29"> êÇ ³Æ£º </td>
        <td width="98"><input type="text" name="user" width="50" /></td>
        <td width="67"><input type="submit" value="µÇÂ¼" /></td>
      </tr>
      <tr>
        <td height="32"> ÃÜ Âë£º </td>
        <td><input type="password" name="pass" width="50"/></td>
        <td><input type="submit" value="×¢²á" /></td>
      </tr>
    </table></td>
  </tr>
</table>

	
	
	
	</body>
</html>
