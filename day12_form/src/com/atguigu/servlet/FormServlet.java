package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao = new UserDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//模拟网络慢
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		
		//获取session域中的token 及 页面传递过来的token 进行对比 
		//如果一致，属性于正常提交，则保存,并将session中的token清空;否则 不进行处理，同时返回消息，禁止重复提交
		HttpSession session = request.getSession();
		String sessionToken = (String) session.getAttribute("token");
		
		String token = request.getParameter("token");
		
		if(token.equals(sessionToken)) {
			
			//清空session中的token
			session.removeAttribute("token");
			
			//获取数据封装成对象
			Map<String, String[]> map = request.getParameterMap();
			User user = new User();
			try {
				BeanUtils.populate(user, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//保存数据
			userDao.saveUser(user);
			System.out.println(user);
			
			//转发到成功页面
			//request.getRequestDispatcher("success.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}else {
			request.setAttribute("msg", "表单已经提交过");
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
