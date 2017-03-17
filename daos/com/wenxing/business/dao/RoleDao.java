package com.wenxing.business.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wenxing.commons.helper.StringHelper;
import com.wenxing.daos.abstracts.BaseEntityDao;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.daos.core.Pager;
import com.wenxing.pojo.Resource;
import com.wenxing.pojo.Role;

@Component
public class RoleDao extends BaseEntityDao<Role> {

	/**
	 *  
	 */
	private static final long serialVersionUID = -747784958597735657L;

	/**
	 * default empty constructor
	 */
	public RoleDao() {
	}

	public Pager<Role> queryRoleList(Integer page, Integer rows)
			throws JDBCException {
		String sql = "";
		return createQuery(sql).setStart(page * rows).setLimit(rows).page();
	}

	public List<Resource> queryMenuList(Integer roleId) throws JDBCException {
		String sql = "select r.* from resource r ,role_res rs where r.status=? and role_id=? and r.id=res_id";
		sql = StringHelper.append(new Serializable[] { sql, " order by r.id" });
		return createQuery(Resource.class, sql,
				new Object[] { 1, roleId }).list();
	}

}
