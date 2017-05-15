<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
	<frame src="manage/home/top.jsp" scrolling="no" noresize />
	<frameset cols="178px,*" framespacing="0" border="0" frameborder="no">
		<frame noresize src="manage/home/left.jsp" scrolling="yes" />
		<frame noresize name="right" src="manage/home/right.jsp" scrolling="yes" />
	</frameset>
	<frame noresize name="status_bar" scrolling="no" src="manage/home/bottom.jsp" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
