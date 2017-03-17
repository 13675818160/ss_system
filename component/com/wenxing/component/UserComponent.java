package com.wenxing.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.business.dao.UserDao;
import com.wenxing.business.dao.UserDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.User;
import com.wenxing.pojo.User;

@Component
public class UserComponent {
	private UserDao userDao;
	
	
	public Pager<User> queryUserList(Integer page,Integer rows) throws JDBCException{
		return userDao.queryUserList(page,rows);
	}
	

	public void saveUser(User user, User Optr) throws JDBCException{
		//TODO
		userDao.save(user);
	}
	
	public void updateUser(User user, User Optr) throws JDBCException{
		//TODO
		userDao.update(user);
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
}
