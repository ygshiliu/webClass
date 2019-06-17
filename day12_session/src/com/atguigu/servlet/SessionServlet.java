package com.atguigu.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public static void main(String[] args) {
		//java中提供的生成UUID工具
		String str = UUID.randomUUID().toString();
		str = str.replace("-", "").toUpperCase();
		System.out.println(str);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建session
//		是在第一次调用request.getSession()时才会被创建，第二次及以后访问就不会创建
//		Set-Cookie:JSESSIONID=41DA2628BD0C833B262AF276C23B735A; Path=/day12_session; HttpOnly
//		jsessionId是由容器分配的唯一标识，容器中的每一个session都有一个唯一标识
		HttpSession session = request.getSession();
		
		//获取sessionID
		String id = session.getId();
		System.out.println("sessionId:"+id);
		
		//TODO
		//获取session的空闲时间
		//空闲时间是指session最后一次被访问到有效时间为止，而不是从创建session开始
		//设置空闲时间可通过两种 方式，1种是在web.xml中配置
		//
		/*	通常在自己的web.xml中配置session空闲时间 ，单位分钟
		<session-config>
	        <session-timeout>20</session-timeout>
	    </session-config>
	    */
		//2种可以通过代码设置
		session.setMaxInactiveInterval(60);
		//单位：秒,默认是1800秒=30分
		int i = session.getMaxInactiveInterval();
		System.out.println(i);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
