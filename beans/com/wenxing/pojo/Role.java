package com.wenxing.pojo;

import java.io.Serializable;

import com.wenxing.daos.config.POJO;


@POJO(tn = "role", sn = "", pk = "id")

public class Role extends Common implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4655061405489646710L;

	
	
	private String role_name;  
    private String res_ids;
  
    public Role() {  
    }  
  
  
  
    public String getRole_name() {
		return role_name;
	}



	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}




	public String getRes_ids() {
		return res_ids;
	}



	public void setRes_ids(String res_ids) {
		this.res_ids = res_ids;
	}



	@Override  
    public String toString() {  
        return "Role{" + "id=" + id + ", name='" + role_name +  + '\'' + '}';  
    }
}
