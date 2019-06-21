package com.atguigu;

import com.atguigu.bean.Book;

public class CartItem {
	
	private int count;
	//金额是计算出来的
//	private double amount;
	private Book book;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		Double price = book.getPrice();
		
		return price*count;
	}
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
