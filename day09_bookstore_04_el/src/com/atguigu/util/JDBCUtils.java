package com.atguigu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
	//数据库连接池
	private static DataSource source ;
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
	// 获取数据库连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 释放数据库连接
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
