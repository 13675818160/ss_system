package com.wenxing.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.business.dao.CompanyDao;
import com.wenxing.business.dao.UserDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Company;
import com.wenxing.pojo.Company;
import com.wenxing.pojo.Company;
import com.wenxing.pojo.Role;
import com.wenxing.pojo.User;

@Component
public class CompanyComponent {
	private UserDao userDao;
	private CompanyDao companyDao;
	
	public Pager<Company> queryCompanyList(Integer page,Integer rows) throws JDBCException{
		return companyDao.queryCompanyList(page,rows);
	}
	

	public void saveCompany(Company company, User Optr) throws JDBCException{
		//TODO
		companyDao.save(company);
	}
	
	public void updateCompany(Company company, User Optr) throws JDBCException{
		//TODO
		companyDao.update(company);
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public CompanyDao getCompanyDao() {
		return companyDao;
	}


	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	
}
