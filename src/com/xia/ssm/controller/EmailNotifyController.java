package com.xia.ssm.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xia.ssm.service.EmailNotifyService;
import com.xia.ssm.tools.PropertyFactory;
import com.xia.ssm.tools.SecurityCode;
import com.xia.ssm.vo.EmailVo;

/**
 * 邮件操作
 * 
 */
@Controller
@RequestMapping("/emailNotify")
public class EmailNotifyController {

	@Autowired
	private EmailNotifyService emailNotifyService;
	@Autowired
	private PropertyFactory propertyFactory;
	/**
	 * 
	 * @param request
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping("/sendEmail")
	@ResponseBody
	public String sendEmailNotify(HttpServletRequest request) throws MessagingException {


		String receivers = request.getParameter("mail");
		String verifyCode = SecurityCode.getSecurityCode();

		EmailVo emailVo = new EmailVo();
		emailVo.setReceivers(new String[] { receivers });
		emailVo.setCc(new String[] {});
		emailVo.setBcc(new String[] {});
		emailVo.setSubject("账号绑定邮箱验证码");
		emailVo.setSender("xiajfchina@163.com");
		emailVo.setEmailContent("<html><body>验证码：<font color=red>" + verifyCode
				+ "</font>，有效期"+propertyFactory.getProperty("sms.expirydate")+"分钟（乐修云帐号安全验证，请勿将验证码透露给他人）</body></html>");

		emailNotifyService.sendEmailMessageOfHtmlText(emailVo, new Date());

		return "1";
	}

	

	public void test() throws MessagingException {
		EmailVo emailVo = new EmailVo();
		emailVo.setReceivers(new String[] { "shenxiaoqiang@jingyougroup.com" });
		emailVo.setCc(new String[] {});
		emailVo.setBcc(new String[] {});
		emailVo.setSubject("测试");
		emailVo.setSender("lexiugo@163.com");
		emailVo.setEmailContent(
				"<html><body>短信验证码：<font color=red>456123</font>，有效期"+propertyFactory.getProperty("sms.expirydate")+"分钟（乐修云帐号安全验证，请勿将验证码透露给他人）</body></html>");

		File[] f = new File[] { new File("E:/OnKeyDetector.log"), new File("E:/OnKeyDetector2.log") };
		emailVo.setAttachFile(f);

		emailNotifyService.sendEmailMessageOfHtmlText(emailVo, new Date());

		emailNotifyService.sendEmailMessageOfAttachedFileAndSimpleText(emailVo, null, true);
	}
}
