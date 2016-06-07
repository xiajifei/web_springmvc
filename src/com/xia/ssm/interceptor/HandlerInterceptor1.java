package com.xia.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author summer
 *preHandle顺序执行
 *postHandle/afterCompletion逆序执行
 *只要有一个pre为false,所有的post都不执行
 *
 */

public class HandlerInterceptor1 implements HandlerInterceptor{

	/**
	 * 执行handler之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("HandlerInterceptor1----preHandle");
		return true;
	}

	/**
	 * 执行handler之后，modelAndView之前
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("HandlerInterceptor1-----postHandle");
	}

	/**
	 * 执行handler之后
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
		System.out.println("HandlerInterceptor1----afterCompletion");
	}

	/**
	 * 1.统一日志处理，放在第一个拦截器位置，pre应该方形
	 * 2.登录认证拦截器，放在第一个位置；权限校验拦截器，放在登录拦截器之后；
	 */
}
