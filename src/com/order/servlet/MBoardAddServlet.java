package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.table;
import com.order.dao.MBoardDao;;

public class MBoardAddServlet extends HttpServlet {
    
	private MBoardDao MBoardDao=new MBoardDao();
     
	/**
	 * 新增菜品类
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //获得用户请求参数
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("boardName");
		String status=request.getParameter("isBook");
		table table=new table();
		table.setTable_name(name);
		table.setStatus(status);
		//存入数据库
		try{
			MBoardDao.add(table);
			request.getSession().setAttribute("table", table);
			response.sendRedirect("<%=basePath %>board/BoradListServlet");//跳转到首页
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
