package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

public interface OrderDao {
	
	void createOrder(Order order) ;// 保存订单
	List<Order> getAllOrder()  ;//提供给管理员
	List<Order> getOrderByUserId(String userId)  ;//提供给客户使用
	int updateOrderState(String orderId,String state) ;//更新订单的状态
}
