package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.BookServiceImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	BookService bookService = new BookServiceImpl();
	
	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取cart
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		//调用方法
		cart.clearCart();
		
		//返回页面
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
	}
	protected void updateCountByBookId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取cart
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		//获取bookId,count
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		//调用cart中的方法
		cart.updateCountByBookid(bookId, Integer.valueOf(count));
		
		//返回页面
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
	}
	
	protected void deleteCartItemByBookId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session中cart
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		//获取请求参数bookId
		String bookId = request.getParameter("bookId");
		//删除bookId对应的cartItem
		cart.deleteCartItemByBookId(bookId);
		
		//哪来回哪
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
	}
       
	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数图书id
		String bookId = request.getParameter("bookId");
		//到数据库中查出此图书
		Book book = bookService.getBookById(bookId);
		
		//获取session
		HttpSession session = request.getSession();
		
		//从session中获取cart
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart==null) {
			//将图书存到cart购物车中
			cart = new Cart();
			cart.addBook2Cart(book);
			session.setAttribute("cart", cart);
		}else {
			cart.addBook2Cart(book);
		}
		
		
		//从哪来的回哪去
		String referer = request.getHeader("referer");
		//转发到页面
		request.setAttribute("title", book.getTitle());
		request.setAttribute("totalCount", cart.getTotalCount());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}


}
