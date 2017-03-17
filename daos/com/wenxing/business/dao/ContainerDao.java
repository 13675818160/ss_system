
package com.wenxing.business.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.daos.abstracts.BaseEntityDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Container;

@Component
public class ContainerDao extends BaseEntityDao<Container> {



	/**
	 *  
	 */
	private static final long serialVersionUID = -747784958597735657L;


	/**
	 * default empty constructor
	 */
	public ContainerDao() {}


	public Pager<Container> queryContainerByDevice(long devicePk, Integer page, Integer rows) throws JDBCException {
		String sql = "select * from device_note where device_id=? order by last_updated_timestamp desc";
		return createQuery(sql, devicePk).setStart(page*rows).setLimit(rows).page();
	}


}
