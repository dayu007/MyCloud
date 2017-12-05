<%@ page language="java" pageEncoding="gb2312"%>
<%
	//session检测用户是否登录
	String login = (String) session.getAttribute("_LOGIN");
	//这三种情况，都视为用户未登录；
	if (session.isNew() || login == null || !login.equals("_SUCCEED")) {
%>
<table width="954" align="center">

  <tr>
    <th height="137" scope="col"><img src="images/top.jpg" width="954" height="141" alt="" /></th>
  </tr>
  <tr>
    <td height="132"><table width="1008" height="134">
      <tr>
        <td width="469" height="125" align="right"> <h1> 欢迎来到网络本聊天室！</h1></td>
        <td width="469" align="center"><a href="login.jsp"><img src="images/login (2).png" ></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="205"><table width="957" height="144">
      <tr>
        <td width="268" height="138" align="right"><h2>友情链接：</h2></td>
        <td width="673"><table width="470" align="center">
          <tr>
            <td align="center"><a href="http://www.sie.edu.cn/">沈阳工程学院主页 </a></td>
          </tr>
          <tr>
            <td align="center"><a href="http://xinxi.sie.edu.cn/">信息学院主页 </a></td>
          </tr>
        </table></td>
      </tr>
    </table>
      <p>&nbsp;</p>
    <p>&nbsp;          </p></td>
  </tr>
</table>
	
	<%
		return;
		}
	%>