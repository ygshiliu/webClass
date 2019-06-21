package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.User;

public interface OrderService {
	//创建订单，返回订单id -- 订单状态0
	String createOrder( Cart cart,User user);
	//修改订单状态--商家发货 -- 1
	void sendGoods(String orderId);
	//修改订单状态 -- 客户接货 -- 3交易完成
	void takeGoods(String orderId);
	//获取订单  --提供给管理员
	List<Order> getAllOrder() ;
	//获取用户订单--提供给客户使用
	List<Order> getOrderByUserId(String userId) ;
}
