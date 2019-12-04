package com.atguigu.bean;
//购物车，用来存放图书

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.CartItem;

public class Cart {

//	private int totalCount;
//	private double totalAmount;
	//封装购物项，key是图书id,value是cartItem
	private Map<String, CartItem> map=new HashMap<String, CartItem>();
	
	
	
	public int getTotalCount() {
		List<CartItem> cartItemList = getCartItemList();
		int totalCount=0;
//		
//		cartItemList.forEach((item)->{
//			totalCount+=item.getCount();
//		});
		
		for (CartItem cartItem : cartItemList) {
			totalCount+=cartItem.getCount();
		}
		return totalCount;
	}
//	public void setTotalCount(int totalCount) {
//		this.totalCount = totalCount;
//	}
	public double getTotalAmount() {
		
		List<CartItem> cartItemList = getCartItemList();
		double totalAmount=0;
		
		for (CartItem cartItem : cartItemList) {
			totalAmount+=cartItem.getAmount();
		}
		return totalAmount;
	}
//	public void setTotalAmount(double totalAmount) {
//		this.totalAmount = totalAmount;
//	}
//	public Map<String, CartItem> getMap() {
//		return map;
//	}
//	public void setMap(Map<String, CartItem> map) {
//		this.map = map;
//	}
	//向购物车中添加图书
	public void addBook2Cart(Book book){
		//先根据bookid获取cartItem
		//注意，int与string是有区别的
		//不要忘记将图书封装到cartItem中及设置数量
		CartItem cartItem = map.get(book.getId()+"");
		if(cartItem==null) {
			//创建CartItem
			CartItem item = new CartItem();
			item.setBook(book);
			item.setCount(1);
			map.put(book.getId()+"", item);
		}else {
			int count = cartItem.getCount();
			cartItem.setCount(++count);
		}
	}
	//删除指定的购物项
	public void deleteCartItemByBookId(String bookid) {
		map.remove(bookid);
	}
	//清空购物车
	public void clearCart() {
		map.clear();
	}
	//更新cartItem数量
	public void updateCountByBookid(String bookid,int count) {
		CartItem cartItem = map.get(bookid);
		cartItem.setCount(count);
	}
	//根据图书id获取cartItem
	public CartItem getCartItem(String bookId) {
		return map.get(bookId);
	}
	//获取所有的购物项
	public List<CartItem> getCartItemList() {
		return new ArrayList<>(map.values());
	}
	
}
