package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.BookServiceImpl;
import com.atguigu.util.WebUtil;

/**
 * Servlet implementation class ClientBookServlet
 */
public class ClientBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	BookService bookService = new BookServiceImpl();
       
	protected void findPageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取pageNo\pageSize请求参数
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		String minPrice = request.getParameter("min");
		String maxPrice = request.getParameter("max");
		
		
		String path = WebUtil.getPath(request);
		
		//调用 servcie层方法
		Page<Book> page = bookService.findPageByPrice(pageNo, pageSize, maxPrice, minPrice);
		page.setPath(path);
		//设置到域中
		request.setAttribute("page", page);
		
		//转发到index.jsp
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);

	}

}
