package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.dish;
import com.order.dao.MFoodDao;
import com.order.utils.PageController;

public class MFoodPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//ctrl+shift+o
    private MFoodDao MFoodDao = new MFoodDao();   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MFoodPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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

		int currPage = Integer.parseInt(request.getParameter("currPage"));
		PageController pc = (PageController) request.getSession().getAttribute("pc");
		pc.setCurrentPage(currPage);
		List<dish> dishs = MFoodDao.findDish(pc);
		
		request.setAttribute("dishs", dishs);
		request.getRequestDispatcher("/manage/food/list.jsp").forward(request, response);
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
