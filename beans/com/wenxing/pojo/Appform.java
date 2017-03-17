package com.wenxing.pojo;

import java.io.Serializable;

import com.wenxing.daos.config.POJO;


@POJO(tn = "appform", sn = "", pk = "id")
public class Appform extends Common implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7629298446819645789L;
	
	private String zhuanguan_num;  
    private String baoguan_num;
    private Integer huodai_comp_id;  
    private Integer baoguan_comp_id;  
    private Integer agent_id; 
    private String harbour;
    private Integer container_account; 
    private Integer total_count; 
    private Integer total_weight; 

    private String package_type;
    private String source_area;

    private String tiyun_num;
    private String prod_name;
    private String warehouse;
    private String chedui;
    private String xiangzhu;
    private String form_status;
    
    
    private String huodai_comp_text;
    private String baoguan_comp_text;
    private String form_status_text;
    private Integer container_released_account; 
    
    private String released_and_total;
    
  
    public Appform() {  
    }  
  


	public String getZhuanguan_num() {
		return zhuanguan_num;
	}




	public void setZhuanguan_num(String zhuanguan_num) {
		this.zhuanguan_num = zhuanguan_num;
	}




	public String getBaoguan_num() {
		return baoguan_num;
	}




	public void setBaoguan_num(String baoguan_num) {
		this.baoguan_num = baoguan_num;
	}




	public Integer getHuodai_comp_id() {
		return huodai_comp_id;
	}




	public void setHuodai_comp_id(Integer huodai_comp_id) {
		this.huodai_comp_id = huodai_comp_id;
		this.huodai_comp_text = "远洋物流";
	}




	public Integer getBaoguan_comp_id() {
		return baoguan_comp_id;
	}




	public void setBaoguan_comp_id(Integer baoguan_comp_id) {
		this.baoguan_comp_id = baoguan_comp_id;
		this.baoguan_comp_text = "杭州中外运报关有限公司";
	}




	public Integer getAgent_id() {
		return agent_id;
	}




	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}




	public String getHarbour() {
		return harbour;
	}




	public void setHarbour(String harbour) {
		this.harbour = harbour;
	}




	public Integer getContainer_account() {
		return container_account;
	}




	public void setContainer_account(Integer container_account) {
		this.container_account = container_account;
	}




	public Integer getTotal_count() {
		return total_count;
	}




	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}




	public Integer getTotal_weight() {
		return total_weight;
	}




	public void setTotal_weight(Integer total_weight) {
		this.total_weight = total_weight;
	}




	public String getPackage_type() {
		return package_type;
	}




	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}




	public String getSource_area() {
		return source_area;
	}




	public void setSource_area(String source_area) {
		this.source_area = source_area;
	}




	public String getTiyun_num() {
		return tiyun_num;
	}




	public void setTiyun_num(String tiyun_num) {
		this.tiyun_num = tiyun_num;
	}




	public String getProd_name() {
		return prod_name;
	}




	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}




	public String getWarehouse() {
		return warehouse;
	}




	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}




	public String getChedui() {
		return chedui;
	}




	public void setChedui(String chedui) {
		this.chedui = chedui;
	}




	public String getXiangzhu() {
		return xiangzhu;
	}




	public void setXiangzhu(String xiangzhu) {
		this.xiangzhu = xiangzhu;
	}




	public String getForm_status() {
		return form_status;
	}




	public void setForm_status(String form_status) {
		this.form_status = form_status;
	}

	



	public String getHuodai_comp_text() {
		return huodai_comp_text;
	}




	public void setHuodai_comp_text(String huodai_comp_text) {
		this.huodai_comp_text = huodai_comp_text;
	}




	public String getBaoguan_comp_text() {
		return baoguan_comp_text;
	}




	public void setBaoguan_comp_text(String baoguan_comp_text) {
		this.baoguan_comp_text = baoguan_comp_text;
	}




	public Integer getContainer_released_account() {
		return container_released_account;
	}




	public void setContainer_released_account(Integer container_released_account) {
		this.container_released_account = container_released_account;
	}

	

	public String getForm_status_text() {
		return form_status_text;
	}



	public void setForm_status_text(String form_status_text) {
		this.form_status_text = form_status_text;
	}



	public String getReleased_and_total() {
		return released_and_total;
	}



	public void setReleased_and_total(String released_and_total) {
		this.released_and_total = released_and_total;
		this.released_and_total = "2/20";
	}



	@Override  
    public String toString() {  
        return "Appform{" + "id=" + id + ", zhuanguan_num='" + zhuanguan_num + '\'' +  + '}';  
    }
}
