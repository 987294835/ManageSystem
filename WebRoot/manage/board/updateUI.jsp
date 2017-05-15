<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>餐桌信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/page_common.js"></script>
<script type="text/javascript" src="../../js/board.js"></script>
<link href="../../css/common_style_blue.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	function openWin() {
		window.open('common_page_list.jsp');
		this.close();
	}
</script>
</head>
<body>
<%
  int id=Integer.parseInt(request.getParameter("id"));
  String tname=request.getParameter("tname");
  tname=new String(tname.getBytes("ISO8859-1"),"UTF-8");
  String status=request.getParameter("status");
  status=new String(status.getBytes("ISO8859-1"),"UTF-8");
  String cname=request.getParameter("cname");
  cname=new String(cname.getBytes("ISO8859-1"),"UTF-8");
  String date=request.getParameter("date");
 %>

	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="../../css/images/title_arrow.gif" /> 更改餐桌信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="<%= basePath %>board/MBoardUpdateServlet" method="post">

			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="../../css/images/item_point.gif" /> 餐桌信息&nbsp;
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr >
								<td>名称</td>
								<td><input type="text" name="boardName" class="InputStyle" value="<%= tname%>"/></td>
								<td><input type="hidden" name="id" value="<%= id%>"/></td>		
							</tr>
							<tr>
								<td>状态</td>
								<td><select id="isBook" name="isBook"
									onchange="showOrHideBookTimeTr()">
										<option value="空闲"
											>空闲</option>
										<option value="预订"
											selected='selected'>预定</option>
								</select></td>
							</tr>

							<tr id="bookNameTr" >
								<td width="80px">预定人</td>
								<td><input type="text" name="bookName" class="InputStyle"
									value="<%= cname%>" /></td>
							</tr>

							<tr id="bookTimeTr">
								<td>预定时间</td>
								<td><input type="text" name="bookTime"
									value="<%= date%>" /></td>
							</tr>

						</table>
					</div>
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="更改" class="FunctionButtonInput" /> <a
					href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>

			<input type="hidden" name="id" value="3" />
		</form>

	</div>




</body>
</html>
