package com.wenxing.pojo;

import java.io.Serializable;

import com.wenxing.daos.config.POJO;

@POJO(tn = "resource", sn = "", pk = "id")
public class Resource implements Serializable {
	private static final long serialVersionUID = 496933309421504408L;
	private Integer id;
	private String resName;
	private String displayName;
	private String icon;
	private String url;
	private String status;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
