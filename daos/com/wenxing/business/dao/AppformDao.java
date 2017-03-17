
package com.wenxing.business.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.commons.helper.DateHelper;
import com.wenxing.commons.helper.StringHelper;
import com.wenxing.daos.abstracts.BaseEntityDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Appform;

@Component
public class AppformDao extends BaseEntityDao<Appform> {



	/**
	 *  
	 */
	private static final long serialVersionUID = -747784958597735657L;


	/**
	 * default empty constructor
	 */
	public AppformDao() {}

	public Pager<Appform> queryAppformPage(Integer page, Integer rows) throws JDBCException {
		String sql = "select * from appform  order by id desc";
		return createQuery(sql).setStart((page-1)*rows).setLimit(rows).page();
	}
	

	public List<Appform> queryAppformList() throws JDBCException {
		String sql = "select * from appform  order by id desc";
		return createQuery(sql).list();
	}


}
