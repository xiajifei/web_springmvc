package com.xia.ssm.constant.ocr;

import org.apache.log4j.Logger;

/**
 * LOG4J日志循环输出
 * @ClassName: ErrorsLogPrintUtil
 * @description: TODO(LOG4J日志循环输出)
 * @version 1.0
 * @company：jy century
 * @createDate 2015-4-29;下午01:36:27
 * @author luy
 */
public class ErrorsLogPrintUtil {
	
	/**
	 * 向log4j日志内循环输出日志
	 * @Title: printToLog4j
	 * @param log
	 * @param errorStackTraceElements  
	 * @createDate 2015-4-29;下午02:00:17
	 * @author luy
	 */
	public static void printToLog4j(Logger log,Exception e){
		if(e!=null){
			//具体异常
			log.error(e);
			StackTraceElement[] errorStackTraceElements=e.getStackTrace();
			//获得异常轨迹
			if(errorStackTraceElements!=null){
				for(int i=0;i<errorStackTraceElements.length;i++){
					log.error(errorStackTraceElements[i].toString());
				}
			}
		}
	}
}
