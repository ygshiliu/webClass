package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

//Book业务处理接口
public interface BookService {
	public void saveBook(Book book); //向数据库中插入一本图书
	public void deleteBook(String bookId); //根据图书的ID删除一本图书
	public void updateBook(Book book); //更新一本图书
	public Book getBookById(String bookId); //根据图书的ID查询一本图书
	public List<Book> getBookList(); //获取所有的图书
	
	public Page<Book> findPage(String pno,String psize);
	//根据条件查询分页图书信息
	public Page<Book> findPageByPrice(String pno,String psize,String maxPrice,String minPrice);
}
