package com.atguigu.bean;

import java.util.Date;

public class Order {
	//订单编号
	private String id;	
	// 创建日期
	private Date createDate;
	// 订单状态
	private int state;
	// 订单数量
	private double totalCount;
	//订单金额
	private double totalAmount ;
	private int userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, Date createDate, int state, double totalCount, double totalAmount, int userId) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.state = state;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", createDate=" + createDate + ", state=" + state + ", totalCount=" + totalCount
				+ ", totalAmount=" + totalAmount + ", userId=" + userId + "]";
	}
	
	
}
