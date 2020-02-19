package com.task.dao;

import com.task.bean.User;

public interface UserDao {

	public User getUserByUserNameAndPassWord(User user);
	
	public boolean registUser(User user);
	


}
