package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.OrderServiceImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	OrderService oService = new OrderServiceImpl();
       
	protected void findManagerOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有平台订单
		List<Order> orders = oService.getAllOrder();
		//转发到订单页面
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}

	protected void sendGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取指定
		String orderId = request.getParameter("orderId");
		//更改订单状态
		oService.sendGoods(orderId);
		//返回原处
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
		
	}
}
