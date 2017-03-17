package com.wenxing.pojo;

import java.io.Serializable;

import com.wenxing.daos.config.POJO;

@POJO(tn = "container", sn = "", pk = "id")
public class Container extends Common implements Serializable{
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5600665570576200871L;

	
	
	private Integer appform_id;  
    private String container_code;
    private String container_type;
    private String container_status;
    
    
  
    public Container() {  
    }  
  


	public Integer getAppform_id() {
		return appform_id;
	}



	public void setAppform_id(Integer appform_id) {
		this.appform_id = appform_id;
	}



	public String getContainer_code() {
		return container_code;
	}



	public void setContainer_code(String container_code) {
		this.container_code = container_code;
	}



	public String getContainer_type() {
		return container_type;
	}



	public void setContainer_type(String container_type) {
		this.container_type = container_type;
	}



	public String getContainer_status() {
		return container_status;
	}



	public void setContainer_status(String container_status) {
		this.container_status = container_status;
	}



	@Override  
    public String toString() {  
        return "Container{" + "id=" + id + ", container_code='" + container_code + '\'' +  + '}';  
    }
}
