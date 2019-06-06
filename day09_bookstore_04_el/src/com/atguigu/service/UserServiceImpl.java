package com.atguigu.service;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public boolean regist(User user) {
		int i = userDao.saveUser(user);
		//true为注册成功，否则数据库已经存在此用户
		return i>0;
	}

	@Override
	public User login(User user) {
		//根据用户名获取用户
		User dbUser = userDao.getUserByUsername(user.getUsername());
		//再对比前台用户密码与数据库用户密码是否一致
		if(dbUser!=null && user.getPassword().equals(dbUser.getPassword())) {
			return dbUser;
		}else {
			//登录失败
			return null;
		}
		
	}

}
