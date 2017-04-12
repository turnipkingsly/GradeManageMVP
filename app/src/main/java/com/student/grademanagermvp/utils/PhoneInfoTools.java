package com.student.grademanagermvp.utils;

import android.os.Build;

/**
 * 获取手机相关参数信息
 * @author Sunky
 *
 */
public class PhoneInfoTools {

	/**
	 * 获取ua
	 * @return
	 */
	public static String getUA() {
		String userAgent = Build.MODEL;
		return userAgent;
	}
}
