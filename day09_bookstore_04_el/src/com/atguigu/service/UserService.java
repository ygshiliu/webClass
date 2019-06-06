package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {
	//注册
	public boolean regist(User user);
	//登录
	public User login(User user);
}
