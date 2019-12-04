package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderDetail;
import com.atguigu.bean.User;
import com.atguigu.service.OrderDetailService;
import com.atguigu.service.OrderDetailServiceImpl;
import com.atguigu.service.OrderService;
import com.atguigu.service.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	OrderService os = new OrderServiceImpl();
	OrderDetailService ods=new OrderDetailServiceImpl();
       
	protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户信息，并进行判断是否存在，存在代表登录，否则没登录(去登录页面)，而此操作要求必须登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(user==null) {
			//去登录页面，提示请先登录帐户
			request.setAttribute("msg", "此操作要求必须登录,请登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else if(cart!=null && cart.getCartItemList().size()==0){
			request.setAttribute("msg", "购物车中目前没有商品，先去购物吧");
			request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
			
		}else {
			//获取session中的cart
			String orderId = os.createOrder(cart, user);
			request.setAttribute("orderId", orderId);
			request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
			
		}
		
	}

	protected void findOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户信息，并进行判断是否存在，存在代表登录，否则没登录(去登录页面)，而此操作要求必须登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//获取用户订单
		List<Order> orders = os.getOrderByUserId(user.getId()+"");
		request.setAttribute("orders", orders);
		//转发到订单页面
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	protected void findOrderDetailsByOrderId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取指定订单号
		String orderId = request.getParameter("orderId");
		//获取详情
		List<OrderDetail> odList = ods.getOrderDetailByOrderId(orderId);
		//转发到订单详情页
		request.setAttribute("odList", odList);
		request.getRequestDispatcher("/pages/order/detail.jsp").forward(request, response);
	}
	
	protected void takeGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取订单号
		String orderId = request.getParameter("orderId");
		//更改订单状态 
		os.takeGoods(orderId);
		//返回原处
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
	}
}
