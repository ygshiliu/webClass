package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public void createOrder(Order order) {
		String sql = "insert into bs_orders(id,create_date,state,total_count,total_amount,user_id) values (?,?,?,?,?,?)";
		update(sql, order.getId(),order.getCreateDate(),order.getState(),order.getTotalCount(),order.getTotalAmount(),order.getUserId());
	}

	@Override
	public List<Order> getAllOrder() {
		String sql = "select id,create_date createDate,state,total_count totalCount,total_amount totalAmount,user_id userId from bs_orders order by create_date desc";
		return getBeanList(Order.class, sql);
	}

	@Override
	public List<Order> getOrderByUserId(String userId) {
		String sql = "select id,create_date createDate,state,total_count totalCount,total_amount totalAmount,user_id userId from bs_orders where user_id=? order by create_date desc";
		return getBeanList(Order.class, sql,userId);
	}

	@Override
	public int updateOrderState(String orderId, String state) {
		String sql = "update bs_orders set state=? where id=? ";
		return update(sql, state,orderId);
	}

}
