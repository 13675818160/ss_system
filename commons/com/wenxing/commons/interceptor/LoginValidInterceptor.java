package com.wenxing.commons.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wenxing.commons.abstracts.BaseAction;
import com.wenxing.commons.constants.SystemConstants;
import com.wenxing.commons.exception.ComponentException;
import com.wenxing.commons.exception.ExceptionMessage;
import com.wenxing.commons.exception.LoginException;
import com.wenxing.commons.helper.JsonHelper;
import com.wenxing.commons.helper.LoggerHelper;
import com.wenxing.commons.pojo.ExceptionData;
import com.wenxing.commons.pojo.Root;
import com.wenxing.pojo.User;

/**
 * <p>验证请求是否已经登陆成功。</p>
 * 简单的验证当前的请求<code>Session</code>中是否存在操作员信息
 *
 * @author <a href='mailTo:huanghui2004@hotmail.com'>hh</a>
 */
public class LoginValidInterceptor extends AbstractInterceptor {


	/**
	 *
	 */
	private static final long serialVersionUID = -7594309987971245981L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);

		/*if(request.getRequestURI().endsWith( "Index!signin" )|| request.getRequestURI().endsWith( "login" )){
		}else{
			Object user = session.getAttribute( SystemConstants.USER_IN_SESSION_NAME);
			if(null == user) {
				ExceptionData msg = new ExceptionData();
				msg.setType(ExceptionData.LOGIN_EXCEPTION);
				msg.setTitle("错误");
				msg.setContent("操作员信息丢失，请重新登录！");
				
				BaseAction ba = (BaseAction)invocation.getAction();
				Root root = ba.getRoot();
				root.setException(msg);
				root.setSuccess(false);
				return "json";
			}else if( !(invocation.getAction() instanceof BaseAction)){
			}else{
				BaseAction ba = (BaseAction)invocation.getAction();
				User loggedinuser = (User) user;
				ba.setOptr(loggedinuser);
			}
		}*/
		// invoke next interceptor or action
		 
		return invocation.invoke();
	}

}
