package com.flying.email.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectHelper {

	/**
	 * 计算延迟时间
	 * 
	 * @return
	 * @param delaytime
	 *            延迟时间格式：1900-01-01 07:00:00 延迟7小时
	 * @param calcdate
	 *            待计算时间(运行时间)
	 */
	public static Date CalclateDelayTime(Date delayTime, Date calcDate) {
		long origintime = -2209017600000L;
		long dtime = delayTime.getTime();
		Calendar ca = Calendar.getInstance();
		ca.setTime(calcDate);
		long addseconds = 0L;
		//// 计算时间,增加两个时间之间的时间差
		if (dtime < 0) {
			addseconds = origintime * (-1) + dtime;
		}
		ca.add(Calendar.MILLISECOND, (int) addseconds);
		return ca.getTime();
	}

	/**
	 * 根据数据周期获取，下一周期时间
	 * 
	 * @param datatime
	 *            需要计算的时间
	 * @param datacycle
	 *            周期类型 1:小时、2:天、3:周、4:月、5:季、6:月
	 * @return
	 */
	public static Date CalcCycleDataDateTime(Date datatime, int datacycle) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datatime);
		switch (datacycle) {
		case 1:// 小时
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			break;
		case 2:// 天
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		case 3:// 周
			calendar.add(Calendar.DAY_OF_MONTH, 7);
		case 4:// 月
			calendar.add(Calendar.MONTH, 1);
		case 5:// 季
			calendar.add(Calendar.MONTH, 3);
		case 6:// 年
			calendar.add(Calendar.YEAR, 1);
		default:
			calendar.add(Calendar.SECOND, 0);
			break;
		}

		return calendar.getTime();
	}

	/**
	 * 解析原Sql参数，获取真是sql
	 * 
	 * @param orisql
	 *            原始sql
	 * @param datadatetime
	 *            数据时间
	 * @return
	 */
	public static String getSqlString(String orisql, Date datadatetime) {
		//// 获取当前的所有参数
		TreeSet<String> listresult = getParam(orisql);
		Iterator<String> iterable = listresult.iterator();
		HashMap<String, String> parammap = new HashMap<String, String>();
		while (iterable.hasNext()) {
			parammap.put(iterable.next(), getParamValue(iterable.next(), datadatetime));
		}

		//// 遍历所有的参数，重新赋值并且替换原值
		Iterator<Entry<String, String>> iterable2 = parammap.entrySet().iterator();
		while (iterable2.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Entry) iterable2.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			orisql = orisql.replaceAll("${" + key + "}", value);
		}

		return orisql;
	}

	/**
	 * 获取当前所有参数
	 * 
	 * @param oristring
	 * @return
	 */
	public static TreeSet<String> getParam(String oristring) {
		TreeSet<String> result = new TreeSet<String>();
		String regex = "\\$\\{(.*?)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(oristring);
		while (matcher.find()) {
			if (!result.contains(matcher.group(1))) {
				result.add(matcher.group(1));
			}
		}

		return result;
	}

	/**
	 * 获取参数对应的真实值
	 * 
	 * @param param
	 *            数据参数
	 * @param datetime
	 *            数据时间
	 * @return
	 */
	public static String getParamValue(String param, Date datetime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(datetime);
		switch (param.toLowerCase()) {
		case "datadatetime":
			return datetime.toString();
		case "yyyymmddhh":
			return dateString.substring(0, 10);
		case "yyyymmdd":
			return dateString.substring(0, 8);
		case "yyyymm":
			return dateString.substring(0, 6);
		case "yyyy":
			return dateString.substring(0, 4);
		default:
			return datetime.toString();
		}
	}
}
