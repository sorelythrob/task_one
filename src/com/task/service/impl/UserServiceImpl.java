package com.task.service.impl;

import com.task.bean.User;
import com.task.dao.UserDao;
import com.task.dao.impl.UserDaoImpl;
import com.task.service.UserService;

public class UserServiceImpl implements UserService{

	
	private UserDao userDao=new UserDaoImpl();
	@Override
	public User login(User user) {
		return userDao.getUserByUserNameAndPassWord(user);
	}

	@Override
	public boolean regist(User user) {
		return userDao.registUser(user);
	}
	
	

}
