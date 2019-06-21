package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
//与图书相关的操作
public interface BookDao {
	public void saveBook(Book book); //向数据库中插入一本图书
	public void deleteBook(String bookId); //根据图书的ID删除一本图书
	public void updateBook(Book book); //更新一本图书
	public Book getBookById(String bookId); //根据图书的ID查询一本图书
	public List<Book> getBookList(); //获取所有的图书
	
	public void getPage(Page<Book> page);//获取分页信息
	public void getPageByPrice(Page<Book> page,double maxPrice,double minPrice);//根据条件查询分页图书信息
}
