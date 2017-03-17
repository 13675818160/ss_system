package com.wenxing.sysmanager.web.action;

import com.wenxing.commons.abstracts.BaseAction;
import com.wenxing.commons.pojo.Root;
import com.wenxing.component.AppformComponent;
import com.wenxing.pojo.Appform;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

public class AppformAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8187048763751604500L;

	private AppformComponent appformComponent;
	
	private Appform appform;
	
	private String idArr;
	private int pk;

	public String queryAppformList() throws Exception {
		getRoot().setRecords(appformComponent.queryAppformList());
		return JSON_RECORDS;
	}
	
	public String queryAppformPage() throws Exception {
		getRoot().setPage(appformComponent.queryAppformPage(page, rows));
		return JSON_PAGE;
	}
	
	public String approveRequest() throws Exception {
		appformComponent.approveRequest(pk);
		return JSON;
	}
	
	public String rejectRequest() throws Exception {
		appformComponent.rejectRequest(pk);
		return JSON;
	}

	public String saveAppform() throws Exception {
		return JSON;
	}
	
	public String updateAppform() throws Exception {
		return JSON;
	}


	public Appform getAppform() {
		return this.appform;
	}

	public void setAppform(Appform appform) {
		this.appform = appform;
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

	public AppformComponent getAppformComponent() {
		return appformComponent;
	}

	public void setAppformComponent(AppformComponent appformComponent) {
		this.appformComponent = appformComponent;
	}

	
}
