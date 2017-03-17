package com.wenxing.commons.constants;

/**
 * 系统业务常量定义
 *
 */
public class SystemConstants {
	
	public final static String INITIAL_PASSWORD="123456";
	
	/**
	 * 当操作员登录成功后，在Session缓存，保存用户信息的KEY
	 */
	public static final String USER_IN_SESSION_NAME = "user_login_name" ;
	
	public static final String ANY_OWNER = "任意制作人员" ;
	
	public static final String SHOW_ALARM = "SHOW_ALARM" ;
	
	
	public static final String YES = "T" ;
	
	public static final String NO = "F" ;
	
	public static final String ACTIVE = "ACTIVE";
	public static final String INVALID = "INVALID";
	
	public static final String SEARCH_TYPE_STATION = "station";
	public static final String SEARCH_TYPE_PIPELINE = "pineline";
	public static final String SEARCH_TYPE_COMPANY = "company";
	
	public static final String EVENT_TYPE_SIGNIN = "1";
	public static final String EVENT_TYPE_SIGNOUT = "2";
	public static final String EVENT_TYPE_DEVICE = "3";
	
	public static final String LOG_CATAGORY_EVENT = "1";
	public static final String LOG_CATAGORY_WARN = "2";
	
	public static final String LOG_CATAGORY_KEY =  "log_category";
	public static final String MSG_CODE_KEY =  "msg_code";
	public static final String EVENT_TYPE_KEY =  "event_type";
	public static final String DEVICE_MODEL_KEY =  "device_model";
	public static final String KEY_SET_KEY =  "key_set";
	
	
	public static final int GROUP_TYPE_MANUAL = 1;
	public static final String UNCONFIGED_TEXT = "未分配组分";
	public static final String CONFIGED_TEXT = "已分配组分: 组分仪-";
}
