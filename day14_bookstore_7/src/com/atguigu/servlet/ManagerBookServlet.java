package com.atguigu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.BookServiceImpl;
import com.atguigu.util.WebUtil;


/**
 * Servlet implementation class ManagerBookServlet
 */
public class ManagerBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	BookService bookService = new BookServiceImpl();


	protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数bookId
		String bookId = request.getParameter("bookId");
		
		//获取book
		Book book = bookService.getBookById(bookId);
		
		//设置到域中
		request.setAttribute("book", book);
		
		//转发到修改页面book_edit.jsp
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	protected void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用service方法获取图书
		List<Book> list = bookService.getBookList();
		
		//将结果保存到request域
		request.setAttribute("bookList", list);
		
		//转发到页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数bookId
		String bookId = request.getParameter("bookId");
		
		//调用 BookService方法
		bookService.deleteBook(bookId);
		
		//重定向到页面
//		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findBook");
		String referer = request.getHeader("referer");//获取请求来源
		System.out.println("请求来源"+referer);
		response.sendRedirect(referer);
		
	}
	
	protected void saveBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book = new Book();
		WebUtil.Param2Bean(book,request);
		
		//获取请求参数
//		String title = request.getParameter("title");
//		String price = request.getParameter("price");
//		String author = request.getParameter("author");
//		String sales = request.getParameter("sales");
//		String stock = request.getParameter("stock");
//		Book book = new Book(null, title, Double.valueOf(price), author, Integer.valueOf(sales), Integer.valueOf(stock), null);
		
		//调用service方法保存图书
		bookService.saveBook(book);
		
		//重定向图书列表
//		String referer = request.getHeader("referer");//获取请求来源
//		response.sendRedirect(referer);
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findPage");
	}
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取修改后的图书信息
		Book book = new Book();
		WebUtil.Param2Bean(book, request);
		//保存到数据库
		bookService.updateBook(book);
		//重定向到图书列表
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findPage");
		
	}
	protected void saveOrUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("sdfs："+id);
		//获取修改后的图书信息
		Book book = new Book();
		WebUtil.Param2Bean(book, request);
		//保存到数据库
		if( book.getId()==0) {
			bookService.saveBook(book);
		}else {
			bookService.updateBook(book);
		}
		//重定向到图书列表
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findPage");
		
	}
	@SuppressWarnings("resource")
	protected void saveOrUpdateBook2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过流的方式获取图书信息
		/**
		 * 1.加入文件上传jar包：file-upload commons-io
		 * 2.实现API
		 * 
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
        // Configure the factory here, if desired.
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Configure the uploader here, if desired.
        
        //获取修改后的图书信息
  		Book book = new Book();
  		
        try {
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()) {
					String fieldName = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					System.out.println(fieldName+"==="+value);
					BeanUtils.copyProperty(book, fieldName, value);
				}else {
					InputStream in = fileItem.getInputStream();
					String originalName = fileItem.getName();
					long subfix = System.currentTimeMillis();
										
					String realPath = getServletContext().getRealPath("/static/upload/");
					File file = new File(realPath);
					
					if(!file.exists()) {
						file.mkdirs();
					}
					
					String filename=subfix+"-"+originalName;
					System.out.println("==="+filename);
					file = new File(realPath+"/"+filename);
					
					FileOutputStream out = new FileOutputStream(file);
					IOUtils.copy(in, out);
					
					book.setImgPath("static/upload/"+filename);
					
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//保存到数据库
		if( book.getId()==0) {
			bookService.saveBook(book);
		}else {
			bookService.updateBook(book);
		}
		//重定向到图书列表
		response.sendRedirect(request.getContextPath()+"/ManagerBookServlet?method=findPage");
		
	}
	
	protected void findPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取pageNo\pageSize请求参数
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		String path = WebUtil.getPath(request);
		
		//调用 servcie层方法
		Page<Book> page = bookService.findPage( pageNo, pageSize);
		page.setPath(path);
		//设置到域中
		request.setAttribute("page", page);
		
		//转发到book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

		

}
