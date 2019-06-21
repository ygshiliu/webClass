package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderDetail;

public interface OrderDetailDao {
	
	void saveOrderDetail(OrderDetail od) ;//保存订单详情
	List<OrderDetail> getOrderDetailByOrderId(String orderId) ;//查寻指定订单的订单详情

}
