package com.atguigu.bean;

import java.util.List;

public class Page<T> {
	private List<T> list;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private int pageNo = 1;
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	//计算总页码
	public int getTotalPage() {
//		if(totalCount%pageSize==0) {
//			return totalCount/pageSize;
//		}else {
//			return totalCount/pageSize+1;
//		}
		totalPage = totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		return totalPage;
	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public int getTotalCount() {
		
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//判断页码的有效性
	public int getPageNo() {
		if(pageNo<=1) {
			this.pageNo = 1;
		}
		if(pageNo>=getTotalPage()) {
			this.pageNo=getTotalPage();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
