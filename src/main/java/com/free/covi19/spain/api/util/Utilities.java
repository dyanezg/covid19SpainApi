package com.free.covi19.spain.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

	private static String patternDate = "dd/MM/yyyy HH:mm:ss";
	private static String patternDateSimple = "dd/MM/yyyy";

	public static String currentDateString() {
		DateFormat df = new SimpleDateFormat(patternDate);
		Date today = Calendar.getInstance().getTime();
		return df.format(today);
	}

	public static String formatDateString(Date date) {
		DateFormat df = new SimpleDateFormat(patternDateSimple);
		return df.format(date);
	}

	
}
