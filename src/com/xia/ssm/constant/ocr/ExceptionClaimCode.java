package com.xia.ssm.constant.ocr;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ExceptionClaimCode {

	/**
	 * 请求成功
	 */
	public static final String QUEST_SUCCESS = "0000";

	/**
	 * 该用户登录名不存在
	 */
	public static final String USERNAME_ERROR = "0001";

	/**
	 * 该用户密码错误
	 */
	public static final String PASSWORD_ERROR = "0002";
	/**
	 * 数据完整性错误
	 */
	public static final String DATA_INTEGRITY_ERROR = "0003";
	/**
	 * JSON包格式错误
	 */
	public static final String JSON_ERROR = "0004";
	/**
	 * 客户不存在
	 */
	public static final String CUSTOMER_NO_EXIST = "0005";
	/**
	 * 
	 */
	public static final String SEND_IBMS_URL = "0006";
	/**
	 * 无施工或质检任务时返回标记
	 */
	public static final String RESPONSE_CONSTRUCTION_QUALITY = "0007";
	public static final String RESPONSE_NO_DETIL = "0008";
	/***
	 * 无权限登录
	 */
	public static final String NO_POWER_ACCESS="0009";
	/**
	 * 询价 暂无完成任务
	 */
	public static final String NO_PRICE_FINISH="0010";
	/***
	 * 暂无需要询价项目
	 */
	public static final String NO_NEED_PRICE="0011";
	/**
	 * 暂无询价单号
	 */
	public static final String NO_GETPRICE_NUMBER="0012";
	/**
	 * 没有定损任务
	 */
	public static final String REQUEST_NO_TASK="0013";
	 /**
	  * 没有定损帐号
	  */
	public static final String NO_GUNSUN_ACCENT="0014";
	/**
	 * 没有询价帐号
	 */
	public static final String NO_SENDPRICE_ACCENT="0015";
	/**
	 * 没有工单信息
	 */
	public static final String NO_WORKSHEET_TASK="0016";
	/**
	 * 新客户 无行驶证图片
	 */
	public static final String IS_NEW_CUSTOMER="0017";
	/**
	 * 文通行驶证识别失败
	 */
	public static final String DRIVERLICENSE_FAILED="0019";
	/**
	 * 文通车牌照识别失败
	 */
	public static final String PLATENO_FAILED="0119";
	/**
	 * 文通身份证识别失败
	 */
	public static final String IDCARD_FAILED="0129";
	/**
	 * 文通驾驶证识别失败
	 */
	public static final String DRIVER_FAILED="0139";
	/**
	 * 文通银行卡识别失败
	 */
	public static final String BANK_FAILED="0149";
	/**
	 * 文通行驶证识别接口，图片传输错误
	 */
	public static final String DRIVERLICENSE_PIC_ERROR="0020";
	/**
	 * 文通车牌识别接口，图片传输错误
	 */
	public static final String DRIVERLICENSE_PLA_ERROR="0120";
	/**
	 * 文通身份证识别接口，图片传输错误
	 */
	public static final String DRIVERLICENSE_IDE_ERROR="0130";
	/**
	 * 文通驾驶证识别接口，图片传输错误
	 */
	public static final String DRIVERLICENSE_DRI_ERROR="0140";
	/**
	 * 文通银行卡识别接口，图片传输错误
	 */
	public static final String DRIVERLICENSE_BANK_ERROR="0150";
	/**
	 * 其它异常错误（如：网络连接或数据库连接出错等）
	 */
	public static final String SERVICE_NO_VALIDATE = "9999";
	/**
	 * OBD异常错误:暂无此数据
	 */
	public static final String NO_OBD_MESSAGE = "0021";
	

	/**
	 * 接口请求类型(用户登录接口01 跳转登录)
	 */
	public static final String REQUEST_SENDTYPE_LOGIN = "01";
	/**
	 * 接口请求类型(查询客户信息接口02)
	 */
	public static final String REQUEST_LOAD_CUSTOMER = "02";
	/**
	 * 接口请求类型(创建接车任务接口03)
	 */
	public static final String REQUEST_CREATE_CARTASK = "03";
	/**
	 * 接口请求类型(用户登录接口04 验证登录)
	 */
	public static final String REQUEST_SENDTYPE_CHECK = "04";
	/**
	 * 接口请求类型(施工/质检)
	 * 施工
	 */
	public static final String REQUEST_SENDTYPE_CONSTRUCTION = "05";
	/**
	 * 接口请求类型(施工/质检)
	 * 质检
	 */
	public static final String REQUEST_SENDTYPE_QUALITY = "06";
	/**
	 * 接口请求类型(施工/质检)
	 * 查看具体任务情况
	 */
	public static final String REQUEST_TASK_XLC= "07";
	
	/**
	 * APP在线获取激活码接口
	 */
	public static final String REQUEST_SENDTYPE_APP_CODE= "23";
	
	/**
	 * APP eror日志回写接口
	 */
	public static final String REQUEST_SENDTYPE_APP_LOG= "24";
	
	/**
	 * APP 地图定位附近修理厂
	 */
	public static final String REQUEST_SENDTYPE_LOCATION= "25";
	
	/**
	 * APP 保险公司/公估公司确认推修
	 */
	public static final String REQUEST_SENDTYPE_PUSH= "26";
	
	/**
	 * APP 任务列表
	 */
	public static final String REQUEST_SENDTYPE_PUSHLIST= "27";
	
	/**
	 * APP 获取二维码
	 */
	public static final String REQUEST_SENDTYPE_TWOCODE= "28";
	/**
	 * 行驶证识别接口
	 */
	public static final String DRIVING_LICENSE= "35";
	/**
	 * 车牌识别接口
	 */
	public static final String LICENSE_PLATE= "36";
	/**
	 * 二代身份证识别接口
	 */
	public static final String IDENTIFY_PLATE= "37";
	/**
	 * 驾驶证识别接口
	 */
	public static final String DRIVER_PLATE= "38";
	/**
	 * 银行卡识别接口
	 */
	public static final String BANK_PLATE= "39";
	/**
	 * 译图银行卡识别接口
	 */
	public static final String BANK_PLATEFORYT= "40";

	/**
	 * 推修环节，确认接车 接口类型 08
	 */
	public static final String PUSH_TASK_TYPE ="08";
	/**
	 * 推修环节，空闲设置 接口类型 09
	 */
	public static final String PUSH_FREE_CONFIG ="09";
	/**
	 * 推修环节，确认结算 接口类型 10
	 */
	public static final String PUSH_PAY_OFF ="10";
	/**
	 * 推修环节，空闲查询 接口类型 11
	 */
	public static final String PUSH_FREE_SEARCH ="11";
	/**
	 * 推修环节，进度查询 接口类型 12
	 */
	public static final String PUSH_PROGRESS_SEARCH  ="12";
	/***
	 * 无该推修任务
	 */
	public static final String NO_PUSH_TASK="0017";
	/**
	 * 暂不需要更新
	 */
	public static final String NO_APK_CHECK="1001";
	/**
	 * 查不到行驶证信息
	 */
	public static final String NO_CUSTOMER_DRIVINGLICENSE="10002";
	//通用接口 类型说明
	/**
	 * 保养数据接口
	 */
	public static final String VEHICLE_MAINTENANCE_INTER="VMI01";
	/***
	 * 车辆定型接口
	 */
	public static final String VEHICLE_STYLING_INTER="VSI01";
	/***
	 * 行驶证识别
	 */
	public static final String DRIVING_LICENSE_IDENTIFICATION="DLI01";
	/**
	 * 行驶证修改信息返回
	 */
	public static final String DRIVING_LICENSE_CHECKED="DLC01";
	/**
	 * 车型确认接口返回
	 */
	public static final String VEHICLE_MODELS_CONFIRM = "VMC01";
	/**
	 * 配件查询接口
	 */
	public static final String VEHICLE_REPAIRE_INTER="VRI01";
	public static final String RESPONSE_VEHICLE_FAILED="FAILED";
	public static final String RESPONSE_VEHICLE_NODATE="NOCARDATA";
	public static final String RESPONSE_STYLING_NODATE="NODATA";
	public static final String RESPONSE_JYDATAWEB_ERROR="ERROE";
	
	public static final String USER_IS_WRONG="2001";
	public static final String NO_DRIVER_COUNT="2002";
	@SuppressWarnings("unchecked")
	public static final Map EXCEPTION_CLAIMCODE_MAP = new HashMap();
	static{
		EXCEPTION_CLAIMCODE_MAP.put(QUEST_SUCCESS, "请求成功");
		EXCEPTION_CLAIMCODE_MAP.put(USERNAME_ERROR, "用户不存在");
		EXCEPTION_CLAIMCODE_MAP.put(PASSWORD_ERROR, "密码错误");
		EXCEPTION_CLAIMCODE_MAP.put(DATA_INTEGRITY_ERROR, "数据完整性错误");
		EXCEPTION_CLAIMCODE_MAP.put(JSON_ERROR, "JSON格式错误");
		EXCEPTION_CLAIMCODE_MAP.put(CUSTOMER_NO_EXIST, "客户不存在");
		EXCEPTION_CLAIMCODE_MAP.put(SEND_IBMS_URL, "验证成功发送登录URL");
		EXCEPTION_CLAIMCODE_MAP.put(SERVICE_NO_VALIDATE, "其它异常错误");
		EXCEPTION_CLAIMCODE_MAP.put(RESPONSE_CONSTRUCTION_QUALITY, "无操作任务");
		EXCEPTION_CLAIMCODE_MAP.put(RESPONSE_NO_DETIL, "暂无修理项目");
		EXCEPTION_CLAIMCODE_MAP.put(NO_NEED_PRICE, "暂无需要询价的项目");
		EXCEPTION_CLAIMCODE_MAP.put(NO_GETPRICE_NUMBER, "暂无询价单号");
		EXCEPTION_CLAIMCODE_MAP.put(REQUEST_NO_TASK, "暂无工单内容");
		EXCEPTION_CLAIMCODE_MAP.put(NO_POWER_ACCESS, "没有权限登录该系统");
		EXCEPTION_CLAIMCODE_MAP.put(NO_PRICE_FINISH, "暂无询价完成任务");
		EXCEPTION_CLAIMCODE_MAP.put(NO_GUNSUN_ACCENT, "没有估损帐号");
		EXCEPTION_CLAIMCODE_MAP.put(NO_WORKSHEET_TASK, "没有工单信息");
		EXCEPTION_CLAIMCODE_MAP.put(NO_PUSH_TASK, "未查到该推修任务或该任务已变更");
		EXCEPTION_CLAIMCODE_MAP.put(NO_APK_CHECK, "暂时不需要更新版本");
		EXCEPTION_CLAIMCODE_MAP.put(NO_CUSTOMER_DRIVINGLICENSE, "查不到行驶证信息");
		EXCEPTION_CLAIMCODE_MAP.put(IS_NEW_CUSTOMER, "新客户没有行驶证信息");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVERLICENSE_FAILED, "行驶证识别失败");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVERLICENSE_PIC_ERROR, "行驶证图片读写错误");
		EXCEPTION_CLAIMCODE_MAP.put(RESPONSE_VEHICLE_FAILED, "信息返回失败");
		EXCEPTION_CLAIMCODE_MAP.put(RESPONSE_VEHICLE_NODATE, "暂无保养信息");
		EXCEPTION_CLAIMCODE_MAP.put(RESPONSE_STYLING_NODATE, "VIN码未正确识别");
		EXCEPTION_CLAIMCODE_MAP.put(RESPONSE_JYDATAWEB_ERROR, "数据服务平台返回信息错误");
		EXCEPTION_CLAIMCODE_MAP.put(USER_IS_WRONG, "用户出错");
		EXCEPTION_CLAIMCODE_MAP.put(NO_DRIVER_COUNT, "剩余查询次数不足");
		EXCEPTION_CLAIMCODE_MAP.put(PLATENO_FAILED, "车牌照识别失败");
		EXCEPTION_CLAIMCODE_MAP.put(IDCARD_FAILED, "身份证识别失败");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVER_FAILED, "驾驶证识别失败");
		EXCEPTION_CLAIMCODE_MAP.put(BANK_FAILED, "银行卡识别失败");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVERLICENSE_PLA_ERROR, "车牌图片读写错误");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVERLICENSE_IDE_ERROR, "身份证图片读写错误");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVERLICENSE_DRI_ERROR, "驾驶证图片读写错误");
		EXCEPTION_CLAIMCODE_MAP.put(DRIVERLICENSE_BANK_ERROR, "银行卡图片读写错误");
		EXCEPTION_CLAIMCODE_MAP.put(NO_OBD_MESSAGE, "暂无此数据");
		
	}
}
