<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index_1.css" />
<style type="text/css">
* {
	margin: 0px;
	padding: 0px
}
</style>
</head>

<body>
	<!--外部的大层-->
	<div class="index_all" style="text-align: center;">
		<!--上面的背景层-->
		<div>
			<img src="css/images/flower.gif" />
		</div>
		<!--中间层-->
		<div id="index_center">
			<!--中间层的空白层-->
			<div id="space"></div>

			<!--中间层的菜单层-->
			<div>
				<!--菜单层的左边-->
				<div id="index_centerleft"></div>

				<!--菜单层的中间-->
				<div class="bg_middle">
					<img src="css/images/index_menu.gif" border="0" usemap="#Map" />
					<map name="Map" id="Map">
						<area shape="rect" coords="164,99,354,199"
							href="front/call_dish.jsp" />
					</map>
				</div>

				<!--中间层的右边-->
				<div id="index_centerright"></div>
			</div>

			<!--放桌子的层-->
			<div id="center_bottom">
				<ul style="display: inline-table">
					<li><a href="front/call_dish.jsp">1</a></li>
					<li><a href="front/call_dish.jsp">2</a></li>
				</ul>
			</div>

		</div>
		<!--下面的背景层-->
		<div>
			<img src="css/images/flower.gif" />
		</div>
	</div>
</body>
</html>
