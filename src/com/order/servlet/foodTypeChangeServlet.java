package com.order.servlet;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.dao.foodTypeDao;
import com.order.bean.dishType;
import com.order.utils.PageController;

/**
 * 普通分页查询
 */
public class foodTypeChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private foodTypeDao foodtypeDao = new foodTypeDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public foodTypeChangeServlet() {
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
		int totalRows = foodtypeDao.getTotalRows();
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		//PageController pc = new PageController(totalRows, 1);	//每一页显示3条记录
		PageController pc = new PageController(totalRows, 1, pageSize); //每一页显示pageSize条记录
		request.getSession().setAttribute("pc", pc);
				
		List<dishType> dishTypes = foodtypeDao.findDishType(pc);
		
		request.setAttribute("dishTypes", dishTypes);
		request.getRequestDispatcher("/manage/foodType/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
