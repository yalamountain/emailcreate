package com.flying.email.util;

import java.util.Calendar;
import java.util.Date;

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
		//// 计算时间,增加两个时间之间的时间差
		ca.add(Calendar.SECOND, (int) (dtime - origintime));
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
}
