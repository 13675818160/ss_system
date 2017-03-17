
package com.wenxing.business.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.daos.abstracts.BaseEntityDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Company;

@Component
public class CompanyDao extends BaseEntityDao<Company> {



	/**
	 *  
	 */
	private static final long serialVersionUID = -747784958597735657L;


	/**
	 * default empty constructor
	 */
	public CompanyDao() {}


	public Pager<Company> queryCompanyList(Integer page, Integer rows) throws JDBCException {
		// TODO Auto-generated method stub
		String sql = "";
		return createQuery(sql).setStart(page*rows).setLimit(rows).page();
	}


}
