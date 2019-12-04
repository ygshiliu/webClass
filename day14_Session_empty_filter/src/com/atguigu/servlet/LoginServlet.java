package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现退出有两种方式 
		//1种是将session中的用户移除
		//2种是将session失效
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		
		//对比(假设只要提交了，用户就可以登录成功)
		//怎样表示用户登录成功了呢？
		//我们可以将用户信息设置到域中，如果有用户对象 ，代表登录成功，否则没有登录
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		
		//返回首页
		response.sendRedirect("index.jsp");
	}

}
