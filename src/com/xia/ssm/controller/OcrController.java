package com.xia.ssm.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xia.ssm.constant.ocr.ActiveResponseClaimCode;
import com.xia.ssm.constant.ocr.ErrorsLogPrintUtil;
import com.xia.ssm.constant.ocr.ExceptionClaimCode;
import com.xia.ssm.tools.BeanUtil;
import com.xia.ssm.tools.DateTimeUtil;
import com.xia.ssm.tools.PropertyFactory;
import com.xia.ssm.tools.StringUtils;
import com.xia.ssm.tools.ocr.CheckPic;
import com.xia.ssm.tools.ocr.ClaimPhoneMehthod;
import com.xia.ssm.tools.ocr.WTUtils;
import com.xia.ssm.vo.ocr.ClaimPhoneDTO;
import com.xia.ssm.vo.ocr.LicenseDTO;


@Controller
@RequestMapping("ocrController")
public class OcrController {
    
    private final static Logger log = Logger.getLogger(OcrController.class);
    
    private static final String ocrPicPath = PropertyFactory.getProperty("ocr.ocrPicPath");
    private static final String onlineFlag = PropertyFactory.getProperty("ocr.onlineFlag");
    private static final String wtAddrUrl = PropertyFactory.getProperty("ocr.wtAddrUrl");
    
    @RequestMapping("drivingLicense")
    public void drivingLicense(@RequestBody String requestMsg, HttpServletRequest request,HttpServletResponse response) throws IOException{

        String  dataString="";
        ClaimPhoneDTO thPhoneDTO=new ClaimPhoneDTO();
        thPhoneDTO.setResponseCode(ExceptionClaimCode.QUEST_SUCCESS);
//        String sendType = request.getParameter("SendType");
//        if(StringUtils.notEmpty(sendType)){
            thPhoneDTO.setSendType("35");           
//        }else{
//            thPhoneDTO.setResponseCode(ActiveResponseClaimCode.DATA_INTEGRITY_ERROR);
//        }
       /* String companyCode = request.getParameter("companyCode");
        if(StringUtils.notEmpty(companyCode)){
            thPhoneDTO.setZzbh(companyCode);        
        }else{
            thPhoneDTO.setResponseCode(ActiveResponseClaimCode.DATA_INTEGRITY_ERROR);
        }*/
        if(thPhoneDTO.getSendType().equals(ExceptionClaimCode.DRIVING_LICENSE)){
            //保存的图片的名称  
//          String fileName = "456.jpg";     
            String fileName =System.currentTimeMillis() + ".jpg";
            
           //获得imge文件夹在tomcat中的决定路径，basePath的值是C:\Program Files\Apache Software Foundation\Apache Tomcat 6.0.20\webapps\flexTest\imge  
            String basePath = request.getSession().getServletContext().getRealPath("/imge/"); 
            
            File pathFile = new File(ocrPicPath);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }        
            try {
              String imagePath = "D://11.jpg";//图片地址  
               File file = new File(imagePath);
               FileInputStream in = new FileInputStream(file);
               //读取一个图片流
              BufferedImage bufferedImage = ImageIO.read(in);
//                BufferedImage bufferedImage = ImageIO.read(request.getInputStream());    
                if (bufferedImage != null) {    
                    //保存图片到指定的目录和文件中  
                    ImageIO.write(bufferedImage, "jpeg", new File(ocrPicPath , fileName));    
                }  
                
            } catch (Exception e) {
                e.printStackTrace();
                log.error("文通识别行驶证接口---------------------图片传送出错"+DateTimeUtil.getNowTimeEnglishString());
                log.error(e.getMessage());
                 thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_PIC_ERROR);
            }
            // 获得一个图片文件流，我这里是从flex中传过来的  
           thPhoneDTO.setPhotoNames(fileName);
           thPhoneDTO.setAppPath(ocrPicPath);
           thPhoneDTO.setLicenseImg(fileName);
          
           //根据图片 发送给云脉和者文通
           if (thPhoneDTO.getResponseCode().equals(ExceptionClaimCode.QUEST_SUCCESS)) {
               try {
                    thPhoneDTO.setOnlineFlag(onlineFlag);
                    thPhoneDTO.setWtAddrUrl(wtAddrUrl);
                    thPhoneDTO.setPicType(WTUtils.WT_PIC_TYPE);
                    
                    thPhoneDTO = CheckPic.sendPicToWt(thPhoneDTO);
                    
                    LicenseDTO licenseDTO=new LicenseDTO();
                    BeanUtil.copy(licenseDTO, thPhoneDTO);
//                    distinguishService.insertLicense(licenseDTO);
                    if (thPhoneDTO.getResponseCode().equals(ExceptionClaimCode.QUEST_SUCCESS)) {
                        StringBuffer json=new StringBuffer();
                        
                        json.append("{ResponseCode:'").append(thPhoneDTO.getResponseCode()).append("',")
                        .append("ResponseMessage:'").append(ExceptionClaimCode.EXCEPTION_CLAIMCODE_MAP.get(thPhoneDTO.getResponseCode())).append("',")
                        .append("PlateNo:'").append(thPhoneDTO.getPlateNo()==null?"":thPhoneDTO.getPlateNo()).append("',")
                        .append("VehicleType:'").append(thPhoneDTO.getVehicleType()==null?"":thPhoneDTO.getVehicleType()).append("',")
                        .append("CustomerName:'").append(thPhoneDTO.getCustomerName()!=null?thPhoneDTO.getCustomerName():"").append("',")
                        .append("Address:'").append(thPhoneDTO.getAddress()!=null?thPhoneDTO.getAddress():"").append("',")
                        .append("UseType:'").append(thPhoneDTO.getUseType()==null?"":thPhoneDTO.getUseType()).append("',")
                        .append("VehicleModels:'").append(thPhoneDTO.getVehicleModels()!=null?thPhoneDTO.getVehicleModels():"").append("',")
                        .append("VIN:'").append(thPhoneDTO.getVin()!=null?thPhoneDTO.getVin():"").append("',")
                        .append("EngineNo:'").append(thPhoneDTO.getEngineNo()!=null?thPhoneDTO.getEngineNo():"").append("',")
                        .append("RegisterDate:'").append(thPhoneDTO.getRegisterDate()!=null?thPhoneDTO.getRegisterDate():"").append("',")
                        .append("IssueDate:'").append(thPhoneDTO.getIssueDate()!=null?thPhoneDTO.getIssueDate():"").append("'}")
                        .append("Status:'").append(thPhoneDTO.getStatus()!=null?thPhoneDTO.getStatus():"").append("'}")
                        .append("State:'").append(thPhoneDTO.getState()!=null?thPhoneDTO.getState():"").append("'}");
                        dataString=json.toString();
                    }else{
                        dataString = ClaimPhoneMehthod.buildContentInterFaceJsonError(thPhoneDTO);
                        log.error("文通识别行驶证接口----------------识别行驶证失败"+DateTimeUtil.getNowTimeEnglishString());
                    }
                
               } catch (Exception e) {
                   ErrorsLogPrintUtil.printToLog4j(log, e);
                   log.error("文通识别行驶证接口----------------识别行驶证发生错误"+DateTimeUtil.getNowTimeEnglishString());
                   log.error(e.getMessage());
                   thPhoneDTO.setResponseCode(ExceptionClaimCode.DRIVERLICENSE_FAILED);
                   dataString = ClaimPhoneMehthod.buildContentInterFaceJsonError(thPhoneDTO);
               }
           }else{
               dataString = ClaimPhoneMehthod.buildContentInterFaceJsonError(thPhoneDTO);
           }
        }
    
    }

}
