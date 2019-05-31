package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"--"+password);
		//业务处理
		if(username.equals("admin") && password.equals("123456")) {
			//成功
			System.out.println("转发。。。");
			request.getRequestDispatcher(/*request.getContextPath()+*/"/pages/user/login_success.html").forward(request, response);
		}else {
			//失败
			System.out.println("重定向。。。");
			//request.getRequestDispatcher("/pages/user/error.html").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/pages/user/error.html");
		}
		//返回响应
		
//		// 设置浏览器字符集编码. 
//		response.setHeader("Content-Type","text/html;charset=UTF-8");
//		// 设置response的缓冲区的编码.
//		response.setCharacterEncoding("UTF-8");
		
		//服务器设置编码字符集
//		response.setCharacterEncoding("UTF-8");//只设置服务器端的编码，而浏览器端使用默认的字符集解码，不同浏览器有不同的字符集
//		response.setHeader("Content-Type", "text/html;charset=UTF-8");//不仅可以指定服务器的字符集，还可指定浏览器的字符集
//		response.setContentType("text/html;charset=utf-8");//这是上一种的简洁版
//		
//		response.getWriter().write("我来自服务器");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
