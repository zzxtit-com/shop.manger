package com.zzxt.common.util;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {

	private static final String DATE      = "yyyy-MM-dd";
	
	private static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
	
	private static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

	
	public Object convert(Class type, Object value) {
		 if (value == null || "".equals(value))
	            return null;
	        if (value instanceof String) {
	            String dateValue = value.toString().trim();
	            int length = dateValue.length();
	            if (type.equals(java.util.Date.class)) {
	                try {
	                    DateFormat formatter = null;
	                    if (length <= 10) {
	                        formatter = new SimpleDateFormat(DATE, new DateFormatSymbols(Locale.CHINA));
	                        return formatter.parse(dateValue);
	                    }
	                    if (length <= 19) {
	                        formatter = new SimpleDateFormat(DATETIME, new DateFormatSymbols(Locale.CHINA));
	                        return formatter.parse(dateValue);
	                    }
	                    if (length <= 23) {
	                        formatter = new SimpleDateFormat(TIMESTAMP, new DateFormatSymbols(Locale.CHINA));
	                        return formatter.parse(dateValue);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return value;
	}


}
