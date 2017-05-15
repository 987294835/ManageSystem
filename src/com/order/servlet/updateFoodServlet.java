package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.order.bean.dish;
import com.order.dao.MFoodDao;;

public class updateFoodServlet extends HttpServlet {
	
	private MFoodDao MFoodDao=new MFoodDao();

	/**
	 * 修改菜系类
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //解决编码问题，最后可写一个过滤器
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取客户请求参数
		
		String tname=request.getParameter("tname"); //菜系名
		int id=Integer.parseInt(request.getParameter("id"));//菜品编号
		String fname=request.getParameter("loginName");//菜品名
		float price=Float.parseFloat(request.getParameter("price"));//价格
		float vprice=Float.parseFloat(request.getParameter("vprice"));//会员价格
		String dishdesc=request.getParameter("description");//简介		
		
		dish dish=new dish();
		dish.setTypeName(tname);
		dish.setId(id);
		dish.setDishName(fname);
		dish.setPrice(price);
		dish.setVprice(vprice);
		dish.setDishdesc(dishdesc);
		
		//更改数据库
		try{
			MFoodDao.update(dish);
			request.getSession().setAttribute("dish", dish);
			response.sendRedirect("<%=basePath %>food/MFoodListServlet");//跳转到首页
			
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
