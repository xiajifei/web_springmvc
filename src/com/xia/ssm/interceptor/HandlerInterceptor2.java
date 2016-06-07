package com.xia.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor{

	/**
	 * 执行handler之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("HandlerInterceptor2----preHandle");
		return true;
	}

	/**
	 * 执行handler之后，modelAndView之前
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("HandlerInterceptor2-----postHandle");
	}

	/**
	 * 执行handler之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
		System.out.println("HandlerInterceptor2----afterCompletion");
	}

}
