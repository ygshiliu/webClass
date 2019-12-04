package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User(null, username, password, email);
		//处理业务
		boolean flag = userService.regist(user);
		
		//返回响应
		if(flag) {
			//注册成功重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
		}else {
			//失败跳转到失败页面
			//这里为什么使用转发？涉及到需要向页面传值时，使用转发
			request.setAttribute("msg", "此用户名已经注册过");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
