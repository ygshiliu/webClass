package com.atguigu.test;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.BookDaoImpl;
//BookDaoImpl测试
public class BookDaoImplTest {
	
	BookDao bd = new BookDaoImpl();
	
	@Test
	public void testGetPage() {
		Page<Book> page = new Page<>();
		page.setPageNo(2);
		page.setPageSize(5);
		bd.getPage(page);
		System.out.println(page.getList());
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}

	@Test
	public void testSaveBook() {
		Book book = new Book(null, "javase", 50.00, "尚硅谷", 80, 100, null);
		bd.saveBook(book);
	}

	@Test
	public void testDeleteBook() {
		bd.deleteBook("1");
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book(1, "javaweb11", 50.00, "尚硅谷11", 150, 50, null);
		bd.updateBook(book);
	}

	@Test
	public void testGetBookById() {
		Book book = bd.getBookById("1");
		System.out.println(book);
	}

	@Test
	public void testGetBookList() {
		List<Book> list = bd.getBookList();
		System.out.println(Arrays.toString(list.toArray()));
	}

}
