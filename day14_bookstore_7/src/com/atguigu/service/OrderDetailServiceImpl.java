package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.OrderDetail;
import com.atguigu.dao.OrderDetailDao;
import com.atguigu.dao.OrderDetailDaoImpl;

public class OrderDetailServiceImpl implements OrderDetailService {
	
	OrderDetailDao odd = new OrderDetailDaoImpl();
	@Override
	public List<OrderDetail> getOrderDetailByOrderId(String orderId) {
		return odd.getOrderDetailByOrderId(orderId);
	}

}
