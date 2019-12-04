package com.atguigu.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.atguigu.CartItem;
import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderDetail;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.BookDaoImpl;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderDaoImpl;
import com.atguigu.dao.OrderDetailDao;
import com.atguigu.dao.OrderDetailDaoImpl;

public class OrderServiceImpl implements OrderService {
	
	OrderDao orderDao = new OrderDaoImpl();
	OrderDetailDao orderDetailDao =new OrderDetailDaoImpl();
	
	BookDao bookDao = new BookDaoImpl();

	@Override
	public String createOrder(Cart cart, User user) {
		//生成订单
		String id = UUID.randomUUID().toString().replace("-", "")+user.getId();
		Date createDate = new Date();
		Order order = new Order(id, createDate, 0, cart.getTotalCount(), cart.getTotalAmount(), user.getId());
		orderDao.createOrder(order);
		
		//生成订单详情
		List<CartItem> cartItemList = cart.getCartItemList();
		cartItemList.forEach((item)->{
			Book book = item.getBook();
			
			String title = book.getTitle();
			Double price = book.getPrice();
			String author = book.getAuthor();
			String imgPath = book.getImgPath();
			
			int bcount = item.getCount();
			double amount = item.getAmount();
			
			OrderDetail orderDetail = new OrderDetail(null, title, price, author, imgPath, bcount, amount, order.getId());
			orderDetailDao.saveOrderDetail(orderDetail);
			
			//减库存，增销量
			//获取图书的库存和销量
			book.setSales(book.getSales()+item.getCount());
			book.setStock(book.getStock()-item.getCount());
			bookDao.updateBook(book);
			
		});
		
		//int i=1/0;
		
		//清空购物车
		cart.clearCart();
		//返回订单ID
		return id;
	}

	@Override
	public void sendGoods(String orderId) {
		orderDao.updateOrderState(orderId, "1");
	}

	@Override
	public void takeGoods(String orderId) {
		orderDao.updateOrderState(orderId, "2");

	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.getAllOrder();
	}

	@Override
	public List<Order> getOrderByUserId(String userId) {
		return orderDao.getOrderByUserId(userId);
	}

}
