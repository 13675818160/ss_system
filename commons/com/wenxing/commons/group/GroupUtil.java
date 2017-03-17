/*
 * @(#)GroupUtil.java 1.0.0 May 24, 2012 2:01:38 PM 
 *
 * Copyright 2011 YaoChen, Ltd. All rights reserved.
 * YaoChen PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wenxing.commons.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 分组工具类
 * 
 * @author hh
 */
public class GroupUtil {
	
	/**
	 * 将给定的结果集，按照实现<code>Group</code>的getGroupKey函数, 组装成一对多的集合
	 */
	public static <T extends Group> Map<String, List<T>> grouping(List<T> data){
		if(data == null){
			return null;
		}
		Map<String, List<T>> group = new HashMap<String, List<T>>();
		
		for (T t : data) {
			List<T> subList = group.get(t.getGroupKey());
			if(subList == null){
				subList = new ArrayList<T>();
				group.put(t.getGroupKey(), subList);
			}
			subList.add(t);
		}
		
		return group;
	}
	
	/**
	 * 将给定的结果集，按照实现<code>Entry</code>的getpKey函数,组装成一对一的Map集合
	 */
	public static <T extends Entry> Map<String, T> entring(List<T> data){
		if(data == null){
			return null;
		}
		Map<String, T> map = new HashMap<String, T>();
		for (T t : data) {
			map.put(t.getKey(), t);
		}
		return map;
	}
}
