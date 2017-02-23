package com.xia.ssm.constant.ocr;

import java.util.HashMap;
import java.util.Map;

public class ActiveResponseClaimCode {
	/**
	 * 请求成功
	 */
	public static final String QUEST_SUCCESS = "0000";
	/**
	 * 数据完整性错误
	 */
	public static final String DATA_INTEGRITY_ERROR = "0001";
	/**
	 * JSON包格式错误
	 */
	public static final String JSON_ERROR = "0002";
	/**
	 * 设备未被激活
	 */
	public static final String DEVICE_NO_ACTIVE = "0003";
	/**
	 * 该设备已超出有效期
	 */
	public static final String DEVICE_OUT_VALIDITY = "0004";
	/***
	 * 
	 * 设备已激活
	 */
	public static final String DEVICE_IN_ACTIVE = "0005";
	/**
	 * 机构绑定平板数量超出机构维护的平板
	 */
	public static final String DEVICE_OUT_ZZPAD = "0006";
	/**
	 * 机构不存在
	 */
	public static final String ZZ_NO_EXISTS = "0007";
	/**
	 * 距离截止日还有不到10天
	 */
	public static final String TIME_DISTINCE_OUT_ACTIVE = "0008";
	/**
	 * 截止日期出现错误
	 */
	public static final String END_DATE_ERROR = "0009";
	/**
	 * 其它异常错误（如：网络连接或数据库连接出错等）
	 */
	public static final String SERVICE_NO_VALIDATE = "9999";

	/**
	 * 接口请求类型(用户登录接口01 跳转登录)
	 */
	public static final String ACTIVE_DEVICE = "01";
	/**
	 * 接口请求类型(查询客户信息接口02)
	 */
	public static final String VALIDATE_DATE = "02";
	
	public static final Map EXCEPTION_CLAIMCODE_MAP = new HashMap();
	static{
		EXCEPTION_CLAIMCODE_MAP.put(QUEST_SUCCESS, "请求成功");	
		EXCEPTION_CLAIMCODE_MAP.put(DATA_INTEGRITY_ERROR, "数据完整性错误");
		EXCEPTION_CLAIMCODE_MAP.put(JSON_ERROR, "JSON格式错误");
		EXCEPTION_CLAIMCODE_MAP.put(DEVICE_NO_ACTIVE,"设备未激活，请联系管理员");
		EXCEPTION_CLAIMCODE_MAP.put(DEVICE_OUT_VALIDITY,"该设备已超出有效期，请联系管理员续期！");
		EXCEPTION_CLAIMCODE_MAP.put(DEVICE_IN_ACTIVE,"该设备已被激活，无须重复激活！");
		EXCEPTION_CLAIMCODE_MAP.put(ZZ_NO_EXISTS,"机构不存在，请联系管理员！");
		EXCEPTION_CLAIMCODE_MAP.put(END_DATE_ERROR,"截止日期日期出现错误！");
		EXCEPTION_CLAIMCODE_MAP.put(SERVICE_NO_VALIDATE, "其它异常错误");
	
	}
}
