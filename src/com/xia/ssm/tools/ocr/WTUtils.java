package com.xia.ssm.tools.ocr;

import java.rmi.RemoteException;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.log4j.Logger;

import com.wintone.Adaptor.CipherAdaptor;
import com.xia.ssm.constant.ocr.ErrorsLogPrintUtil;

public class WTUtils {
	private static Logger log = Logger.getLogger(WTUtils.class);
	//文通识别图片接口用户名
	public static final String WT_USERNAME = "test";
	//文通接口地址
//	public static final String WT_ADDR = "http://101.200.91.233:8888/cxfServerX/ImgReconCard";
	//文通识别行驶证参数名1
	public static final String WT_PAR_01 = "arg0";
	//文通识别行驶证参数名2
	public static final String WT_PAR_02 = "arg1";
	//文通识别行驶证参数名3
	public static final String WT_PAR_03 = "arg2";
	//文通识别行驶证参数名4
	public static final String WT_PAR_04 = "arg3";
	//文通识别行驶证方法名
	public static final String WT_FUNCTION_NAME = "doAllCardRecon";
	//文通识别图片类型 6--行驶证
	public static final String WT_PIC_TYPE = "6";
	//文通识别图片类型 19--车牌照
	public static final String WT_PLA_TYPE = "19";
	//文通识别图片类型 2--二代身份证
	public static final String WT_IDENTIFY_TYPE = "2";
	//文通识别图片类型 5--驾驶证
	public static final String WT_DRIVER_TYPE = "5";
	//文通识别图片类型 17--银行卡
	public static final String WT_BANK_TYPE = "17";
	
	
	//文通识别图片格式
	public static final String WT_PIC_KIND = "jpg";
	//文通识别图片备用参数
	public static final String WT_PAR_BAK=null;
	
	 public static String invokeRemoteFuc(String picType,String username, String file,
				String signdata,String imgtype ,String wtAddrUrl) {
	        String endpoint = wtAddrUrl;
	        String result = "";

			//设置https代理，https默认走端口443【跟http端口不通】
//	        if("1".equals(onlineFlag)){
//	        	System.setProperty("http.proxyHost","192.168.0.247");
//	        	System.setProperty("http.proxyPort","80");
//	        }
	        Service service = new Service();
	        Call call;
	        Object[] object = new Object[4];
	        object[0] = username;//Object是用来存储方法的参数
	        CipherAdaptor clientAdaptor = new CipherAdaptor();
	        String strsrc = clientAdaptor.setRecgnPlainParam(file,picType,"", null);
	        object[1] = strsrc;//Object是用来存储方法的参数
	        object[2] = signdata;//Object是用来存储方法的参数
	        object[3] = imgtype;//Object是用来存储方法的参数
	        try {
	            call = (Call) service.createCall();
	            call.setTimeout(15 * 1000);// 15秒
	            call.setTargetEndpointAddress(endpoint);// 远程调用路径
	            call.setOperationName(WTUtils.WT_FUNCTION_NAME);// 调用的方法名
	 
	            // 设置参数名:
	            call.addParameter(WTUtils.WT_PAR_01, // 参数名
	                    XMLType.XSD_STRING,// 参数类型:String
	                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
	            call.addParameter(WTUtils.WT_PAR_02, // 参数名
	            		XMLType.XSD_STRING,// 参数类型:String
	            		ParameterMode.IN);// 参数模式：'IN' or 'OUT'
	            call.addParameter(WTUtils.WT_PAR_03, // 参数名
	            		XMLType.XSD_STRING,// 参数类型:String
	            		ParameterMode.IN);// 参数模式：'IN' or 'OUT'
	            call.addParameter(WTUtils.WT_PAR_04, // 参数名
	            		XMLType.XSD_STRING,// 参数类型:String
	            		ParameterMode.IN);// 参数模式：'IN' or 'OUT'
	 
	            // 设置返回值类型：
	            call.setReturnType(XMLType.XSD_STRING);// 返回值类型：String          
	 
	            result = (String) call.invoke(object);// 远程调用
	        } catch (ServiceException e) {
	        	ErrorsLogPrintUtil.printToLog4j(log, e);
	        } catch (RemoteException e) {
	            ErrorsLogPrintUtil.printToLog4j(log, e);
	        } catch (Exception e) {
	            ErrorsLogPrintUtil.printToLog4j(log, e);
	        }
	        return result;
	    }
}
