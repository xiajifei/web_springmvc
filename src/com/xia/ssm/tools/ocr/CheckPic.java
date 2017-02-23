package com.xia.ssm.tools.ocr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.xia.ssm.constant.ocr.ErrorsLogPrintUtil;
import com.xia.ssm.constant.ocr.ExceptionClaimCode;
import com.xia.ssm.vo.ocr.ClaimPhoneDTO;

public class CheckPic {
	private static Logger log = Logger.getLogger(CheckPic.class);
	
	/**
	 * 行驶证
	 * @Title: sendPicToWt
	 * @param thPhoneDTO
	 * @return  
	 * @createDate 2016年10月26日;下午3:26:55
	 * @author xjf
	 */
	public static ClaimPhoneDTO sendPicToWt(ClaimPhoneDTO thPhoneDTO) {
			String result = "";
			String file=thPhoneDTO.getAppPath()+thPhoneDTO.getPhotoNames();//测试图片物理路径
			long beginTime=System.currentTimeMillis();
			try {
				log.info("file======"+file);
				result=WTUtils.invokeRemoteFuc(thPhoneDTO.getPicType(),WTUtils.WT_USERNAME, file, WTUtils.WT_PAR_BAK, WTUtils.WT_PIC_KIND,thPhoneDTO.getWtAddrUrl());
				log.info("result======"+result);
			} catch (Exception e) {
				// TODO: handle exception
				thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
				ErrorsLogPrintUtil.printToLog4j(log, e);
			}
			
			String[] encData = result.split("==@@");
			long times =System.currentTimeMillis()-beginTime;
			log.info("消耗时间："+times);
			String dataString = encData[0].replaceAll("<!\\[CDATA\\[", "").replaceAll("\\]\\]>", "");
			Document doc ;
			String insertString ="";
			try {
				doc = DocumentHelper.parseText(dataString);
				String status =  doc.selectSingleNode("/data/message/status").getText();
				String value  =  doc.selectSingleNode("/data/message/value").getText();
				StringBuffer sql =  new StringBuffer();
				if ("识别成功".equals(value)) {
					List list = doc.selectNodes("/data/cardsinfo/card/item");
					StringBuffer json=new StringBuffer();
					for (int j = 1; j < list.size()-1; j++) {
						Element term = (Element) list.get(j);
						String returString = term.getText();
						insertString += "'"+returString+"'"+",";
						String name=term.attribute("desc").getText();

						if("号牌号码".equals(name)){
							thPhoneDTO.setPlateNo(returString);
						}
						if("车辆类型".equals(name)){
							thPhoneDTO.setVehicleType(returString);
						}
						if("所有人".equals(name)){
							thPhoneDTO.setCustomerName(returString);
						}
						if("住址".equals(name)){
							thPhoneDTO.setAddress(returString);
						}
						if("品牌型号".equals(name)){
							thPhoneDTO.setVehicleModels(returString);
						}
						if("车辆识别代号".equals(name)){
							thPhoneDTO.setVin(returString);
						}
						if("发动机号码".equals(name)){
							thPhoneDTO.setEngineNo(returString);
						}
						if("注册日期".equals(name)){
							thPhoneDTO.setRegisterDate(returString);
						}
						if("发证日期".equals(name)){
							thPhoneDTO.setIssueDate(returString);
						}
						if("使用性质".equals(name)){
							thPhoneDTO.setUseType(returString);
						}
						thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
						thPhoneDTO.setState(value);
						thPhoneDTO.setStatus(status);
					}
				}else {
					thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
					thPhoneDTO.setState(value);
					thPhoneDTO.setStatus(status);
					thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
				}
			} catch (Exception e) {
				thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
				 ErrorsLogPrintUtil.printToLog4j(log, e);
			}
		return thPhoneDTO;
	}
	public static Connection getCon(){
		try{
			//连接SQLServer2005
			String urlString="jdbc:sqlserver://192.168.110.200:1433;DatabaseName=修理厂品牌";
			String nameString="sa";
			String pasString ="sa1";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(urlString,nameString,pasString);
			return con;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public static String getMillisecond() {
		String str = new Timestamp(System.currentTimeMillis()).toString().replaceAll("-","").replaceAll(" ", "").replaceAll(":", "").replaceAll("\\.", "");
		return str;
	}

	/**
	 * 车牌
	 * @Title: sendPlateNoPicToWt
	 * @param thPhoneDTO
	 * @return  
	 * @createDate 2016年10月26日;下午3:31:45
	 * @author luy
	 */
	public static ClaimPhoneDTO sendPlateNoPicToWt(ClaimPhoneDTO thPhoneDTO) {
    		String result = "";
    		String file=thPhoneDTO.getAppPath()+thPhoneDTO.getPhotoNames();//测试图片物理路径
    		long beginTime=System.currentTimeMillis();
    		try {
    			log.info("file======"+file);
    			result=WTUtils.invokeRemoteFuc(thPhoneDTO.getPicType(),WTUtils.WT_USERNAME, file, WTUtils.WT_PAR_BAK, WTUtils.WT_PIC_KIND,thPhoneDTO.getWtAddrUrl());
    			log.info("result======"+result);
    		} catch (Exception e) {
    			// TODO: handle exception
    			thPhoneDTO.setResponseCode(ExceptionClaimCode.PLATENO_FAILED);
    			ErrorsLogPrintUtil.printToLog4j(log, e);
    		}
    		
    		String[] encData = result.split("==@@");
    		long times =System.currentTimeMillis()-beginTime;
    		log.info("消耗时间："+times);
    		String dataString = encData[0].replaceAll("<!\\[CDATA\\[", "").replaceAll("\\]\\]>", "");
    		Document doc ;
    		String insertString ="";
    		try {
    			doc = DocumentHelper.parseText(dataString);
    			String status =  doc.selectSingleNode("/data/message/status").getText();
    			String value  =  doc.selectSingleNode("/data/message/value").getText();
    			if ("识别成功".equals(value)) {
    				List list = doc.selectNodes("/data/cardsinfo/card/item");
    				for (int j = 0; j < list.size(); j++) {
    					Element term = (Element) list.get(j);
    					String returString = term.getText();
    					insertString += "'"+returString+"'"+",";
    					String name=term.attribute("desc").getText();
    					if ("车牌号".equals(name)) {
    						thPhoneDTO.setPlateNo(returString);
    					}
    					thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
    					thPhoneDTO.setState(value);
    					thPhoneDTO.setStatus(status);
    				}
    			}else {
    				thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
    				thPhoneDTO.setState(value);
    				thPhoneDTO.setStatus(status);
    				thPhoneDTO.setResponseCode(ExceptionClaimCode.PLATENO_FAILED);
    			}
    		} catch (Exception e) {
    			thPhoneDTO.setResponseCode(ExceptionClaimCode.PLATENO_FAILED);
    			 ErrorsLogPrintUtil.printToLog4j(log, e);
    		}
    	return thPhoneDTO;
	}
	
	/**
	 * 身份证
	 * @Title: sendIdCardToWt
	 * @param thPhoneDTO
	 * @return  
	 * @createDate 2016年10月26日;下午3:32:41
	 * @author xjf
	 */
	public static ClaimPhoneDTO sendIdCardToWt(ClaimPhoneDTO thPhoneDTO) {
        String result = "";
        String file=thPhoneDTO.getAppPath()+thPhoneDTO.getPhotoNames();//测试图片物理路径
        long beginTime=System.currentTimeMillis();
        try {
            log.info("file======"+file);
            result=WTUtils.invokeRemoteFuc(thPhoneDTO.getPicType(),WTUtils.WT_USERNAME, file, WTUtils.WT_PAR_BAK, WTUtils.WT_PIC_KIND,thPhoneDTO.getWtAddrUrl());
            log.info("result======"+result);
        } catch (Exception e) {
            // TODO: handle exception
            thPhoneDTO.setResponseCode(ExceptionClaimCode.IDCARD_FAILED);
            ErrorsLogPrintUtil.printToLog4j(log, e);
        }
        
        String[] encData = result.split("==@@");
        long times =System.currentTimeMillis()-beginTime;
        log.info("消耗时间："+times);
        String dataString = encData[0].replaceAll("<!\\[CDATA\\[", "").replaceAll("\\]\\]>", "");
        Document doc ;
        String insertString ="";
        try {
            doc = DocumentHelper.parseText(dataString);
            String status =  doc.selectSingleNode("/data/message/status").getText();
            String value  =  doc.selectSingleNode("/data/message/value").getText();
            if ("识别成功".equals(value)) {
                List list = doc.selectNodes("/data/cardsinfo/card/item");
                for (int j = 1; j < list.size()-1; j++) {
                    Element term = (Element) list.get(j);
                    String returString = term.getText();
                    insertString += "'"+returString+"'"+",";
                    String name=term.attribute("desc").getText();

                    if("姓名".equals(name)){
                        thPhoneDTO.setUserName(returString);
                    }
                    if("性别".equals(name)){
                        thPhoneDTO.setSex(returString);
                    }
                    if("民族".equals(name)){
                        thPhoneDTO.setNation(returString);
                    }
                    if("出生".equals(name)){
                        thPhoneDTO.setBirthday(returString);
                    }
                    if("住址".equals(name)){
                        thPhoneDTO.setAddress(returString);
                    }
                    if("公民身份号码".equals(name)){
                        thPhoneDTO.setIdCardNo(returString);
                    }
                    if("头像".equals(name)){
                        thPhoneDTO.setIdCardPhoto(returString);
                    }
                    thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
                    thPhoneDTO.setState(value);
                    thPhoneDTO.setStatus(status);
                }
            }else {
                thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
                thPhoneDTO.setState(value);
                thPhoneDTO.setStatus(status);
                thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
            }
        } catch (Exception e) {
            thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
             ErrorsLogPrintUtil.printToLog4j(log, e);
        }
    return thPhoneDTO;
	}
	/**
	 * 驾驶证
	 * @Title: sendDriverToWt
	 * @param thPhoneDTO
	 * @return  
	 * @createDate 2016年10月26日;下午3:33:28
	 * @author luy
	 */
	public static ClaimPhoneDTO sendDriverToWt(ClaimPhoneDTO thPhoneDTO) {
        String result = "";
        String file=thPhoneDTO.getAppPath()+thPhoneDTO.getPhotoNames();//测试图片物理路径
        long beginTime=System.currentTimeMillis();
        try {
            log.info("file======"+file);
            result=WTUtils.invokeRemoteFuc(thPhoneDTO.getPicType(),WTUtils.WT_USERNAME, file, WTUtils.WT_PAR_BAK, WTUtils.WT_PIC_KIND,thPhoneDTO.getWtAddrUrl());
            log.info("result======"+result);
        } catch (Exception e) {
            // TODO: handle exception
            thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVER_FAILED);
            ErrorsLogPrintUtil.printToLog4j(log, e);
        }
        
        String[] encData = result.split("==@@");
        long times =System.currentTimeMillis()-beginTime;
        log.info("消耗时间："+times);
        String dataString = encData[0].replaceAll("<!\\[CDATA\\[", "").replaceAll("\\]\\]>", "");
        Document doc ;
        String insertString ="";
        try {
            doc = DocumentHelper.parseText(dataString);
            String status =  doc.selectSingleNode("/data/message/status").getText();
            String value  =  doc.selectSingleNode("/data/message/value").getText();
            if ("识别成功".equals(value)) {
                List list = doc.selectNodes("/data/cardsinfo/card/item");
                for (int j = 1; j < list.size()-1; j++) {
                    Element term = (Element) list.get(j);
                    String returString = term.getText();
                    insertString += "'"+returString+"'"+",";
                    String name=term.attribute("desc").getText();

                    if("证号".equals(name)){
                        thPhoneDTO.setCardNo(returString);
                    }
                    if("姓名".equals(name)){
                        thPhoneDTO.setUserName(returString);
                    }
                    if("性别".equals(name)){
                        thPhoneDTO.setSex(returString);
                    }
                    if("住址".equals(name)){
                        thPhoneDTO.setAddress(returString);
                    }
                    if("出生日期".equals(name)){
                        thPhoneDTO.setBirthday(returString);
                    }
                    if("初始领证日期".equals(name)){
                        thPhoneDTO.setRegisterTime(returString);
                    }
                    if("准驾车型".equals(name)){
                        thPhoneDTO.setDrivingType(returString);
                    }
                    if("有效起始日期".equals(name)){
                        thPhoneDTO.setStartTime(returString);
                    }
                    if("有效期限".equals(name)){
                        thPhoneDTO.setLimitTime(returString);
                    }
                    if("有效截止日期".equals(name)){
                        thPhoneDTO.setEndTime(returString);
                    }
                    thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
                    thPhoneDTO.setState(value);
                    thPhoneDTO.setStatus(status);
                }
            }else {
                thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
                thPhoneDTO.setState(value);
                thPhoneDTO.setStatus(status);
                thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
            }
        } catch (Exception e) {
            thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
             ErrorsLogPrintUtil.printToLog4j(log, e);
        }
    return thPhoneDTO;
	}
	
	/**
	 * 银行卡
	 * @Title: sendBankToWt
	 * @param thPhoneDTO
	 * @return  
	 * @createDate 2016年10月26日;下午6:39:23
	 * @author luy
	 */
    public static ClaimPhoneDTO sendBankToWt(ClaimPhoneDTO thPhoneDTO) {
        String result = "";
        String file=thPhoneDTO.getAppPath()+thPhoneDTO.getPhotoNames();//测试图片物理路径
        long beginTime=System.currentTimeMillis();
        try {
            log.info("file======"+file);
            result=WTUtils.invokeRemoteFuc(thPhoneDTO.getPicType(),WTUtils.WT_USERNAME, file, WTUtils.WT_PAR_BAK, WTUtils.WT_PIC_KIND,thPhoneDTO.getWtAddrUrl());
            log.info("result======"+result);
        } catch (Exception e) {
            // TODO: handle exception
            thPhoneDTO.setResponseCode(ExceptionClaimCode.BANK_FAILED);
            ErrorsLogPrintUtil.printToLog4j(log, e);
        }
        
        String[] encData = result.split("==@@");
        long times =System.currentTimeMillis()-beginTime;
        log.info("消耗时间："+times);
        String dataString = encData[0].replaceAll("<!\\[CDATA\\[", "").replaceAll("\\]\\]>", "");
        Document doc ;
        String insertString ="";
        try {
            doc = DocumentHelper.parseText(dataString);
            String status =  doc.selectSingleNode("/data/message/status").getText();
            String value  =  doc.selectSingleNode("/data/message/value").getText();
            if ("识别成功".equals(value)) {
                List list = doc.selectNodes("/data/cardsinfo/card/item");
                for (int j = 1; j < list.size()-1; j++) {
                    Element term = (Element) list.get(j);
                    String returString = term.getText();
                    insertString += "'"+returString+"'"+",";
                    String name=term.attribute("desc").getText();

                    if("号牌号码".equals(name)){
                        thPhoneDTO.setPlateNo(returString);
                    }
                    if("车辆类型".equals(name)){
                        thPhoneDTO.setVehicleType(returString);
                    }
                    if("所有人".equals(name)){
                        thPhoneDTO.setCustomerName(returString);
                    }
                    if("住址".equals(name)){
                        thPhoneDTO.setAddress(returString);
                    }
                    if("品牌型号".equals(name)){
                        thPhoneDTO.setVehicleModels(returString);
                    }
                    if("车辆识别代号".equals(name)){
                        thPhoneDTO.setVin(returString);
                    }
                    if("发动机号码".equals(name)){
                        thPhoneDTO.setEngineNo(returString);
                    }
                    if("注册日期".equals(name)){
                        thPhoneDTO.setRegisterDate(returString);
                    }
                    if("发证日期".equals(name)){
                        thPhoneDTO.setIssueDate(returString);
                    }
                    if("使用性质".equals(name)){
                        thPhoneDTO.setUseType(returString);
                    }
                    thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
                    thPhoneDTO.setState(value);
                    thPhoneDTO.setStatus(status);
                }
            }else {
                thPhoneDTO.setConsumeTime(""+String.valueOf(times)+"");
                thPhoneDTO.setState(value);
                thPhoneDTO.setStatus(status);
                thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
            }
        } catch (Exception e) {
            thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
             ErrorsLogPrintUtil.printToLog4j(log, e);
        }
    return thPhoneDTO;
    }
}
