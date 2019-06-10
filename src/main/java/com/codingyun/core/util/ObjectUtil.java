package com.codingyun.core.util;

import java.lang.reflect.Field;

import com.codingyun.core.constant.TableConstant;

/**
 * 对象工具类
 * @author coding云
 */
public class ObjectUtil {
	
	private static <T> String getClassFieldStr(Class<T> beanClass){
		Field[] fields = beanClass.getDeclaredFields();
		StringBuilder str = new StringBuilder();
		for(Field field: fields){
			if(!field.getName().endsWith("Str")){
				str.append(field.getName() + ",");
			}
		}
		String fieldStr = str.substring(0, str.length()-1);
		//replace方法无需判断是否包含该字符串
		fieldStr = str.toString().replace("serialVersionUID,", "");
		fieldStr = fieldStr.replace(
				TableConstant.TABLE_PRIMARY_KEY.get(
						TableConstant.TABLE_BEAN.get(beanClass.getName())) + ",", "");
		return fieldStr;
	}
	
	/**
	 * 为框架的GeneralDao提供工具方法
	 * 拿到实体类后，返回需要insert到数据库中的字段数组，该数组不包括（serialVersionUID，主键）两个字段
	 * @user coding云
	 * 2014年5月28日
	 */
	public static <T> String[] getEntityFiled(Class<T> beanClass){
		return getClassFieldStr(beanClass).split(",");
	}
	
//	public static void main(String[] args){
//		User user = new User();
//		String[] fieldArr = getEntityFiled(user.getClass());
//		System.out.println(fieldArr.toString());
//	}

}
