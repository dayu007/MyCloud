<%@ page language="java"   contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<%@include file="sessioncheck.jsp" %>
<html>
  <head>
  <script type="text/javascript">
  	//��λҳ��ê�㺯��
  	function getPosition() {
  		window.location.hash="position";
  	}
  </script>
  </head>
  <body onload="getPosition()">
  <!-- ������Ϣ��ҳ�� -->
  <iframe src="getmsg.jsp" id="getmsg" style="visibility:hidden;height:0" width="1"></iframe>
  <!-- �������ݵ�λ�ã�getmsg.jsp�У��������id loadContent ��ʾ�������� -->
  <span id="loadContent">���ݼ�����</span>
  <!-- ê��λ��,���������棬��ʾ������������ -->
  <a id="position"></a>
  </body>
</html>
<!-- ʵ�֣�ê�㹦�ܣ�scroll-bar�ܶ�λ��������Ϣ
		  ����getmsg.jsp��ȡ����ϢҲû���� -->
<!-- �������⣬������ͨ��getmsg.jsp��תȡ����Ϣ��������ˢ��Ч�������ȴ�����ķ�Ч��������Ҳ�У���˸Ҳ��
			  -->