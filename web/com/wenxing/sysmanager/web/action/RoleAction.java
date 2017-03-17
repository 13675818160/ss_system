package com.wenxing.sysmanager.web.action;

import com.wenxing.commons.abstracts.BaseAction;
import com.wenxing.commons.pojo.Root;
import com.wenxing.component.RoleComponent;
import com.wenxing.component.RoleComponent;
import com.wenxing.pojo.Role;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

public class RoleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3299849444310169318L;

	private RoleComponent roleComponent;
	private Role role;
	
	private String idArr;
	private int pk;

	public String queryMenuList() throws Exception {
		getRoot().setRecords(roleComponent.queryMenuList(optr));
		return JSON_RECORDS;
	}
	
	public String queryRoleByPk() throws Exception {
		return JSON_SIMPLEOBJ;
	}

	public String saveUpdateRole() throws Exception {
		return SUCCESS;
	}

	public String saveUpdatePermission() throws Exception {
		return JSON;
	}
	
	public String deletePermission() throws Exception {
		return JSON;
	}
	
	public String deleteRole() throws Exception {
		return JSON;
	}


	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdArr() {
		return this.idArr;
	}

	public void setIdArr(String idArr) {
		this.idArr = idArr;
	}

	

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public RoleComponent getRoleComponent() {
		return roleComponent;
	}

	public void setRoleComponent(RoleComponent roleComponent) {
		this.roleComponent = roleComponent;
	}
	
	

}
