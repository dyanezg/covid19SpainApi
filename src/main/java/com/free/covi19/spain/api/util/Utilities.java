package com.free.covi19.spain.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

	private static String patternDate = "dd/MM/yyyy HH:mm:ss";

	public static String currentDateString() {
		DateFormat df = new SimpleDateFormat(patternDate);
		Date today = Calendar.getInstance().getTime();
		return df.format(today);
	}

}
