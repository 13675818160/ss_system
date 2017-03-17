package com.wenxing.pojo;

import java.io.Serializable;

import com.wenxing.daos.config.POJO;

@POJO(tn = "company", sn = "", pk = "id")
public class Company extends Common implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 724313822813329512L;
	
	private String company_name;  
    private Integer company_type;  
    private String leader;
    private String leader_phone;
    private String salesman;
    private String salesman_phone;
    
    
  
    public Company() {  
    }  
  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    
  
    public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public Integer getCompany_type() {
		return company_type;
	}


	public void setCompany_type(Integer company_type) {
		this.company_type = company_type;
	}


	public String getLeader() {
		return leader;
	}


	public void setLeader(String leader) {
		this.leader = leader;
	}


	public String getLeader_phone() {
		return leader_phone;
	}


	public void setLeader_phone(String leader_phone) {
		this.leader_phone = leader_phone;
	}


	public String getSalesman() {
		return salesman;
	}


	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}


	public String getSalesman_phone() {
		return salesman_phone;
	}


	public void setSalesman_phone(String salesman_phone) {
		this.salesman_phone = salesman_phone;
	}


	@Override  
    public String toString() {  
        return "Company{" + "id=" + id + ", name='" + company_name + '\'' +  + '}';  
    }
}
