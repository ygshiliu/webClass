package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 
 */
public class FirstFilter implements Filter {
	
	

	public FirstFilter() {
		super();
		// TODO Auto-generated constructor stub
		//System.out.println("FirstFilter create ....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("FirstFilter:)");
		//这里服务器只是拦截，并没有放行
		//如果放行，需要我们调用FilterChain一个方法
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
