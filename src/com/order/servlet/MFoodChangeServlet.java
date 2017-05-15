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

public class MFoodChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MFoodDao foodDao = new MFoodDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MFoodChangeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		//ctrl+!
		List<Emp> emps = empDao.findEmps();
		request.setAttribute("emps", emps);
		//跳转到显示数据的页面
		request.getRequestDispatcher("/empList.jsp").forward(request, response);
//		response.sendRedirect(arg0);
*/
		//分页显示，默认是显示第一页
		int totalRows = foodDao.getTotalRows();
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		//PageController pc = new PageController(totalRows, 1);	//每一页显示3条记录
		PageController pc = new PageController(totalRows, 1, pageSize); //每一页显示pageSize条记录
		request.getSession().setAttribute("pc", pc);
				
		List<dish> dishs = foodDao.findDish(pc);
		
		request.setAttribute("dishs", dishs);
		request.getRequestDispatcher("/manage/food/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
