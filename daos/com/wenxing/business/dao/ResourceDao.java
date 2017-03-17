
package com.wenxing.business.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.daos.abstracts.BaseEntityDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Resource;

@Component
public class ResourceDao extends BaseEntityDao<Resource> {



	/**
	 *  
	 */
	private static final long serialVersionUID = -747784958597735657L;


	/**
	 * default empty constructor
	 */
	public ResourceDao() {}


	public Pager<Resource> queryResourceByDevice(Integer page, Integer rows) throws JDBCException {
		String sql = "select id, hex(bytes) bytes, nbytes, insert_timestamp from error_value order by insert_timestamp desc";
		return createQuery(sql).setStart(page*rows).setLimit(rows).page();
	}

}
