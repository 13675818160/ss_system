
package com.wenxing.business.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.daos.abstracts.BaseEntityDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.User;

@Component
public class UserDao extends BaseEntityDao<User> {



	/**
	 *  
	 */
	private static final long serialVersionUID = -747784958597735657L;


	/**
	 * default empty constructor
	 */
	public UserDao() {}

	
	public List<User> queryUserList() throws Exception{
		String sql = "select u.* from user u where u.status='ACTIVE' order by id";
		return createQuery(sql).list();
	}
	
	public List<User> queryUserListByCreator(Integer userId) throws Exception{
		String sql = "select u.* from user u where u.status='ACTIVE' and created_by=? order by id";
		return createQuery(sql,userId).list();
	}
	
	public List<User> queryUserListByAdmin() throws Exception{
		String sql = "select u.* from user u where u.status='ACTIVE' and is_admin=2 and created_by is null order by id";
		return createQuery(sql).list();
	}
	
	public List<User> queryClientList() throws Exception{
		String sql = "select u.* from user u where u.status='ACTIVE' and u.client_admin=1 order by region_id,id";
		return createQuery(sql).list();
	}
	
	public User queryByLoginName(String loginName) throws Exception{
		String sql = "select u.* from user u where u.status='ACTIVE' and u.id=?";
		return createQuery(sql,loginName).first();
	}


	public List<User> queryUserListByIds(String[] idArr) throws JDBCException {
		String sql = "select distinct * from user u where u.status='ACTIVE' and id in ("+getSqlGenerator().in(idArr)+")";
		return createQuery(sql).list();
	}



	public User signin(String loginName, String password) throws JDBCException {
		String sql = "select * from user u where  u.user_id=? and u.password=?";
		return createQuery(sql,loginName,password).first();
	}


	public Pager<User> queryUserList(Integer page, Integer rows) throws JDBCException {
		// TODO Auto-generated method stub
		String sql = "";
		return createQuery(sql).setStart(page*rows).setLimit(rows).page();
	}






}
