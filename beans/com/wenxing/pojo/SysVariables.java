 package com.wenxing.pojo;
 

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import com.wenxing.daos.config.POJO;
 
@POJO(tn = "sys_variables", sn = "", pk = "")
public class SysVariables implements Serializable {
	private static final long serialVersionUID = -1875477342453222885L;
	private String item_key;
	private String item_name;
	private String item_value;
	private Integer item_idx;

	public String getItem_key() {
		return this.item_key;
	}

	public void setItem_key(String itemKey) {
		this.item_key = itemKey;
	}

	public String getItem_name() {
		return this.item_name;
	}

	public void setItem_name(String itemName) throws Exception {
		this.item_name = itemName;
	}

	public String getItem_value() {
		return this.item_value;
	}

	public void setItem_value(String itemValue) {
		this.item_value = itemValue;
	}

	public Integer getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(Integer item_idx) {
		this.item_idx = item_idx;
	}

}

