package com;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class CurrentTime {

	private static final SimpleDateFormat monthDayYearformatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	public static void main(String[] args) {
		
		java.util.Date date= new java.util.Date();
		monthDayYearformatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strtoday = monthDayYearformatter.format(new Timestamp(date.getTime()));
		System.out.println(strtoday);
	}
}
