package com.task.dao.impl;

import com.task.bean.User;
import com.task.dao.BaseDao;
import com.task.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUserByUserNameAndPassWord(User user) {
		
		String sql="select * from task_user where username=? and password =?";
		User user2 = this.getBean(sql,user.getUsername(),user.getPassword());
		return user2;
	}
	

	@Override
	public boolean registUser(User user) {
		
		String sql="insert into  task_user(username,password,email) values(?,?,?)";
		int update = this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
		
		return update>0;
	}


	
	

}
