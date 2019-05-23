package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletResponse
		//向浏览器输出信息
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//重定向请求
		//response.sendRedirect(request.getContextPath()+"/CServlet");
		response.sendRedirect(request.getContextPath()+"/WEB-INF/pages/student.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest
		//1.获取请求参数
		String username = request.getParameter("username");
		String[] hobby = request.getParameterValues("hobby");
		System.out.println("姓名："+username);
		System.out.println("hobby："+hobby.length);
		for (String str : hobby) {
			System.out.println(str);
		}
		
		//2.获取上下文路径或servlet路径   http://localhost:8080/day05_servlet/BServlet
		String contextPath = request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		String servletPath = request.getServletPath();//若urlPatten设置成/*将返回空串
		System.out.println("servletPath:"+servletPath);
		
		//3.是一个域对象 ，用来共享数据
		//4.可以转发请求
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CServlet");
//		requestDispatcher.forward(request, response);
		
		request.getRequestDispatcher("/WEB-INF/pages/student.html").forward(request, response);
		
	}

}
