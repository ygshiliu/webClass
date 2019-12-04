package com.atguigu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Cart;
import com.atguigu.bean.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取user,进行验证
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user==null) {
			//去登录页面，提示请先登录帐户
			request.setAttribute("msg", "此操作要求必须登录,请登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else {
			//放行
			chain.doFilter(request, response);
		}
		
	}


}
