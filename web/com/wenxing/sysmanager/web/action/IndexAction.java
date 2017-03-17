package com.wenxing.sysmanager.web.action;

import com.wenxing.commons.abstracts.BaseAction;
import com.wenxing.commons.constants.SystemConstants;
import com.wenxing.commons.helper.CSVUtil;
import com.wenxing.commons.helper.DateHelper;
import com.wenxing.commons.helper.StringHelper;
import com.wenxing.commons.pojo.Root;
import com.wenxing.commons.redis.JedisUtil;
import com.wenxing.component.UserComponent;
import com.wenxing.daos.core.JDBCException;
import com.wenxing.pojo.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller
public class IndexAction extends BaseAction {
	private static final long serialVersionUID = -4183471848212000275L;
	
	private UserComponent userComponent;
	private String loginName;
	private String password;
	private String newPassword;
	
	private long devicePk;
	
	public String index() throws Exception {
		
		return "success";
	}
	
	public String login() {
		return "success";
	}

	public String signin() throws Exception {
		return JSON;
	}

	public String signout() throws Exception {
		getSession().setAttribute("boss_user_login_name", null);
		getSession().invalidate();
		return JSON;
	}

	public String editPass() throws JDBCException {
		return JSON;
	}
	


	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getNewPassword() {
		return this.newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public long getDevicePk() {
		return devicePk;
	}


	public void setDevicePk(long devicePk) {
		this.devicePk = devicePk;
	}

	public UserComponent getUserComponent() {
		return userComponent;
	}

	public void setUserComponent(UserComponent userComponent) {
		this.userComponent = userComponent;
	}


	
	
}
