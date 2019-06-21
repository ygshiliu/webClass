package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;
import com.atguigu.util.WebUtil;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public UserService userService = new UserServiceImpl();
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		
		//使session失效
		session.invalidate();
		
		//重定向首页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		User user = new User(null, username, password, null);
		User user = new User();
		WebUtil.Param2Bean(user, request);
		//调用 业务层
		User dbuser = userService.login(user);
		
		//返回响应
		if(dbuser==null) {
			//失败转发登录页面
			request.setAttribute("msg", "您输入的用户名或密码不正确");
			//设置提示信息
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		}else {
			//登录成功
			HttpSession session = request.getSession();
			session.setAttribute("user", dbuser);
			//重定向到首页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
	
	
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收请求参数
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		
//		User user = new User(null, username, password, email);
		//验证处理
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		//获取session中的验证码
		String token = (String) session.getAttribute("code");
		
		if(token!=null && code.equals(token)) {
			
			//移除token
			session.removeAttribute("code");
			
			User user = new User();
			WebUtil.Param2Bean(user, request);
			System.out.println(">>>>>"+user);
			//处理业务
			boolean flag = userService.regist(user);
			
			//返回响应
			if(flag) {
				//注册成功重定向到登录页面
				//response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
			}else {
				//失败跳转到失败页面
				//这里为什么使用转发？涉及到需要向页面传值时，使用转发
				request.setAttribute("msg", "此用户名已经注册过");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "禁止表单重复提交");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			
		}
		
		
	}

}
