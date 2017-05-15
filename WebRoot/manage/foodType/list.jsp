<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
    <title>菜系列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/page_common.js"></script>
    <link href="<%=basePath %>css/common_style_blue.css" rel="stylesheet" type="text/css" />
</head>
<body>


<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="<%=basePath %>css/images/title_arrow.gif"/> 菜系列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜系编号</td>
				<td>菜系名称</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
		
        <tbody id="TableData" align="center">
        <c:forEach var="dishTypes" items="${ requestScope.dishTypes}">
			<tr class="TableDetail1">
				<td width="100px">${dishTypes.dishType}</td>
				<td width="200px">${dishTypes.typeName}&nbsp;</td>
				<td>
					<a href="<%=basePath %>manage/foodType/updateUI.jsp?id=${dishTypes.dishType}" class="FunctionButton">修改</a>
					<a href="<%=basePath %>foodType/deleteFoodTypeServlet?id=${dishTypes.dishType}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
		</c:forEach>
			
        </tbody>
    </table>
	<!-- 其他功能超链接 -->
    <div id="TableTail">
		<div class="FunctionButton"><a href="<%=basePath %>manage/foodType/saveUI.jsp">新建</a></div>
    </div>
</div>


<!-- 分页信息 -->
<form action="">
	<div id="PaginationBar">
		<div id="PaginationBar_info">
			<span>页次：${pc.currentPage}/${pc.totalPages}页</span>
			<span>总记录数：${pc.totalRowsAmount}条 </span>
			<span>每页显示
				<select id="PaginationBar_PageSizeSelector" onClick="ChangePageSize(document.getElementById('PaginationBar_PageSizeSelector').value)">
					<option value="3">3</option>
					<option value="6">6</option>
					<option value="9">9</option>
				</select>
				条
			</span>
		</div>
		<div id="PaginationBar_PageSelectorArea">
			<table id="PaginationBar_TablePageNum" cellpadding="0" cellspacing="5" width="330px">
				<tr>
					<td>&nbsp;</td>
					<c:choose>
			          <c:when test="${pc.currentPage==1 }">
				        <td align="right"><a title="首页"><img src="<%=basePath %>css/images/pagination/first_page.png"/></a></td>
		              </c:when>
			       <c:otherwise>
				       <td align="right"><a href="<%=basePath %>foodType/foodTypePageServlet?currPage=${pc.previousPage }" title="首页"><img src="<%=basePath %>css/images/pagination/first_page.png"/></a></td>
		           </c:otherwise>
		           </c:choose>
					
					<c:forEach var="i" begin="1" end="${pc.totalPages}">
				    <td class="PageSelectorNum" onClick="gotoPage(${i})">${i}</td>
			       </c:forEach>
					
					
					
					<c:choose>
			          <c:when test="${pc.currentPage>=pc.totalPages }">
				       <td align="left"><a title="尾页"><img src="<%=basePath %>css/images/pagination/last_page.png"/></a></td>
		           </c:when>
			       <c:otherwise>
				      <td align="left"><a href="<%=basePath %>foodType/foodTypePageServlet?currPage=${pc.totalPages }" title="尾页"><img src="<%=basePath %>css/images/pagination/last_page.png"/></a></td>
			       </c:otherwise>
		           </c:choose>
					
				</tr>
			</table>
			<div id="PageSelector_PageNumInputArea">
				<span>转到</span>
				<input type="text" id="PageSelector_PageNumInput" maxlength="4" value="1" onFocus="this.select()" onClick="this.select()" onKeyPress="return submitPaginationFormByInput(event, this.value)"/>
				<img src="<%=basePath %>css/images/pagination/pageSelector_GoButton.png" id="PageSelector_SubmitImage" onClick="gotoPage( document.getElementById('PageSelector_PageNumInput').value )"/>
				<script type="text/javascript">
					// 定义总页码数
					var pageCount = 99;
				</script>
			</div>
		</div>
	</div>
</form>


<!-- 说明 -->
<div id="DescriptionArea">
</div>
<script  type="text/javascript">
	
		function gotoPage(index){
			window.location.href="<%=basePath %>foodType/foodTypePageServlet?currPage="+index;
		}
		function ChangePageSize(index){
			 window.location.href="<%=basePath %>foodType/foodTypeChangeServlet?pageSize="+index;
		}
		
	   
		
		
	</script>

</body>
</html>
