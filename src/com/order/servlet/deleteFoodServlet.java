package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.order.bean.dish;
import com.order.dao.MFoodDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class deleteFoodServlet extends HttpServlet {

	private MFoodDao MFoodDao=new MFoodDao();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决编码问题，最后可写一个过滤器
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取客户请求参数
		int id=Integer.parseInt(request.getParameter("id"));
		
		dish dish=new dish();
		dish.setId(id);
		//删除数据库中的数据
		try{
			MFoodDao.delete(dish);
			request.getSession().setAttribute("dish", dish);
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
