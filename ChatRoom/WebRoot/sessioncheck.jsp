<%@ page language="java" pageEncoding="gb2312"%>
<%
	//session����û��Ƿ��¼
	String login = (String) session.getAttribute("_LOGIN");
	//���������������Ϊ�û�δ��¼��
	if (session.isNew() || login == null || !login.equals("_SUCCEED")) {
%>
<table width="954" align="center">

  <tr>
    <th height="137" scope="col"><img src="images/top.jpg" width="954" height="141" alt="" /></th>
  </tr>
  <tr>
    <td height="132"><table width="1008" height="134">
      <tr>
        <td width="469" height="125" align="right"> <h1> ��ӭ�������籾�����ң�</h1></td>
        <td width="469" align="center"><a href="login.jsp"><img src="images/login (2).png" ></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="205"><table width="957" height="144">
      <tr>
        <td width="268" height="138" align="right"><h2>�������ӣ�</h2></td>
        <td width="673"><table width="470" align="center">
          <tr>
            <td align="center"><a href="http://www.sie.edu.cn/">��������ѧԺ��ҳ </a></td>
          </tr>
          <tr>
            <td align="center"><a href="http://xinxi.sie.edu.cn/">��ϢѧԺ��ҳ </a></td>
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