package com.xia.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping("/queryUsers")
	public String queryUsers(){
		List<UserCustom> userList = userService.findUserList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("user/userList");
		return "user/userList";
	}*/
	@RequestMapping("/queryUsers")
	public ModelAndView queryUsers(){
		List<UserCustom> userList = userService.findUserList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("user/userList");
		return modelAndView;
	}

}
