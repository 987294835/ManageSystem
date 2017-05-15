package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.order.bean.dishType;
import com.order.dao.foodTypeDao;
public class MFoodSaveServlet extends HttpServlet {
	
	private foodTypeDao foodTypedao=new foodTypeDao();

	/**
	 * 菜系名称session
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		   List<dishType> dishTypes = foodTypedao.findDishType();
		   request.setAttribute("dishTypes", dishTypes);
			request.getRequestDispatcher("/manage/food/saveUI.jsp").forward(request, response);
		   
		
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
