package com.wenxing.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.business.dao.RoleDao;
import com.wenxing.business.dao.UserDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Resource;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.User;


@Component
public class RoleComponent {
	private UserDao userDao;
	private RoleDao roleDao;
	
	
	public Pager<Role> queryRoleList(Integer page,Integer rows) throws JDBCException{
		return roleDao.queryRoleList(page,rows);
	}
	

	public List<Resource> queryMenuList(User optr) throws JDBCException {
//		return this.roleDao.queryMenuList(optr.getRole_id());
		return this.roleDao.queryMenuList(1);
	}
	
	

	public void saveRole(Role role, User Optr) throws JDBCException{
		//TODO
		roleDao.save(role);
	}
	
	public void updateRole(Role role, User Optr) throws JDBCException{
		//TODO
		roleDao.update(role);
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public RoleDao getRoleDao() {
		return roleDao;
	}


	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


	
}
