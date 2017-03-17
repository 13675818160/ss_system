package com.wenxing.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.business.dao.AppformDao;
import com.wenxing.business.dao.ContainerDao;
import com.wenxing.business.dao.UserDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Appform;
import com.wenxing.pojo.User;

@Component
public class AppformComponent {
	private UserDao userDao;
	private AppformDao appformDao;
	private ContainerDao containerDao;
	
	public Pager<Appform> queryAppformPage(Integer page,Integer rows) throws JDBCException{
		Pager<Appform> result =  appformDao.queryAppformPage(page,rows);
		result.setPage(page);
		result.setPageSize(rows);
		return result;
	}
	
	public List<Appform> queryAppformList() throws JDBCException{
		return appformDao.queryAppformList();
	}
	

	public void approveRequest(int pk) {
		
	}
	

	public void rejectRequest(int pk) {
		
	}
	
	
	
	public void saveAppfrom(Appform appform, User Optr) throws JDBCException{
		//TODO
		appformDao.save(appform);
	}
	
	public void updateAppfrom(Appform appform, User Optr) throws JDBCException{
		//TODO
		appformDao.update(appform);
	}
	
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public AppformDao getAppformDao() {
		return appformDao;
	}
	public void setAppformDao(AppformDao appformDao) {
		this.appformDao = appformDao;
	}
	public ContainerDao getContainerDao() {
		return containerDao;
	}
	public void setContainerDao(ContainerDao containerDao) {
		this.containerDao = containerDao;
	}



	
}
