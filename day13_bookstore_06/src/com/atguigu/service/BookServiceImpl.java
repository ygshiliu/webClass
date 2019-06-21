package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.BookDaoImpl;

public class BookServiceImpl implements BookService {
	
	BookDao bookDao = new BookDaoImpl();

	@Override
	public void saveBook(Book book) {
		bookDao.saveBook(book);
	}

	@Override
	public void deleteBook(String bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public Book getBookById(String bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}

	@Override
	public Page<Book> findPage(String pno,String psize) {
		
		//数据转换
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pno);
		} catch (NumberFormatException e) {}
		
		int pageSize = 5;
		try {
			pageSize = Integer.parseInt(psize);
		} catch (NumberFormatException e) {}
		
		//设置页码及显示条数
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		//调用Dao
		bookDao.getPage(page);
		return page;
	}

	@Override
	public Page<Book> findPageByPrice(String pno,String psize,String maxPrice, String minPrice) {
		//数据转换
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pno);
		} catch (Exception e) {}
		
		int pageSize = 4;
		try {
			pageSize = Integer.parseInt(psize);
		} catch (Exception e) {}
		
		double max=Double.MAX_VALUE;
		double min=Double.MIN_VALUE;
		try {
			max = Double.parseDouble(maxPrice);
		} catch (Exception e) {
		}
		try {
			min = Double.parseDouble(minPrice);
		} catch (Exception e) {
		}
		
		//设置页码及显示条数
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		//调用 BookDao
		bookDao.getPageByPrice(page, max, min);
		
		return page;
	}

}
