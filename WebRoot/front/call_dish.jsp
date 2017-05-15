﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>点菜页</title>
<link rel="stylesheet" type="text/css" href="../css/index.css" />
</head>

<body>
<div id="all">
 <div id="menu">
   <ul class="day">
     <li><p>每日推荐</p><a href="next_dish.jsp"><img src="../css/images/cai.gif" /></a></li>
     <li><p>今日推荐</p><a href="next_dish.jsp"><img src="../css/images/pic1.jpg" /></a></li>
     <li><p>热门推荐</p><a href="next_dish.jsp"><img src="../css/images/pic10.jpg" /></a></li>
     <li><p>最新菜色</p><a href="next_dish.jsp"><img src="../css/images/pic11.jpg" /></a></li>
     <li><p>最美推荐</p><a href="next_dish.jsp"><img src="../css/images/pic12.jpg" /></a></li>
     <li><p>季节推荐</p><a href="next_dish.jsp"><img src="../css/images/pic13.jpg" /></a></li>
   </ul>
   <div id="space"></div>
   <div class="menu_next">
   	 <div style="margin:0 auto; width:350px;" >
       <a href="#" class="btn_next" style="height:40px; float:left">下一页</a>
       <a href="#" class="btn_next" style="height:40px; float:left">上一页</a>
     </div>
   </div>
 </div>
 <div id="dish_class">
   <div id="dish_top" >
     <ul>
       <li class="dish_num">1</li>
       <li><a href="menu.jsp"><img src="../css/images/call.gif" /></a></li>
     </ul>
   </div>
   <div id="dish_2" >
     <ul>
       <li><a href="next_dish.jsp">粤 菜</a></li>
       <li><a href="next_dish.jsp">江南菜</a></li>
       <li><a href="next_dish.jsp">民族菜</a></li>
       <li><a href="next_dish.jsp">湘 菜</a></li>
     </ul>
   </div>
   <div id="dish_3" >
     <form id="form2" target="blank" name="form2" action="next_dish_result.jsp">
       <table width="166px">
         <tr>
           <td>
             关键字:<input type="text" id="dish_name" class="select_value" />           </td>
         </tr>
         <tr>
           <td>
             <a href="#" onclick="document.form2.submit()"><img src="../css/images/select.gif" /></a>           </td>
         </tr>
         <tr>
           <td>
             <a href="call_dish.jsp"><img src="../css/images/look.gif" /></a>           </td>
         </tr>
       </table>
     </form>
   </div>
 </div>
</div>
</body>
</html>
