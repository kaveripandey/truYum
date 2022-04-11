package com.cts.menuitemservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	public static Date convertToDate(String date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
		Date d=sdf.parse(date);
		return d;
		}
		catch(ParseException e) {}
		return null;
	}
}
