package com.wenxing.component;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.business.dao.AppformDao;
import com.wenxing.business.dao.ContainerDao;
import com.wenxing.business.dao.UserDao;
import com.wenxing.commons.constants.StatusConstants;
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
	
	/**
	 * 放行
	 * @param pk
	 * @param optr
	 * @throws JDBCException
	 */
	public void approveRequest(int pk, User optr) throws JDBCException {
		Appform appform = new Appform();
		appform.setId(pk);
		appform.setForm_status(StatusConstants.FORM_STATUS_YFX);
		updateAppfrom(appform, optr);
	}

	/**
	 * 未通过
	 * @param pk
	 * @param optr
	 * @throws JDBCException
	 */
	public void rejectRequest(int pk, User optr) throws JDBCException {
		Appform appform = new Appform();
		appform.setId(pk);
		appform.setForm_status(StatusConstants.FORM_STATUS_SQWTG);
		updateAppfrom(appform, optr);
	}
	
	
	
	public void saveAppfrom(Appform appform, User optr) throws JDBCException{
		appform.setForm_status(StatusConstants.FORM_STATUS_WSQ);
		appform.setLastupdated_by(optr.getId());
		appform.setLastupdated_ts(new Date());
		appformDao.save(appform);
	}
	
	public void updateAppfrom(Appform appform, User optr) throws JDBCException{
		appform.setLastupdated_by(optr.getId());
		appform.setLastupdated_ts(new Date());
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
