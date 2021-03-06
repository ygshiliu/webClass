package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.BookServiceImpl;
import com.atguigu.util.WebUtil;

/**
 * Servlet implementation class ManagerBookServlet
 */
public class ManagerBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	BookService bookService = new BookServiceImpl();


	protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数bookId
		String bookId = request.getParameter("bookId");
		
		//获取book
		Book book = bookService.getBookById(bookId);
		
		//设置到域中
		request.setAttribute("book", book);
		
		//转发到修改页面book_edit.jsp
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	protected void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用service方法获取图书
		List<Book> list = bookService.getBookList();
		
		//将结果保存到request域
		request.setAttribute("bookList", list);
		
		//转发到页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数bookId
		String bookId = request.getParameter("bookId");
		
		//调用 BookService方法
		bookService.deleteBook(bookId);
		
		//重定向到页面
//		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findBook");
		String referer = request.getHeader("referer");//获取请求来源
		System.out.println("请求来源"+referer);
		response.sendRedirect(referer);
		
	}
	
	protected void saveBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book = new Book();
		WebUtil.Param2Bean(book,request);
		
		//获取请求参数
//		String title = request.getParameter("title");
//		String price = request.getParameter("price");
//		String author = request.getParameter("author");
//		String sales = request.getParameter("sales");
//		String stock = request.getParameter("stock");
//		Book book = new Book(null, title, Double.valueOf(price), author, Integer.valueOf(sales), Integer.valueOf(stock), null);
		
		//调用service方法保存图书
		bookService.saveBook(book);
		
		//重定向图书列表
//		String referer = request.getHeader("referer");//获取请求来源
//		response.sendRedirect(referer);
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findBook");
	}
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取修改后的图书信息
		Book book = new Book();
		WebUtil.Param2Bean(book, request);
		//保存到数据库
		bookService.updateBook(book);
		//重定向到图书列表
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findBook");
		
	}
	protected void saveOrUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("sdfs："+id);
		//获取修改后的图书信息
		Book book = new Book();
		WebUtil.Param2Bean(book, request);
		//保存到数据库
		if( book.getId()==0) {
			bookService.saveBook(book);
		}else {
			bookService.updateBook(book);
		}
		//重定向到图书列表
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findBook");
		
	}
	
	protected void findPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取pageNo\pageSize请求参数
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		String path = WebUtil.getPath(request);
		
		//调用 servcie层方法
		Page<Book> page = bookService.findPage( pageNo, pageSize);
		page.setPath(path);
		//设置到域中
		request.setAttribute("page", page);
		
		//转发到book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

		

}
