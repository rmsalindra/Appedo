package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class C {
	public static void main(String[] args) {
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	    Date utcTime;
		try {
			utcTime = s.parse("08-10-2014 12:35:27");
			 System.out.println("UTC TIME::: "+utcTime);
			 System.out.println(sdf.format(utcTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
}
