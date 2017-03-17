package com.wenxing.pojo;


/**
 * The object from which any other object is derived. It has three database table columns - pk, insert_timestamp and last_updated_timestamp.
 * 
 * @author lenovo
 *
 */

public class Common {
	protected java.util.Date lastupdated_ts;		// insert timestamp
	protected Integer lastupdated_by;
	protected Integer id;	
	protected Integer status;
	
	public Common() {}
	
	public java.util.Date getLastupdated_ts() {
		return lastupdated_ts;
	}
	public void setLastupdated_ts(java.util.Date lastupdated_ts) {
		this.lastupdated_ts = lastupdated_ts;
	}
	public Integer getLastupdated_by() {
		return lastupdated_by;
	}
	public void setLastupdated_by(Integer lastupdated_by) {
		this.lastupdated_by = lastupdated_by;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	};
	
	
}
