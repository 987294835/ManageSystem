﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单详细页</title>
<link rel="stylesheet" type="text/css" href="../css/index.css" />
</head>

<body>
<div id="all">
 <div id="menu1" >
   <div class="menu2" style="text-align:center;">
     <img src="../css/images/order_detials_bg.png" />
   </div>
   <form name="form1" id="dish_f1" method="post">
     <table  height="475px" >
       <tr>
         <td rowspan="3" width="300px" style="text-align:center">
           <img src="../css/images/pic_chicken.gif" />
         </td>
         <td>
           菜名：<span style="display:block; font-size:36px">中国式圣诞烤鸭</span>
         </td>
       </tr>
	   <tr>
         <td>
           非会员价格:&nbsp;&nbsp;&yen;&nbsp;150
         </td>
       </tr>
       <tr>
         <td>
           会员价格:&nbsp;&nbsp;&yen;&nbsp;100
         </td>
       </tr>
       <tr>
         <td>
          <span style="overflow:hidden"> 简介:中国式圣诞烤鸡属于私家菜菜谱</span>
         </td>
       </tr>
       <tr >
         <td>
           <a href="next_dish.jsp" style="background:url(../css/images/order_left_corner_bg.png); ">下单</a>
         </td>
         <td>
           <a href="javascript:history.go(-1);" style="background:url(../css/images/order_right_corner_bg.png); ">返回</a>
         </td>
       </tr>
     </table>
   </form>
 </div>
 <div id="dish_class">
   <div id="dish_top" >
     <ul>
       <li class="dish_num">33</li>
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
