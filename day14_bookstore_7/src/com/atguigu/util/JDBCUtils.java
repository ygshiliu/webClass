package com.atguigu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.javafx.collections.MappingChange.Map;

public class JDBCUtils {
	//数据库连接池
	private static DataSource source ;
//	将数据库连接放入集合统一管理
//	hashMap不是线程安全的，ConcurrentHashMap是线程安全
	static ConcurrentHashMap<Thread,Connection> map = new ConcurrentHashMap();
	
	static {
		Properties properties = new Properties();
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(is);
			source = DruidDataSourceFactory.createDataSource(properties );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection connection = map.get(Thread.currentThread());
		if(connection==null) {
			try {
				connection = source.getConnection();
				map.put(Thread.currentThread(),connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		Connection connection = map.get(Thread.currentThread());
		if(connection!=null) {
			try {
				connection.close();
				map.remove(Thread.currentThread());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	// 获取数据库连接
//	public static Connection getConnection() {
//		Connection conn = null;
//		try {
//			conn = source.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	// 释放数据库连接
//	public static void closeConnection(Connection conn) {
//		if(conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
}
