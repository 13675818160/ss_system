package com.wenxing.daos.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p> 利用Java 1.5特性，提供对Apache BeanUtils 不足的封装 </p>
 *
 */
@SuppressWarnings("unchecked")
public class BeanHelper extends org.apache.commons.beanutils.BeanUtils{

	/**
	 * 将Bean转换为Map ,Bean的属性名称作为Map的key,属性值作为Map的value
	 * @return
	 */
	public static Map describe(Object bean) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(null == bean){
			return null ;
		}
		Map map =BeanUtils.describe( bean ) ;
		map.remove("class");
		return map;
	}

	/**
	 * <p>
	 * 通过属性名称，获得该属性对应的Field类型, 循环向上转型,获取对象的DeclaredField, 如果没有找到，则会向上找到父类的模板类
	 * 依次向上，直到找到该属性为止，如果最终没有找到则返回NUll</p>
	 * @param clazz 属性对应类的模板
	 * @param propertyName 属性名称
	 * @return  属性对应的Field
	 * @throws NoSuchFieldException
	 */
	public static Field getDeclaredField(Class clazz, String propertyName)
			throws NoSuchFieldException {
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(propertyName);
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}

	/**
	 * <p>强行设置对象的属性值，忽略private、public修饰符</p>
	 *   没有调用setter方法，进行的设置。
	 * </p>
	 */
	public static void forceSetProperty(Object object, String propertyName,
			Object newValue) throws Exception {
		Field field = getDeclaredField(object.getClass(), propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		field.set(object, newValue);
		field.setAccessible(accessible);
	}

	/**
	 * 强行获取对象变量值,忽略private,protected修饰符的限制.
	 * @throws NoSuchFieldException 如果没有该Field时抛出.
	 */
	public static Object forceGetProperty(Object object, String propertyName)
			throws NoSuchFieldException {
		Field field = getDeclaredField(object.getClass(), propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
		}
		field.setAccessible(accessible);
		return result;
	}
	/**
	 * <p> 根据给定的参数名，按照顺序将参数值添加至数组 </p>
	 * @param propertys 原属性的名称
	 * @param bean 目标对象
	 */
	public static List<Object> parseObjectValueToArray(List<String> propertyNames ,Object bean)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		List<Object>lst = new ArrayList<Object>();
		for (String _s : propertyNames) {
			lst.add(PropertyUtils.getProperty(bean, _s));
		}
		return lst;
	}
}
