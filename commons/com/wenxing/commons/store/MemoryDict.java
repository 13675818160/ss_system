package com.wenxing.commons.store;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.wenxing.commons.helper.LoggerHelper;
import com.wenxing.commons.helper.StringHelper;
import com.wenxing.pojo.SysVariables;


public class MemoryDict {
	private static Map<String, Map<String, SysVariables>> dictMap = new HashMap();
	private static List<SysVariables> datalist = new ArrayList();
	private static boolean loadingData = false;

	public static String getDictName(Object keyname, String value) {
		if ((keyname == null) || (StringHelper.isEmpty(value))) {
			return "";
		}
		Map<String, SysVariables> m = (Map) getDictMap().get(keyname.toString());
		if (m == null) {
			return "";
		}
		SysVariables s = (SysVariables) m.get(value);
		if (s == null) {
			return "";
		}
		return s.getItem_name();
	}

	public static SysVariables getDictItem(Object keyname, String value) {
		if (StringHelper.isEmpty(value)) {
			return null;
		}
		Map<String, SysVariables> m = (Map) getDictMap().get(keyname.toString());
		if (m == null) {
			return null;
		}
		SysVariables s = (SysVariables) m.get(value);
		if (s == null) {
			return null;
		}
		return s;
	}

	public static List<SysVariables> getDicts(Object keyname) {
		Map<String, SysVariables> m = (Map) getDictMap().get(keyname.toString());
		if (m != null) {
			List<SysVariables> list = new ArrayList(m.values());
			return list;
		}
		return new ArrayList();
	}

	private static void loadData() {
		if (loadingData) {
			synchronized (MemoryDict.class) {
				if (loadingData) {
					Map<String, Map<String, SysVariables>> tempmap = new HashMap();
					try {
						for (SysVariables SysVariables : datalist) {
							String key = SysVariables.getItem_key();
							Map<String, SysVariables> dicts = (Map) tempmap.get(key);
							if (dicts == null) {
								dicts = new Hashtable();
								tempmap.put(key, dicts);
							}
							dicts.put(SysVariables.getItem_value(), SysVariables);
						}
						dictMap = tempmap;
					} catch (Exception e) {
						e.printStackTrace();
						LoggerHelper.error(MemoryDict.class, "字典装载异常");
					} finally {
						loadingData = false;
					}
				}
			}
		}
	}

	private static void reLoadData() {
		loadingData = true;
		loadData();
	}

	public static void setupData(List<SysVariables> data) {
		datalist = data;
		reLoadData();
	}

	public static void appendData(List<SysVariables> datalist) {
		try {
			Map<String, Map<String, SysVariables>> tempmap = new HashMap();
			for (SysVariables SysVariables : datalist) {
				String key = SysVariables.getItem_key();
				Map<String, SysVariables> dicts = (Map) tempmap.get(key);
				if (dicts == null) {
					dicts = new Hashtable();
					tempmap.put(key, dicts);
				}
				dicts.put(SysVariables.getItem_value(), SysVariables);
			}
			dictMap.putAll(tempmap);
		} catch (Exception e) {
			LoggerHelper.error(MemoryDict.class, "字典装载异常");
		} finally {
			if (dictMap == null) {
				dictMap = new HashMap();
			}
		}
	}

	public static Map<String, Map<String, SysVariables>> getDictMap() {
		return dictMap;
	}
}
