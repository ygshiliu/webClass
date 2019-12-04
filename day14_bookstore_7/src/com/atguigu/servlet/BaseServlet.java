package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//设置字符集
//		request.setCharacterEncoding("utf-8");
		
		//获取请求参数处理标识
		String method = request.getParameter("method");
		
//		优化1：根据标识调用对应的方法，缺点：需要手动不停修改代码，不断的else if,servlet问题又演变成else if问题
//		if("login".equals(method)) {
//			login(request,response);
//		}else if("regist".equals(method)) {
//			regist(request, response);
//		}
		
//		优化2：通过方法名，以反射方式调用
		//获取Class 
		Class cla = this.getClass();
//		获取Method:getDeclaredMethod(String name, Class<?>... parameterTypes) 
		try {
			
			Method declaredMethod = cla.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
//		调用invoke:invoke(Object obj, Object... args) 
//			设置访问权限：setAccessible(boolean flag)
//			declaredMethod.setAccessible(true);
			declaredMethod.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
//		优化3：复用代码，可以采用baseDao的思路，创建一个BaseServlet用来被继承
//		   后面我们再创建servlet时只需要继承BaseServlet ，然后关注我们要实现的方法就可以
//		注意：doGet与doPost不能出现在子类中
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
