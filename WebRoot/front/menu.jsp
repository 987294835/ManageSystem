﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜谱</title>
<link rel="stylesheet" type="text/css" href="../css/index.css" />
</head>

<body>
<div id="all">
 <!--左边-->
 <div id="menu">
 <div id="count">
  <form id="form1" name="form1" method="post">
    <table width="740" height="530">
      <tr height="40">
           <td>编号</td>
           <td>菜名</td>
           <td>价格</td>
           <td>会员价</td>
           <td>删除?</td>
         </tr>
         <tr height="30">
           <td>F001</td>
           <td>猪肺汤</td>
           <td>&yen;80</td>
           <td>&yen;70</td>
           <td><input type="checkbox" name="select" />是</td>
         </tr>
         <tr height="20">
           <td>F002</td>
           <td>猪骨汤</td>
           <td>&yen;100</td>
           <td>&yen;90</td>
           <td><input type="checkbox" name="select" />是</td>
         </tr>
         <tr height="20">
           <td>F003</td>
           <td>猪鞭汤</td>
           <td>&yen;120</td>
           <td>&yen;110</td>
           <td><input type="checkbox" name="select" />是</td>
         </tr>
     <tr>
        <td colspan="5" align="right">总计:</td>
        <td><label id="count" >&yen;270</label></td>
     </tr>
     <tr>
        <td colspan="6">
 	      <a href="#" class="btn_next">上一页</a>
          <a href="#">下一页</a>
          <a href="counter.jsp">结账</a>
          <a href="javascript:history.go(-1);">返回</a>
        </td>
     </tr>
    </table>
  </form>
 </div>
 </div>
 <!--右边-->
 <div id="dish_class">
  <div id="dish_top">
    <ul>
      <li class="dish_num">1</li>
      <li>
        <a href="menu.jsp"><img src="../css/images/call.gif" /></a>      </li>
    </ul>
  </div>
  <div id="dish_2">
    <ul>
      <li><a href="next_dish.jsp">粤菜</a></li>
      <li><a href="next_dish.jsp">江南菜</a></li>
      <li><a href="next_dish.jsp">民族菜</a></li>
      <li><a href="next_dish.jsp">湘菜</a></li>
    </ul>
  </div>
  <div id="dish_3">
    <form id="form2" method="post">
      <table width="166">
        <tr>
          <td>
            关键字:<input type="text" id="dish_name" class="select_value" />          </td>
        </tr>
        <tr>
          <td> 
            <a href="counter.jsp"><img src="../css/images/select.gif" /></a>          </td>
        </tr>
        <tr>
          <td>
            <a href="call_dish.jsp"><img src="../css/images/look.gif" /></a>          </td>
        </tr>
      </table>
    </form>
  </div>
 </div>
</div>
</body>
</html>
