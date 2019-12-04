package com.atguigu.bean;

public class OrderDetail {
	private Integer id        ;
	private String title      ;
	private double price      ;
	private String author     ;
	private String imgPath    ;
	//代表某一类图书数量
	private int bcount        ;
	//代表某一类图书金额
	private double amount     ;
	private String orderId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderDetail(Integer id, String title, double price, String author, String imgPath, int bcount, double amount,
			String orderId) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.imgPath = imgPath;
		this.bcount = bcount;
		this.amount = amount;
		this.orderId = orderId;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + ", imgPath="
				+ imgPath + ", bcount=" + bcount + ", amount=" + amount + ", orderId=" + orderId + "]";
	}
	
	
}
