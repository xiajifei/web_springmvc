package com.xia.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.service.UserService;
import com.xia.ssm.vo.UserQueryVo;
//https://github.com/xiajifei/web_springmvc.git

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 根据查询条件查询所有信息
	 * @param model
	 * @param userQueryVo
	 * @param bindingResult
	 * @return
	 */
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
	
	/**
	 * 根据id查找用户
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/findUserById")
	public String findUserById(
			HttpServletRequest request,@RequestParam(value="id") String id){
		UserCustom user = userService.findUserById(id);
		request.setAttribute("user", user);
		return "user/edituser";
	}
	/**
	 * 定位到插入页面
	 * @return
	 */
	@RequestMapping("/inserUserForm")
	public String insertUserForm(){
		return "user/insertuser";
	}
	
	/**
	 * 插入用户信息
	 * @param userCustom
	 * @return
	 */
	@RequestMapping("/insertUser") 
	public String insertUser(UserCustom userCustom){
		userService.insertUser(userCustom);
		return "redirect:/user/queryUsers.action";
	}
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUserById")
	public String deleteUserById(String id){
		userService.deleteUserById(id);
		return "redirect:/user/queryUsers.action";
	}
	/**
	 * 定位到插入页面
	 * @return
	 */
	@RequestMapping("/turnJson")
	public String turnJson(){
		return "test/jsonTest";
	}
	/**
	 * 返回json
	 * @requestBody将请求的json转为对象
	 * @responseBody将响应的对象转为json
	 */
	@RequestMapping("/requestJson")
	public @ResponseBody UserCustom requestJson(@RequestBody UserCustom userCustom){
		return userCustom;
	}
	/**
	 * 返回json
	 * @requestBody将请求的json转为对象
	 * @responseBody将响应的对象转为json
	 */
	@RequestMapping("/reposeJson")
	public @ResponseBody UserCustom reposeJson(UserCustom userCustom){
		return userCustom;
	}

}
