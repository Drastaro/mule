package com.mule.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	public static String getFormattedDateAsString(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date getFormattedDateFromString(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
