/**
 * action异常拦截器
 */
package com.wenxing.sysmanager.web.commons.interceptor;

import java.lang.reflect.InvocationTargetException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wenxing.commons.abstracts.BaseAction;
import com.wenxing.commons.exception.ExceptionMessage;
import com.wenxing.commons.helper.LoggerHelper;
import com.wenxing.commons.pojo.ExceptionData;
import com.wenxing.commons.pojo.Root;

/**
 * @author danjp
 *
 */
public class CatchExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 3188674580951976746L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "json";
		
		try {
			result = invocation.invoke();
			
		} catch (Exception e) {
			String errorMsg = e.getMessage();
			if (e instanceof RuntimeException) {
                //未知的运行时异常   
	                RuntimeException re = (RuntimeException) e;
	                re.printStackTrace();
	                errorMsg = re.getMessage().trim();
	                re.printStackTrace();
	                System.out.println(errorMsg);
	                LoggerHelper.error(invocation.getAction().getClass(), errorMsg);
	        }if(e instanceof InvocationTargetException){
	        	InvocationTargetException ie = (InvocationTargetException)e;
	        	errorMsg = ie.getTargetException().toString();
	        	ie.printStackTrace();
                LoggerHelper.error(invocation.getAction().getClass(), errorMsg);
	        }else{
				System.out.println(errorMsg);
				ExceptionData msg = ExceptionMessage.getMsgFromException(e);
				BaseAction ba = (BaseAction)invocation.getAction();
				Root root = ba.getRoot();
				root.setException(msg);
				root.setSuccess(false);
				e.printStackTrace();
				LoggerHelper.error(invocation.getAction().getClass(), errorMsg);
	        }
			
			
			
			
		}
		return result;
	}
}
