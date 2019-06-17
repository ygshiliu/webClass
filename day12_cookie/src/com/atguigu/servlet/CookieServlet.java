package com.atguigu.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		创建cookie
		Cookie cookie = new Cookie("username", "xixi");
		Cookie cookie1 = new Cookie("produce", "phone");
		
		String addr = URLEncoder.encode("地址","utf-8");
		String addrValue = URLEncoder.encode("昌平","utf-8");
		
		Cookie cookie2 = new Cookie(addr,addrValue );
		Cookie cookie3 = new Cookie("gender","female" );
		
		//设置有效时间（单位：秒）
		//expiry可以设置正负数和0
		//正数为到期时间，0则立即删除，负数不会保存
		//设置正数，则Set-Cookie:username=xixi; Expires=Mon, 10-Jun-2019 02:26:04 GMT
		cookie.setMaxAge(60*60);
		//设置0，则Set-Cookie:produce=phone; Expires=Thu, 01-Jan-1970 00:00:10 GMT
		//返回响应就删除
//		cookie1.setMaxAge(0);
		//设置负数，什么都不带，即一次会话，默认设置
		cookie2.setMaxAge(-60*60);
		
		//设置cookie路径，是由浏览器解析，/代理服务器的根目录，路径前面需要加上项目名
		//Set-Cookie:produce=phone; Path=/day12_cookie&session/a
		//只有访问指定路径下的资源，才会带着此cookie
		cookie1.setPath(request.getContextPath()+"/a");
				
//		发送给浏览器
//		会向响应报文中添加一个响应头：Set-Cookie: produce=phone
//		向响应报文中添加几个cookie，响应报文中就有几个set-cookie
//		当浏览器访问服务器时会在请求报文中添加一个请求头：Cookie: produce=phone
//		可以创建多个cookie一起发送给浏览器
//		注意：cookie中不可以使用中文，否则报java.lang.IllegalArgumentException: Cookie name "地址" is a reserved token
		response.addCookie(cookie);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
