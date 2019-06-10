package com.codingyun.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获取今天的0点时间
	 * @user coding云
	 * 2014年7月12日
	 */
	public static Date getTodayStartTime(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * 格式 化日期，返回符合格式的字符串
	 * @param date
	 * @param formater   如:yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 */
	private static String getDateStrCompact(Date date, String formater) {
		if (date == null){
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		String str = format.format(date);
		return str;
	}

	/**
	 * 格式 化日期，返回符合格式的字符串
	 * @param date
	 * @param formater   默认 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateToString(Date date,String formatStr) {
		if(formatStr==null || "".equals(formatStr.trim())){
			formatStr="yyyy-MM-dd HH:mm:ss";
		}
		return getDateStrCompact(date, formatStr);
	}
	
	/**
	 * 格式化日期字符串，返回符合格式的date
	 * @param dateStr
	 * @param formater   如:yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 */
	public static Date StringToDate(String dateStr, String formater){
		Date date = null;
		if(formater==null || "".equals(formater.trim())){
			formater = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		if(!StringUtil.isNotBlank(dateStr)){
			return date;
		}
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将日期增减 n 天
	 * @param date  参照日期,如果为null则取当前日期
	 * @param days  增减的天数 (为正数则增加，为负数则减少)
	 * @return Date
	 */
	public static Date addDate(Date date, int days) {
		return addDate(date, days, Calendar.DATE);
	}
	
	/**
	 * 取某一日期增减 n 值后的日期, n 由 dateField 决定是年、月、日 根据增加or减少的时间得到新的日期
	 * @param date 参照日期
	 * @param counts 增减的数值
	 * @param dateField
	 *            int 需操作的日期字段, 取值范围如下 Calendar.YEAY 年 Calendar.MONTH 月
	 *            Calendar.DATE 日 .... Calendar.SECOND 秒
	 * @return Date
	 */
	private static Date addDate(Date date, int counts, int dateField) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateField, counts);
		return calendar.getTime();
	}
	
	public static long getTimeInMillis(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

}
