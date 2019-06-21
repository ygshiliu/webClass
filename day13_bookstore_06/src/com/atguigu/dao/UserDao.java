package com.atguigu.dao;

import com.atguigu.bean.User;
//定义所有操作用户的方法
public interface UserDao {
	//注册：向数据库插入一条数据
	public int saveUser(User user);
	//登录：获取一个类
	public User getUserByUsername(String username);
}
