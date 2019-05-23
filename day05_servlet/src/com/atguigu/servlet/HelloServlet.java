package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class HelloServlet implements Servlet {
	
	ServletConfig config;

	public HelloServlet() {
		System.out.println("helloservlet构造器被调用");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		System.out.println("init 被调用");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * ServletRequest 用来封装浏览器端发送来的请求报文
	 * ServletResponse 用来封装服务器端返回的响应报文
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String tag = req.getParameter("tag");
//		System.out.println("接收到浏览器发过来的请求,参数："+tag);
//		res.setContentType("text/html;charset=utf-8");
//		res.getWriter().write("你好浏览器，我收到请求了");
		
		
		
		System.out.println("service 被调用");
		
		//获取初始化参数
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		//可以获取servletContext,每一个web工程有且只有一个servletContext
		//代表整个web工程
		//它是一个域对象,在整个web工程中共享数据。web中一共有4个域对象，这是其中最大的一个
		/*主要作用：
		*	1.共享数据
		*	2.获取服务器上文件的物理地址
		*	 
		*	虚拟地址: http://localhost:8080/day05_servlet/hello?tag=haha
		*	物理地址: D:\webspace\day05_servlet
		*/
		ServletContext servletContext = config.getServletContext();
		String web = servletContext.getInitParameter("web");
		System.out.println(web);
		
		//获取物理地址值：D:\webspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\day05_servlet\pages
		String realPath = servletContext.getRealPath("pages");
		System.out.println("物理地址："+realPath);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy 被调用");
		// TODO Auto-generated method stub
		
	}



}
