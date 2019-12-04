package com.atguigu.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.atguigu.util.JDBCUtils;

public class DatasourceTest {
	
	@Test
	public void testGetConnection() {
		Connection connection = JDBCUtils.getConnection();
		try {
			String sql = "insert into bs_users(username,password,email) values(?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, "xixi1");
			prepareStatement.setString(2, "123456");
			prepareStatement.setString(3, "xixi@atguigu.com");
			boolean execute = prepareStatement.execute();
			System.out.print(execute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			JDBCUtils.closeConnection(connection);
		}
	}
	

	@Test
	public void testCloseConnection() {
		fail("Not yet implemented");
	}

}
