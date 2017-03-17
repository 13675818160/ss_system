package com.wenxing.daos.core.generator;

import static com.wenxing.daos.helper.StringHelper.format;
import static com.wenxing.daos.helper.StringHelper.formatIgnoreType;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.wenxing.commons.helper.StringHelper;
import com.wenxing.daos.config.Table;
import com.wenxing.daos.helper.DateHelper;
import com.wenxing.daos.helper.ListHelper;
/**
 * mysql的处理类
 */
public class OracleGenerator implements SQLGenerator{
	

	public String and(Map params) {
		String target = StringUtils.EMPTY;
		if(params == null) return target;
		Iterator<String> ite = params.keySet().iterator();
		String key = null ;
		while(ite.hasNext()){
			key = ite.next();
			if( params.get(key) != null ){
				target += format( key + "={0}", params.get(key)) + " and ";
			}
		}
		return StringHelper.delEndChar( target ,  4 ) ;
	}

	public String getDelete(Table tb) {
		return formatIgnoreType("DELETE FROM {0}  WHERE {1} = ?",tb.getTableName(),tb.getPrimaryKey());
	}

	public String getEntityAll(String tname) {
		return formatIgnoreType("SELECT t.* FROM {0} t ",tname);
	}

	public String getEntityByKey(Table tb) {
		return formatIgnoreType("SELECT t.* FROM `{0}` t WHERE t.`{1}` = ?",tb.getTableName(),tb.getPrimaryKey());
	}

	public String getFindByMap(String tableName,
			Map<String, Serializable> params) {
		StringBuffer sql = new StringBuffer("SELECT * FROM {0} WHERE 1 = 1 ") ;
		Object [] os = params.keySet().toArray();
		for (Object _o : os)
			sql.append(" AND " + _o + " = ? ");
		return formatIgnoreType(sql.toString(), tableName);
	}

	public String getPage(String sql, int start, int limit) {
		StringBuffer sb = new StringBuffer(100);
		if (start==0&&limit==0)
			sb.append(" {0} ");
		else
			sb.append("SELECT * FROM ( {0} ) table_alias_for_row  limit {1} ,{2}");
			
		return formatIgnoreType(sb.toString(), sql,start,limit);
	}

	public String getPageCount(String sql) {
		return formatIgnoreType("SELECT count(1) FROM ( {0} ) table_alias_for_count" , sql );
	}

	public String getRows(String tname) {
		return formatIgnoreType("SELECT COUNT(1) FROM {0} t",tname);
	}

	public String getSave(String tableName, Map<String, Object> maps) {
		String sql = "INSERT INTO `{0}`({1}) values({2})" ;
		StringBuffer columns = new StringBuffer();
		StringBuffer values = new StringBuffer();
		Iterator<String> ite =  maps.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next() ;
			columns.append("`"+key + "`,");
			if (maps.get(key) instanceof Date) {
				String dateStr = format("{0}",DateHelper.format((Date)maps.get(key)));
				values.append(dateStr + ",");
			}
			else
				values.append(format("{0}",maps.get(key)) + ",");
		}
		if(values.length()>0){
			values.deleteCharAt(values.length() - 1);
			columns.deleteCharAt(columns.length() - 1);
		}
		return formatIgnoreType(sql,tableName,columns,values);
	}

	public String getSeqNextVal(String sequenceName) {
		return null;
	}

	/**
	 * @see com.wenxing.daos.core.impl.EntitySessionImpl#setColumns(Table table)
	 */
	public String getTableColums(String tname) {
		//具体实现已经在 void com.ycsoft.daos.core.impl.EntitySessionImpl.setColumns(Table table) throws JDBCException 实现
//		return format("SELECT lower(t.column_name) FROM information_schema.columns t WHERE t.table_name = {0}",tname.toUpperCase());
		return null;
	}

	public String getUpdate(Table tb, List<String> columns) {
		//TODO 需要验证
		String sql = "UPDATE {0} t SET {1} WHERE t.{2} = ?";
		String cols = ListHelper.parseListToStr(""," = ? ", columns );
		return formatIgnoreType(sql,tb.getTableName(),cols,tb.getPrimaryKey());
	}

	public String getUpdate(Table tb, Map<String, Object> maps, Object key) {
		//TODO 需要验证
		String sql = "UPDATE `{0}` t SET {1} WHERE t.{2} = " + format("{0}",key);
		StringBuffer where = new StringBuffer();
		Iterator ite = maps.keySet().iterator();
		Object [] objs = new Object[maps.keySet().toArray().length];
		int i = 0 ;
		while(ite.hasNext()){
			Object str = ite.next();
			where.append( "t."+str +" = {"+ i +"} ,");
			Object val = maps.get(str);
			if (val instanceof Date){
				String dateStr = format("{0}",DateHelper.format((Date)val) );
				objs[i] = dateStr;
			}else{
				objs[i] = format("{0}",val) + "";
			}
			i ++ ;
		}
		if (where.length() > 0) {
			where.deleteCharAt(where.length() - 1);
		}
		return formatIgnoreType(
						sql,
						tb.getTableName(),
						formatIgnoreType(where.toString(),objs),
						tb.getPrimaryKey());
	}

	public String in(Object[] value) {
		String target = StringUtils.EMPTY;
		if(value == null ) return target;
		boolean flag = false;
		for (Object o : value) {
			if (o != null){
				target += format("{0},", o);
				flag = true;
			}
		}
		if (flag)
			return StringHelper.delEndChar( target ,  1 );
		else
			return "-111";
	}

	public String or(Map<String, Object> params) {
		String target = StringUtils.EMPTY;
		if(params == null ) return target;
		Iterator<String> ite = params.keySet().iterator();
		String key = null ;
		while(ite.hasNext()){
			key = ite.next();
			if( params.get(key) != null ){
				target += format( key + "={0}", params.get(key)) + " or ";
			}
		}
		return StringHelper.delEndChar( target , 3);
	}

	public String setWhereInArray(String name, Object[] value) {

		int inArrayNum = value.length % 1000 == 0 ? value.length
				/ 1000 : value.length / 1000 + 1;// 参数值一共能分割成多少组，记录总组数
		int m = 0;// 用来记录参数值数字的下标值
		int b = 0;// 用来记录参数值数组和sql片段，能分出多少个参数值片段就能分割成多少个sql片段
		int n = 1000;// 用来记录参数值数字下标值的步长，步长的长度等于需要分割的数量，如要1000
		String p[] = new String[inArrayNum];// 分割的参数值片段数组
		String arrySql[] = new String[inArrayNum];// 分割的sql片段数组
		for (int k = 0; k < value.length; k++) {
			if (b < inArrayNum) {
				p[b] = "";
				for (; m < n; m++) {
					if (m >= value.length) {
						break;
					}
					p[b] += "'" + value[m] + "',";
				}
				p[b] = p[b].substring(0, p[b].lastIndexOf(","));
				arrySql[b] =  " or " + name + " in ("+p[b]+")";
				b++;
				n += 1000;
			}
		}
		String sql ="";
		if(arrySql.length>0){
			arrySql[0] = StringHelper.delStartChar( arrySql[0] ,  3 );
			for (int q = 0; q < arrySql.length; q++) {
				sql += arrySql[q];
			}
		}
		return  sql;
	}

}
