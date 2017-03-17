package com.wenxing.sysmanager.web.action;

import com.wenxing.commons.abstracts.BaseAction;
import com.wenxing.commons.pojo.Root;
import com.wenxing.component.UserComponent;
import com.wenxing.pojo.User;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

@Controller
public class UserAction extends BaseAction {
	private UserComponent userComponent;
	
	private User user;
	
	private String idArr;
	private int pk;

	public String usermng() throws Exception {
		
		return SUCCESS;
	}
	
	public String queryUserByPk() throws Exception {
		return JSON_SIMPLEOBJ;
	}

	public String saveUpdateUser() throws Exception {
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


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public UserComponent getUserComponent() {
		return userComponent;
	}

	public void setUserComponent(UserComponent userComponent) {
		this.userComponent = userComponent;
	}
	
	

}
