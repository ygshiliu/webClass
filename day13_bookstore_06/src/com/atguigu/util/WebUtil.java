package com.atguigu.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.Book;

public class WebUtil {

	public static void Param2Bean(Object obj, HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		try {
			//将map中的请求参数映射到Book对象上
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//截取路径
	public static String getPath(HttpServletRequest request) {
		//获取请求资源路径
		String servletPath = request.getServletPath();
		//获取请求参数
		String queryString = request.getQueryString();
		//去掉pageNo
		if(queryString.contains("pageNo")) {
			queryString=queryString.substring(0, queryString.indexOf("&pageNo"));
		}
//		System.out.println(servletPath);
//		System.out.println(queryString);
		
		String path = servletPath+"?"+queryString;
		
		return path.substring(1);
	}

}
