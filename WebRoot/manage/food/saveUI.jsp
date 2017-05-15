<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>保存菜品信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%= basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath%>js/page_common.js"></script>
<link href="<%= basePath%>css/common_style_blue.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	function openWin() {
		window.open('common_page_list.jsp');
		this.close();
	}
</script>
</head>
<body>&nbsp; 

 
 
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="<%= basePath%>css/images/title_arrow.gif" /> 保存菜品信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="<%= basePath%>food/addDishServlet"  method="post">

			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="<%= basePath%>css/images/item_point.gif" /> 菜品信息&nbsp;
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">

							

							<tr>
								<td width="80px">所属菜系</td>
								<td><select name="fid" style="width: 120px">
								
								   <c:forEach var="dishTypes" items="${ requestScope.dishTypes}">		
											<option value="${dishTypes.typeName}">${dishTypes.typeName}</option>
										
											
								</c:forEach>
								</select> *</td>
							</tr>



							<tr>
								<td width="80px">菜名</td>
								<td><input type="text" name="foodName" class="InputStyle" />
									*</td>
							</tr>
							
							<!--
                        <tr>
							<td width="80px">照片</td>
							<td><input type="file" name="photo" class="InputStyle"/> *</td>
						</tr>
						-->
						
						<!--
						<tr>
							<td width="80px">照片</td>
							<td align="center">
							 	<img src="<%= basePath%>images/pic1_9.jpg" width="100px" height="100px">
							 </td>
						</tr>
						-->
							


							<tr>
								<td>价格</td>
								<td><input type="text" name="price" class="InputStyle" />
									*</td>
							</tr>
							<tr>
								<td>会员价格</td>
								<td><input type="text" name="mprice" class="InputStyle" />
									*</td>
							</tr>

							<tr>
								<td>简介</td>
								<td><textarea name="introduce" class="TextareaStyle"></textarea></td>
							</tr>
							
							<tr>
								<td>顶置</td>
								<td>
									是<input type="radio" name="isRoot"/>&nbsp;
									否<input type="radio" name="isRoot"/>
								</td>
							</tr>

						</table>
					</div>
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="添加" class="FunctionButtonInput" /> <a
					href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>

	</div>




</body>
</html>
