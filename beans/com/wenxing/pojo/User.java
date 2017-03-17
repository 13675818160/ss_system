package com.wenxing.pojo;

import java.io.Serializable;
import java.util.Date;

import com.wenxing.daos.config.POJO;

@POJO(tn = "user", sn = "", pk = "id")
public class User extends Common implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8048814202665293639L;

	
	private String user_name;  
    private Integer company_id;
    private Integer role_id;
    private String password;
    private String phone;
    private Date last_login_time;
  
    public User() {  
    }  
  
  
    public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public Integer getCompany_id() {
		return company_id;
	}


	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}


	public Integer getRole_id() {
		return role_id;
	}


	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getLast_login_time() {
		return last_login_time;
	}


	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}


	@Override  
    public String toString() {  
        return "User{" + "id=" + id + ", name='" + user_name + '\'' +  '}';  
    }
}
