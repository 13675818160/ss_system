package com.wenxing.commons.helper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <code>java.lang.String</code>辅助类, 对字符串的一系列函数。
 *
 * @author hh
 * @date Dec 3, 2009 1:40:01 PM
 */
public class StringHelper {

	/**
	 * 判断字符串是否为空
	 * @return boolean 空返回true 不为空返回lase
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()) || "null".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断字符不为NULL，""，null值
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}


	/**
	 * 从开始位置，删除指定个数的字符串
	 * @return
	 */
	public static String delStartChar(String src ,int len){
		if(null != src && src.length() > 0){
			src = src.substring( len );
		}
		return src;
	}
	/**
	 * 从结束位置，删除指定个数的字符串
	 * @param src 源字符串
	 * @param len 要删除的长度
	 * @return
	 */
	public static String delEndChar(String src , int len){
		if(null != src && src.length() > 0){
			src = src.substring( 0 , src.length() - len );
		}
		return src;
	}

	/**
	 * 将给定的params按顺序拼接起来
	 * @param params 需要拼接的参数
	 * @return
	 */
	public static String append(Serializable ... params){
		StringBuilder sb = new StringBuilder(100);
		for (Serializable s : params) {
			sb.append( s );
		}
		return sb.toString();
	}
	
	/**
	 * 字符串左边补0
	 * @param str 字符串
	 * @param num 补0后长度
	 * @return
	 */
	public static String leftWithZero(String str,int num){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num-str.length();i++){
			sb.append("0");
		}
		return sb.append(str).toString();
	}
	
	/**
	 * 是否數字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[0-9]+([.]{0,1})[0-9]*$");
		Matcher matcher = pattern.matcher(str);
//		for (int i = str.length(); --i >= 0;) {
//			if (!Character.isDigit(str.charAt(i))) {
//				return false;
//			}
//		}
		return matcher.matches();
	}
	
	
	public static double formatFloat(String numberStr,int left){
		double d = 0;
		if(isNumeric(numberStr)){
			d = Double.valueOf(numberStr);
			BigDecimal   b   =   new   BigDecimal(d);  
			d   =   b.setScale(left,   BigDecimal.ROUND_HALF_UP).doubleValue();
//			numberStr = f1.toString();
		}
		
		
		return d;
	}
	
	/**
	 * 用分隔符将字符串数组连接成字符串
	 * 
	 * @param args
	 *            字符串数组
	 * @param sep
	 *            分隔符
	 * @return
	 */
	public static final String join(String[] args, String sep) {
		StringBuilder buf = new StringBuilder(256);
		int j = args.length - 1;
		for (int i = 0; i < j; i++) {
			buf.append(args[i]).append(sep);
		}
		buf.append(args[j]);
		return buf.toString();
	}
	
	public static void main(String[] args){
//		System.out.println(format("asdf",3));
	}
}
