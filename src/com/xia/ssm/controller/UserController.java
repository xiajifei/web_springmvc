package com.xia.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	public ModelAndView queryUsers(
			Model model,@Validated UserQueryVo userQueryVo,BindingResult bindingResult){
		List<UserCustom> userList = userService.findUserList(userQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("userList",userList);
		modelAndView.setViewName("user/userList");
		//遍历validated校验错误信息
		if(bindingResult.hasErrors()){
			System.out.println("validated错误信息：");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error);
			}
		}
		return modelAndView;
	}

}
