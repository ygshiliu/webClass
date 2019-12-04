package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * BookDao实现类
 *
 */
public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public void saveBook(Book book) {
		String sql = "insert into bs_books(title,author,price,sales,stock,img_path) values (?,?,?,?,?,?) ";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath());
	}

	@Override
	public void deleteBook(String bookId) {
		String sql = "delete from bs_books where id = ? ";
		update(sql, bookId);
	}

	@Override
	public void updateBook(Book book) {
		String sql = " update bs_books set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ? ";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath(), book.getId());

	}

	@Override
	public Book getBookById(String bookId) {
		String sql = " select id,title,author,price,sales,stock,img_path imgPath from bs_books where id=? ";
		return getBean(Book.class, sql, bookId);
	}

	@Override
	public List<Book> getBookList() {
		String sql = " select id,title,author,price,sales,stock,img_path imgPath from bs_books ";
		return getBeanList(Book.class, sql);
	}

	@Override
	public void getPage(Page<Book> page) {
		//查询总条数
		String sql="select count(id) from bs_books ";
		Long count = (Long) getScalar(sql);
		page.setTotalCount(count.intValue());
		
		//查询图书信息
		sql="select id,title,author,price,sales,stock,img_path imgPath from bs_books limit ?,?";
		List<Book> list = getBeanList(Book.class, sql, (page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
		page.setList(list);
		
		//return page;
	}

	@Override
	public void getPageByPrice(Page<Book> page, double maxPrice, double minPrice) {
		//查询总条数
		String sql="select count(id) from bs_books where price between ? and ? ";
		Long count = (Long) getScalar(sql,minPrice,maxPrice);
		page.setTotalCount(count.intValue());
		
		//查询图书信息
		sql="select id,title,author,price,sales,stock,img_path imgPath from bs_books where price between ? and ? limit ?,?";
		List<Book> list = getBeanList(Book.class, sql, minPrice,maxPrice,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
		page.setList(list);
	}

}
