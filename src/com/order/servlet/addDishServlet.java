package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.dish;
import com.order.bean.dishType;
import com.order.dao.MFoodDao;
import com.order.dao.foodTypeDao;


public class addDishServlet extends HttpServlet {
	
	private MFoodDao MFoodDao=new MFoodDao();
	private foodTypeDao foodtypedao=new foodTypeDao();

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
		 //获得用户请求参数
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String dishName=request.getParameter("foodName");
		Float price=Float.parseFloat(request.getParameter("price"));
		String dishesc=request.getParameter("introduce");
		Float Vprice=Float.parseFloat(request.getParameter("mprice"));
		String typeName=request.getParameter("fid");//所属菜系
		String isroot=request.getParameter("isroot");//是否置顶
		

		dish dish=new dish();
		dish.setDishName(dishName);
		dish.setPrice(price);
		dish.setDishdesc(dishesc);
		dish.setVprice(Vprice);
		dish.setTypeName(typeName);
		
		
		//存入数据库
		try{
			
			
			
			MFoodDao.add(dish);
			request.getSession().setAttribute("dish", dish);
			response.sendRedirect("<%=basePath %>food/MFoodListServlet");//跳转到首页
		}
		catch(Exception e){
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
