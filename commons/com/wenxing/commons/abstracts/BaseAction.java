package com.wenxing.commons.abstracts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.wenxing.commons.helper.JsonHelper;
import com.wenxing.commons.pojo.Root;
import com.wenxing.pojo.User;

/**
 * <p>业务<code>Action</code>的基类，
 * 包含操作员等大部分业务模块<code>Action</code>共有的信息。</p>
 *
 * @author hh
 */
public class BaseAction extends AbstractAction{

	/**
	 *
	 */
	private static final long serialVersionUID = -4798784078940038896L;
	protected Root root ;

	//定义JSON返回结果类型
	protected static final String JSON_SIMPLEOBJ = "json-simpleObj";
	protected static final String JSON_RECORDS = "json-records";
	protected static final String JSON_OTHER = "json-others";
	protected static final String JSON_PAGE = "json-page";
	protected static final String JSON_SUCCESS = "json-success";
	protected static final String JSON = "json";
	protected static final String EXCEL = "excel";
	
	/**
	 * <p>当使用Ajax上传文件时，返回该结果类型，
	 * 将需要返回的JSON内容设置到当前的request作用域中</p>
	 * <p> examples: 
	 * 	<pre>
	 * 	getProxyRoot().setSimpleObj("文件上传成功!");
	 *	return AJAX_UPLOAD;
	 *	</pre>
	 * </p>
	 */
	protected static final String AJAX_UPLOAD = "ajax-upload";
	


	public User getOptr() {
		return optr;
	}

	public void setOptr(User optr) {
		this.optr = optr;
	}

	protected User optr ;

	protected Integer page ;
	protected Integer rows ;

	/**
	 * @see {@link #AJAX_UPLOAD} 
	 */
	@Deprecated
	protected String retrunNone(String msg) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		msg = msg.replaceAll("'", " ");
		out.print("{success:true,msg:'"+msg+"'}");
		out.flush();
		out.close();
		return NONE;
	}
	
	/**
	 * @see {@link #AJAX_UPLOAD} 
	 */
	@Deprecated
	protected String returnList(List<?> list) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String records = JsonHelper.fromObject(list);
		out.print("{success:true,records : "+records+"}");
		out.flush();
		out.close();
		return NONE;
	}
	
	
	protected List<Map.Entry<String, String>> sortList(Map<String,String> map){
		List<Map.Entry<String, String>> resultList = new ArrayList<Map.Entry<String, String>>(
				map.entrySet());
		Collections.sort(resultList, new Comparator<Map.Entry<String, String>>() {
			public int compare(Entry<String, String> o1,
					Entry<String, String> o2) {
				int num1 = Integer.parseInt(o1.getValue().substring(0, 2));
				int num2 = Integer.parseInt(o2.getValue().substring(0, 2));
				return num1 - num2;
			}
		});
		for(Map.Entry<String, String> entry : resultList){
			entry.setValue(entry.getValue().substring(2, entry.getValue().length()));
		}
		return resultList;
	}

	public Root getRoot() {
		
		return root = root == null
				? new Root()
				: root;
	}
	
	public Root getProxyRoot(){
		Root root= this.getRoot();
		request.setAttribute("root", root);
		return root;
	}

	public void setRoot(Root rootOfPager) {
		root = rootOfPager;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	
}
