package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PathFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String user = (String) session.getAttribute("username");
		if(user!=null) {
			chain.doFilter(request, response);
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("请先登录再进行查阅");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
