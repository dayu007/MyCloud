<%@ page language="java"   contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<%@include file="sessioncheck.jsp" %>
<html>
  <head>
  <script type="text/javascript">
  	//定位页面锚点函数
  	function getPosition() {
  		window.location.hash="position";
  	}
  </script>
  </head>
  <body onload="getPosition()">
  <!-- 加载消息的页面 -->
  <iframe src="getmsg.jsp" id="getmsg" style="visibility:hidden;height:0" width="1"></iframe>
  <!-- 加载内容的位置，getmsg.jsp中，根据这个id loadContent 显示聊天内容 -->
  <span id="loadContent">数据加载中</span>
  <!-- 锚点位置,至于最下面，显示最新聊天内容 -->
  <a id="position"></a>
  </body>
</html>
<!-- 实现：锚点功能，scroll-bar能定位到最新消息
		  加载getmsg.jsp获取的消息也没问题 -->
<!-- 遗留问题，本来想通过getmsg.jsp中转取得消息，来隐藏刷新效果，结果却带来的反效果，声音也有，闪烁也有
			  -->