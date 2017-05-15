<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>下级菜单页</title>

<link href="../css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
  <div id="menu">
    <div id="top">
      <ul>
        <li>
         <dl>
         <dt>
           <a href="dish_message.jsp"><img src="../css/images/pic6.jpg" /></a>
         </dt>
         <dd class="f1">
           <a href="dish_message.jsp">川北凉粉</a>
         </dd>
         <dd class="f2">
           <a href="dish_message.jsp">&yen;88</a>
           </dd>
         </dl>
  </li>
        <li>
         <dl>
         <dt>
           <a href="dish_message.jsp"><img src="../css/images/pic7.jpg" /></a>
         </dt>
         <dd class="f1">
           <a href="dish_message.jsp">川式蛋炒虾</a>
         </dd>
         <dd class="f2">
           <a href="dish_message.jsp">&yen;120</a>
           </dd>
         </dl>
  </li>
  		<li>
         <dl>
         <dt>
           <a href="dish_message.jsp"><img src="../css/images/pic4.jpg" /></a>
         </dt>
         <dd class="f1">
           <a href="dish_message.jsp">夫妻肺片</a>
         </dd>
         <dd class="f2">
           <a href="dish_message.jsp">&yen;99</a>
           </dd>
         </dl>
  </li>
  		<li>
         <dl>
         <dt>
           <a href="dish_message.jsp"><img src="../css/images/pic8.jpg" /></a>
         </dt>
         <dd class="f1">
           <a href="dish_message.jsp">干锅牛蛙</a>
         </dd>
         <dd class="f2">
           <a href="dish_message.jsp">&yen;125</a>
           </dd>
         </dl>
  </li>
  		<li>
         <dl>
         <dt>
           <a href="dish_message.jsp"><img src="../css/images/pic5.jpg" /></a>
         </dt>
         <dd class="f1">
           <a href="dish_message.jsp">宫保鸡丁</a>
         </dd>
         <dd class="f2">
           <a href="dish_message.jsp">&yen;75</a>
           </dd>
         </dl>
  </li>
  		<li>
         <dl>
         <dt>
           <a href="dish_message.jsp"><img src="../css/images/pic5.jpg" /></a>
         </dt>
         <dd class="f1">
           <a href="dish_message.jsp">口味小龙虾</a>
         </dd>
         <dd class="f2">
           <a href="dish_message.jsp">&yen;188</a>
           </dd>
         </dl>
  </li>
      </ul>
    </div>
    <div id="foot" >
     <span style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
       <a href="#" style=" text-decoration:none;color:#000000">&lt;&lt;</a>
     </span>
     <div id="btn">
       <ul>
         <li><a href="next_dish.jsp">1</a></li>
         <li><a href="next_dish.jsp">2</a></li>
         <li><a href="next_dish.jsp">3</a></li>
         <li><a href="next_dish.jsp">4</a></li>
         <li><a href="next_dish.jsp">5</a></li>
         <li><a href="next_dish.jsp">6</a></li>
         <li><a href="next_dish.jsp">7</a></li>
         <li><a href="next_dish.jsp">8</a></li>
         <li><a href="next_dish.jsp">9</a></li>
      </ul>
    </div>
     <div id="num">
      <form id="form1" method="post">
        <input type="text" name="number" />
        <a href="dish_message.jsp">跳转</a>
      </form>
    </div>
     <span style="float:right; line-height:53px; margin-right:10px;  ">
       <a href="#" style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
     </span>
    </div>
  </div>
  <div id="dish_class">
   <div id="dish_top">
     <ul>
       <li class="dish_num">1</li>
       <li><a href="menu.jsp"><img src="../css/images/call.gif" /></a></li>
     </ul>
   </div>
   <div id="dish_2">
     <ul>
       <li><a href="yueCai.jsp">粤 菜</a></li>
       <li><a href="jiangnanCai.jsp">江南菜</a></li>
       <li><a href="minzuCai.jsp">民族菜</a></li>
       <li><a href="xiangCai.jsp">湘 菜</a></li>
     </ul>
  </div>
   <div id="dish_3">
     <form id="form2" target="blank" name="form2" action="next_dish_result.jsp"> 
       <table width="166px">
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
