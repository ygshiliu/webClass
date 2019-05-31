package com.atguigu.dao;

import com.atguigu.bean.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int saveUser(User user) {
		try {
			String sql ="insert into bs_users(username,password,email) values(?,?,?)";
			int count = update(sql, user.getUsername(),user.getPassword(),user.getEmail());
			return count;
		} catch (Exception e) {
			//e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		String sql="select id,username,password,email from bs_users where username=?";
		User user = getBean(User.class, sql, username);
		return user;
	}

}
