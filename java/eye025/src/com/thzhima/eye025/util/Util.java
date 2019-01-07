package com.thzhima.eye025.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Util {

	/**
	 * 解析日期
	 * @param str ： 1990-3-3   1990/3/3
	 * @return
	 */
	public static Date parseDate(String str) {
		Date d = null;
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy/MM/dd");
		String regex1 = "^\\d{2,4}-\\d{1,2}-\\d{1,2}$";
		String regex2 = "^\\d{2,4}/\\d{1,2}/\\d{1,2}$";
		
		try {
			if(Pattern.matches(regex1, str)) {
				d = f1.parse(str);
			}
			else if(Pattern.matches(regex2, str)) {
				d = f2.parse(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}
}
