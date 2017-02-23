package com.xia.ssm.tools.ocr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.xia.ssm.constant.ocr.ExceptionClaimCode;
import com.xia.ssm.tools.DateTimeUtil;
import com.xia.ssm.vo.ocr.ClaimPhoneDTO;


public class ClaimPhoneMehthod {
	
	private final static Logger log = Logger.getLogger(ClaimPhoneMehthod.class);
	
	public static ClaimPhoneDTO readInputStream(HttpServletRequest request,HttpServletResponse response,ClaimPhoneDTO thPhoneDTO){
		try{
			InputStream inputStream = request.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] data = null;
			byte[] b = new byte[1024]; 
			int read = 0;
			while ((read = inputStream.read(b)) != -1) {
				byteArrayOutputStream.write(b, 0, read);
			}
			data = byteArrayOutputStream.toByteArray();
			//关闭流操作
			inputStream.close();
			byteArrayOutputStream.close();
			//得到发送的字符串信息
			String requeString = new String(data,"utf-8");
			thPhoneDTO.setRequestMessage(requeString);
			log.info(requeString);
		}catch(Exception ex){
			log.info(ex.getMessage());
			log.error("APP发送信息读取出错------------"+DateTimeUtil.getNowTimeEnglishString());
			thPhoneDTO.setResponseCode(ExceptionClaimCode.SERVICE_NO_VALIDATE);
		}
		return thPhoneDTO;
		
	}
	public static String buildContentInterFaceJsonError(ClaimPhoneDTO thPhoneDTO) throws IOException {
		StringBuffer json = new StringBuffer();
		json.append("{ResponseCode:'").append(thPhoneDTO.getResponseCode()).append("',")
		    .append("ResponseMessage:'").append(ExceptionClaimCode.EXCEPTION_CLAIMCODE_MAP.get(thPhoneDTO.getResponseCode())).append("'}");
		log.info(json.toString());
		return json.toString();
	}
	
}