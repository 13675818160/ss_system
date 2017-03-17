package com.wenxing.daos.core;

import java.io.Serializable;
import java.util.List;

/**
 * <p> 分页控制类，包含分页的相关信息，如总页数 </p>
 * @author hh
 * @param <T> 结果集的类型
 */
public class Pager<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6432245873739957544L;
	//查询参数
	private T params ;
	//开始位置，
	private Integer page ;
	//显示的条数
	private Integer pageSize ;
	//符合条件的结果集
	private List<T> rows;

	//总条数
	private Integer total ;

	public Pager(T params, Integer page, Integer pageSize) {
		super();
		this.params = params;
		this.page = page;
		this.pageSize = pageSize;
	}

	public Pager(){
	}

	/**
	 * 构造函数传入总记录数及当前的结果集
	 */
	public Pager(List<T> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	
	/**
	 * 构造函数传入总记录数及当前的结果集
	 */
	public Pager(List<T> rows, Integer total,int page, int pageSize) {
		super();
		this.rows = rows;
		this.total = total;
	}

	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public T getParams() {
		return params;
	}
	public void setParams(T params) {
		this.params = params;
	}
	
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
