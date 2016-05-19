package com.xia.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.service.UserService;
import com.xia.ssm.vo.UserQueryVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryUsers")
	public ModelAndView queryUsers(UserQueryVo userQueryVo){
		List<UserCustom> userList = userService.findUserList(userQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("user/userList");
		return modelAndView;
	}

}
