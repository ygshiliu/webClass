package com.atguigu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.util.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Connection connection = JDBCUtils.getConnection();
		try {
			//取消数据库自动提交行为
			connection.setAutoCommit(false);
			//System.out.println("=============TransactionFilter");
			chain.doFilter(request, response);
			
			//手动提交 
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/pages/error/error.jsp");
		}finally {
			JDBCUtils.closeConnection();
		}
		
		
	}

    

}
