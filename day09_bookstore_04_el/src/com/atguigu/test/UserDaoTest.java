package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;

public class UserDaoTest {
	UserDao userDao = new UserDaoImpl();

	@Test
	public void testSaveUser() {
		User user = new User(null, "哈哈", "123456", "haha@163.com");
		userDao.saveUser(user);
	}

	@Test
	public void testGetUserById() {
		User user = userDao.getUserByUsername("xixi");
		System.out.println(user);
	}

}
