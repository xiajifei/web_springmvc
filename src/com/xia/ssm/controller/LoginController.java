package com.xia.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("verify")
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password){
		//service
		
		//
		session.setAttribute("username", username);
		return "redirect:/user/queryUsers.action";
	}
	
	@RequestMapping("/logout")
	public  String logout(HttpSession session){
		session.invalidate();
		return "redirect:/user/queryUsers.action";
	} 

}
