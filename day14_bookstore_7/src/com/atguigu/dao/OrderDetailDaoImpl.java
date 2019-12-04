package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderDetail;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {

	@Override
	public void saveOrderDetail(OrderDetail od) {
		String sql ="insert into bs_order_details (title,price,author,img_path,bcount,amount,order_id) values (?,?,?,?,?,?,?) ";
		update(sql, od.getTitle(),od.getPrice(),od.getAuthor(),od.getImgPath(),od.getBcount(),od.getAmount(),od.getOrderId());
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderId(String orderId) {
		String sql ="select id,title,price,author,img_path imgPath,bcount,amount,order_id orderId from bs_order_details where order_id=? ";
		return getBeanList(OrderDetail.class, sql, orderId);
	}

}
