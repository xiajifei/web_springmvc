package com.xia.ssm.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @description: 字符类工具
 * @version 4.1
 * @company：jy
 * @createDate 2007-6-19
 * @author luzhenglai
 */

public class StringUtils {

	public StringUtils() {
	}

	public static String substring(String str, int max) {
		String tmp = empty2Null(str);
		if (tmp == null || tmp.length() <= max)
			return str;
		else
			return str.substring(0, max);
	}

	public static String randomString(int length) {
		String str = null;
		if (length <= 0)
			return null;
		String charset = "abcdefghijklmnopqrstuvwxyz1234567890!#$@%&*-=+|/ABCDEFGHIJKLMNOQPRSTUVWXYZ";
		Random r = new Random();
		Random r1 = new Random();
		StringBuffer bf = new StringBuffer();
		int ba = Math.abs(r1.nextInt() % length) + 1;
		for (int i = 0; i < ba; i++) {
			int radix = Math.abs(r.nextInt(ba) % charset.length());
			char c = charset.charAt(radix);
			bf.append(c);
		}

		str = bf.toString();
		return str;
	}

	public static String null2Empty(String s) {
		if (s == null)
			s = "";
		return s;
	}

	public static String empty2Null(String s) {
		if (s != null && s.trim().length() == 0)
			s = null;
		return s;
	}

	public static boolean isNumeric(String str) {
		if (str == null)
			return false;
		int sz = str.length();
		for (int i = 0; i < sz; i++)
			if (!Character.isDigit(str.charAt(i)))
				return false;

		return true;
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0)
			return true;
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return false;

		return true;
	}

	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	public static String toHtml(String s) {
		String html = s;
		if (s == null || s.length() == 0)
			return "&nbsp";
		char symbol[] = { '&', '<', '>', '"', '\r' };
		String obj[] = { "&amp;", "&lt;", "&gt;", "&quot;", "<br>" };
		for (int i = 0; i < symbol.length; i++)
			html = html.replaceAll(String.valueOf(symbol[i]), obj[i]);

		return html;
	}

	public static boolean notEmpty(Object o) {
		return o != null && !"".equals(o.toString())
				&& !"null".equalsIgnoreCase(o.toString())
				&& !"undefined".equalsIgnoreCase(o.toString());
	}

	/**
	 * 转换成sql的查询in条件
	 * 
	 * @param s
	 *            ex. "1,2,3,4,5,6,"
	 * @return '1','2','3','4','5','6'
	 */
	public static String toQueryStr(String s) {
		if (s.indexOf(",") != -1) {
			String[] tmp = s.split(",");
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < tmp.length; i++) {
				str.append("'").append(tmp[i].trim()).append("',");
			}
			return str.toString().substring(0, str.lastIndexOf(","));
		}
		return "'" + s + "'";
	}
	
	
	public static Date DateYearToThisYear(Date currentDate){
		try {
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date insureDate = currentDate;
			 String date = sdf.format  (currentDate);
			 Date nowDate = new Date();
			 if (insureDate.before(nowDate)) {
				String nowDateString = sdf.format(nowDate);
				String nowYearString = nowDateString.split("-")[0];
				String insureMonthString = date.split("-")[1];
				String insureDayString =  date.split("-")[2];
				String newInsureDateString = nowYearString+"-"+insureMonthString+"-"+insureDayString;
				Date newInsureDate = sdf.parse(newInsureDateString);
				if (newInsureDate.before(nowDate)) {
					String insure2DateString = (Integer.valueOf(nowYearString)+1)+"-"+insureMonthString+"-"+insureDayString;
					return sdf.parse(insure2DateString);
				}else {
					return newInsureDate;
				}
			}else {
				return insureDate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 判断空返回值,默认返回空字符串
	 * @Title: emptyDeal
	 * @return  
	 * @createDate 2015-5-11;下午01:16:41
	 * @author luy
	 */
	public static String emptyDeal(String value){
		return notEmpty(value)?value:"";
	}
	/**
	 * 判断空返回值，可根据需求调整默认返回值
	 * @Title: emptyDeal
	 * @return  
	 * @createDate 2015-5-11;下午01:16:41
	 * @author luy
	 */
	public static String emptyDeal(String value,String defValue){
		return notEmpty(value)?value:defValue;
	}
	/**
	 * +1 number
	 * @Title: getNumJia 
	 * @Description: TODO
	 * @param num
	 * @return
	 * @return int    返回类型 
	 * @author ax
	 * @date2016-5-26下午2:20:03
	 * @throws
	 */
	public static final int getNumJia(int num) {
		
		int nums =0;
		for (int i = 0; i < num+1; i++) {
			nums= i+1;
		}
		
		return nums;
		
	}
	/**
	 * -1  number
	 * @Title: getNumJian 
	 * @Description: TODO
	 * @param num
	 * @return
	 * @return int    返回类型 
	 * @author ax
	 * @date2016-5-26下午2:20:15
	 * @throws
	 */
	public static final int getNumJian(int num) {
		
		int nums =0;
		for (int i = 0; i < num; i++) {
			nums= i;
		}
		
		return nums;
		
	}
	
	public static void main(String[] args){
		
//		String md5 = getMD5("1234s","gbht_yfp");
//		System.out.println(md5);
	}
}
