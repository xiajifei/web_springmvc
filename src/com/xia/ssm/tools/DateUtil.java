package com.xia.ssm.tools;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * String转成Date类型
	 * @param str
	 * @param formateStr
	 * @return
	 */
	public static Date Str2Date(String str,String formateStr){
		if(formateStr == null){  
			formateStr = "yyyy-MM-dd";  
        }
		SimpleDateFormat sdf = new SimpleDateFormat(formateStr); 
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Date转为String（有格式使用传入格式，没有使用"yyyy-MM-dd"）
	 * @param date  日期
	 * @param formateStr 格式
	 * @return
	 */
	public static String Date2Str(Date date,String formateStr){
		if(date == null){  
            return "";  
        }
		if(formateStr == null){  
			formateStr = "yyyy-MM-dd";  
        }
		SimpleDateFormat sdf = new SimpleDateFormat(formateStr);
		String str = "";
		try {  
	         str = sdf.format(date);  
	        } catch (Exception ex) {  
	         ex.printStackTrace();  
	        }
		return str;
	} 
}
