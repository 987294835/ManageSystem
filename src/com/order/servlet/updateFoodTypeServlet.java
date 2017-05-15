package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.order.bean.dishType;
import com.order.dao.foodTypeDao;

public class updateFoodTypeServlet extends HttpServlet {
	
	private foodTypeDao foodtypedao=new foodTypeDao();

	/**
	 * 修改菜系类
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //解决编码问题，最后可写一个过滤器
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取客户请求参数
		String name=request.getParameter("loginName");
		int id=Integer.parseInt(request.getParameter("id"));
		dishType dishtype=new dishType();
		dishtype.setDishType(id);
		dishtype.setTypeName(name);
		//更改数据库
		try{
			foodtypedao.update(dishtype);
			request.getSession().setAttribute("dishtype", dishtype);
			response.sendRedirect("<%=basePath %>foodType/ListServlet");//跳转到首页
			
		}
		catch(Exception e)//异常处理
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
