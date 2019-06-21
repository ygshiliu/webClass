package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.OrderDetail;

public interface OrderDetailService {
	//查询指定订单的订单详情
	List<OrderDetail> getOrderDetailByOrderId(String orderId) ;
}
