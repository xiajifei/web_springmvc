package com.xia.ssm.vo.ocr;

import java.util.List;


public class ClaimPhoneDTO {

	private String userName;
	private String password;
	private String sendType;
	private String responseCode;
	private String responseMessage;
	private String requestMessage;
	private String operateType;
	private String plateNo;
	private String plateNoPicture;//车牌图片地址
	private String consumeTime;//消耗时间
	private String wtAddrUrl;//文通地址
	private String status;//状态
	private String vin;
	private String contactPerson;
	private String telephone;
	private String sex;
	private String remark;
	private String engineNo;
	private String customerName;
	private String registerDate;
	private String vehicleModels;
	private String useType;
	private String zzid;
	private String inRepairTime;
	private String outRepairTime;
	private String inRepairMile;
	private String inRepairMilePicture;//里程图片地址
	private String inRepairOil;
	private String insComnameCode;
	private String customercarEndDate;
	private String reportNo;
	private String damageNum;
	private String damageLevel;
	private String repairType;
	private String damageAreas;//损坏部位
	private String damagePicture;//损坏部位图片地址
	//private JSONArray damageConditionList;//损坏部位集合
	private String appPath;
	private String dlUrl;
	private String workSheetId;//工单主键ID
	private String projectId;//具体项目（目前工时项目）
	private String photoType;//开工检查完工等照片
	private String photoNames;//部位照片名称，可以多张 用分号隔开
	private String startTime;//开工时间
	private String endTime;//完工时间
	private String checkTime;
	//sqlServer 
	private String VehicleCode;
	private String VehicleName;
	private String FamilyName;
	private String BrandName;
	private String purchasePrice;
	private String workNumber; //作业单号
	private String damageCata;
	private String jyXjdh;
	private String type;
	private String evalinfoid;
	private String dlm;
	private String yhid;
	private String jsxx;
	//VIN码服务字段
	private String brandCode;
	private String familyCode;
	private String BrandId;
	private String xjname;
	private String xjpassword;
	//字典表字段
	private String zdmc;
	private String id;
	private String zdbm;
	private String fzzzdmc;
	private String fzzid;
	//新加字段 行驶证
	private String drivingLicense;
	//新加list 
	//private JSONArray otherPicList;
	//private JSONArray vehicleAccessoriesList;
	//接车人
	private String sendCarPerson;
	private String FaultDescription;
	private String modelYear;
	private String evalPerson;
	private Integer sonOrder;
	private Integer fatherOrder;
	private String isRequired;
	//推修 任务相关字段
	private List   taskList;
	private String state;
	private String taskId;
	private String progress;
	private String idleWorkStation;
	private String workStation;
	private String taskStatus;
	//行驶证相关
	private String address;//地址
	private String vehicleType;//车辆使用类型
	private String issueDate;//发证日期
	private String deviceID;
	private String key;
	private String takePicCount;
	//private JSONObject driverLicenseInfo; 
	private String Data;
	private List fitsList;
	private List repairList;
	private List assistList;
	private String bah;
	private String gsdh;
	private String zdybz;
	private String xjstate;
    private Double sumfitsfee;
    private Double sumrepairfee;
    private Double summaterialfee;
    private Double sumlossfee;
    private String ppmc;
    private String cximc;
    private String czmc;
    private String cxid;
    private String cxmc;
    private List laborList;
    private List materList;
    
    private String startrecording;
	private String dailycheck;
	private String completioninspection;
	private String qualityinspection;
	/** 客户签字图片名称  */
	private String customerSignPicture;
	private String yearPattern;
	/**推修任务接口使用*/
	private String requestType;
	private String requestZzbh;
	/**推修任务工单号*/
	private String pushtaskNo;
	/**APP更新用*/
	//版本号
	private String versionNo;
	private String versionType;
	//分也用
	private String pageNo;
	private String pageSize;
	private String member;
	private String vehiclePrice;
	private String geatboxType;
	private String displacement;
	private String engineDesc;
	private String companyName;
	private String companyAbbr;
	private String engineModel;
	//obd故障码
	private String failCode;
	private String applyCar;
	private String failCodeZn;
	private String failCodeEn;
	private String category;
	private String knowLedge;
	private String disabled;
	
	//线上标记  0 线下  1线上环境 
	private String onlineFlag;
	private String secondId;
	private String repairId;
	private String xlcZzbh;
	
	//车牌行驶证团片名称
	private String plateImg;
	//行驶证
	private String licenseImg;
	//身份证
	private String idCardImg;
	//驾驶证
	private String driverImg;
	//银行卡
	private String bankImg;
	
	//身份证相关字段  userName、sex、nation、birthday、address、idCardNo、idCardImg
	//名族
	private String nation;
	//出生日期
	private String birthday;
	//身份证号
	private String idCardNo;
	//头像
	private String idCardPhoto;
	
	
	//驾驶证相关字段 userName、sex、address、birthday、registerTime、drivingType、startTime、limitTime、endTime
	private String cardNo;
	//初始领证日期
	private String registerTime;
	//准驾车型
	private String drivingType;
	//有效期限
	private String limitTime;
	

	
	public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getIdCardPhoto() {
        return idCardPhoto;
    }

    public void setIdCardPhoto(String idCardPhoto) {
        this.idCardPhoto = idCardPhoto;
    }


    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getDrivingType() {
        return drivingType;
    }

    public void setDrivingType(String drivingType) {
        this.drivingType = drivingType;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg;
    }

    public String getDriverImg() {
        return driverImg;
    }

    public void setDriverImg(String driverImg) {
        this.driverImg = driverImg;
    }

    public String getBankImg() {
        return bankImg;
    }

    public void setBankImg(String bankImg) {
        this.bankImg = bankImg;
    }

    public String getLicenseImg() {
		return licenseImg;
	}

	public void setLicenseImg(String licenseImg) {
		this.licenseImg = licenseImg;
	}

	public String getPlateImg() {
		return plateImg;
	}

	public void setPlateImg(String plateImg) {
		this.plateImg = plateImg;
	}

	public String getXlcZzbh() {
		return xlcZzbh;
	}

	public void setXlcZzbh(String xlcZzbh) {
		this.xlcZzbh = xlcZzbh;
	}

	
	
	public String getFailCode() {
		return failCode;
	}

	public void setFailCode(String failCode) {
		this.failCode = failCode;
	}

	public String getApplyCar() {
		return applyCar;
	}

	public void setApplyCar(String applyCar) {
		this.applyCar = applyCar;
	}

	public String getFailCodeZn() {
		return failCodeZn;
	}

	public void setFailCodeZn(String failCodeZn) {
		this.failCodeZn = failCodeZn;
	}

	public String getFailCodeEn() {
		return failCodeEn;
	}

	public void setFailCodeEn(String failCodeEn) {
		this.failCodeEn = failCodeEn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKnowLedge() {
		return knowLedge;
	}

	public void setKnowLedge(String knowLedge) {
		this.knowLedge = knowLedge;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getRepairId() {
		return repairId;
	}

	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}

	public String getSecondId() {
		return secondId;
	}

	public void setSecondId(String secondId) {
		this.secondId = secondId;
	}

	public String getOnlineFlag() {
		return onlineFlag;
	}

	public void setOnlineFlag(String onlineFlag) {
		this.onlineFlag = onlineFlag;
	}
	
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	private String firstFlag;
	public String getFirstFlag() {
		return firstFlag;
	}
	public void setFirstFlag(String firstFlag) {
		this.firstFlag = firstFlag;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getVersionType() {
		return versionType;
	}
	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	/** 信鸽注册token */
	private String token;
	/** 设备标识：1：安卓 ，2：ios */
	private String systemFlag;
	/** 【设备信息】OCR扫描软件：（1，云脉；） */
	private String OCRType;
	/** 行驶证图片大小 */
	private String drivingPicSize;
	/** 扫描时间 */
	private String takePicTimes;
	/** 组织编号 */
	private String zzbh;
	
	/**图片验证类型*/
	private String picType;
	public String getZzbh() {
		return zzbh;
	}
	public void setZzbh(String zzbh) {
		this.zzbh = zzbh;
	}
	public String getTakePicTimes() {
		return takePicTimes;
	}
	public void setTakePicTimes(String takePicTimes) {
		this.takePicTimes = takePicTimes;
	}
	public String getDrivingPicSize() {
		return drivingPicSize;
	}
	public void setDrivingPicSize(String drivingPicSize) {
		this.drivingPicSize = drivingPicSize;
	}
	public String getOCRType() {
		return OCRType;
	}
	public void setOCRType(String oCRType) {
		OCRType = oCRType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSystemFlag() {
		return systemFlag;
	}
	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}
	public String getPushtaskNo() {
		return pushtaskNo;
	}
	public void setPushtaskNo(String pushtaskNo) {
		this.pushtaskNo = pushtaskNo;
	}
	public String getYearPattern() {
		return yearPattern;
	}
	public void setYearPattern(String yearPattern) {
		this.yearPattern = yearPattern;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTakePicCount() {
		return takePicCount;
	}
	public void setTakePicCount(String takePicCount) {
		this.takePicCount = takePicCount;
	}
//	public JSONObject getDriverLicenseInfo() {
//		return driverLicenseInfo;
//	}
//	public void setDriverLicenseInfo(JSONObject driverLicenseInfo) {
//		this.driverLicenseInfo = driverLicenseInfo;
//	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public List getFitsList() {
		return fitsList;
	}
	public void setFitsList(List fitsList) {
		this.fitsList = fitsList;
	}
	public List getRepairList() {
		return repairList;
	}
	public void setRepairList(List repairList) {
		this.repairList = repairList;
	}
	public List getAssistList() {
		return assistList;
	}
	public void setAssistList(List assistList) {
		this.assistList = assistList;
	}
	public String getBah() {
		return bah;
	}
	public void setBah(String bah) {
		this.bah = bah;
	}
	public String getGsdh() {
		return gsdh;
	}
	public void setGsdh(String gsdh) {
		this.gsdh = gsdh;
	}
	public String getZdybz() {
		return zdybz;
	}
	public void setZdybz(String zdybz) {
		this.zdybz = zdybz;
	}
	public String getXjstate() {
		return xjstate;
	}
	public void setXjstate(String xjstate) {
		this.xjstate = xjstate;
	}
	public Double getSumfitsfee() {
		return sumfitsfee;
	}
	public void setSumfitsfee(Double sumfitsfee) {
		this.sumfitsfee = sumfitsfee;
	}
	public Double getSumrepairfee() {
		return sumrepairfee;
	}
	public void setSumrepairfee(Double sumrepairfee) {
		this.sumrepairfee = sumrepairfee;
	}
	public Double getSummaterialfee() {
		return summaterialfee;
	}
	public void setSummaterialfee(Double summaterialfee) {
		this.summaterialfee = summaterialfee;
	}
	public Double getSumlossfee() {
		return sumlossfee;
	}
	public void setSumlossfee(Double sumlossfee) {
		this.sumlossfee = sumlossfee;
	}
	public String getPpmc() {
		return ppmc;
	}
	public void setPpmc(String ppmc) {
		this.ppmc = ppmc;
	}
	public String getCximc() {
		return cximc;
	}
	public void setCximc(String cximc) {
		this.cximc = cximc;
	}
	public String getCzmc() {
		return czmc;
	}
	public void setCzmc(String czmc) {
		this.czmc = czmc;
	}
	public String getCxid() {
		return cxid;
	}
	public void setCxid(String cxid) {
		this.cxid = cxid;
	}
	public String getCxmc() {
		return cxmc;
	}
	public void setCxmc(String cxmc) {
		this.cxmc = cxmc;
	}
	public List getLaborList() {
		return laborList;
	}
	public void setLaborList(List laborList) {
		this.laborList = laborList;
	}
	public List getMaterList() {
		return materList;
	}
	public void setMaterList(List materList) {
		this.materList = materList;
	}
	public String getStartrecording() {
		return startrecording;
	}
	public void setStartrecording(String startrecording) {
		this.startrecording = startrecording;
	}
	public String getDailycheck() {
		return dailycheck;
	}
	public void setDailycheck(String dailycheck) {
		this.dailycheck = dailycheck;
	}
	public String getCompletioninspection() {
		return completioninspection;
	}
	public void setCompletioninspection(String completioninspection) {
		this.completioninspection = completioninspection;
	}
	public String getQualityinspection() {
		return qualityinspection;
	}
	public void setQualityinspection(String qualityinspection) {
		this.qualityinspection = qualityinspection;
	}
	public String getCustomerSignPicture() {
		return customerSignPicture;
	}
	public void setCustomerSignPicture(String customerSignPicture) {
		this.customerSignPicture = customerSignPicture;
	}
	public List getTaskList() {
		return taskList;
	}
	public void setTaskList(List taskList) {
		this.taskList = taskList;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getIdleWorkStation() {
		return idleWorkStation;
	}
	public void setIdleWorkStation(String idleWorkStation) {
		this.idleWorkStation = idleWorkStation;
	}
	public String getWorkStation() {
		return workStation;
	}
	public void setWorkStation(String workStation) {
		this.workStation = workStation;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
	public Integer getSonOrder() {
		return sonOrder;
	}
	public void setSonOrder(Integer sonOrder) {
		this.sonOrder = sonOrder;
	}
	public Integer getFatherOrder() {
		return fatherOrder;
	}
	public void setFatherOrder(Integer fatherOrder) {
		this.fatherOrder = fatherOrder;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getEvalPerson() {
		return evalPerson;
	}
	public void setEvalPerson(String evalPerson) {
		this.evalPerson = evalPerson;
	}
	public String getFaultDescription() {
		return FaultDescription;
	}
	public void setFaultDescription(String faultDescription) {
		FaultDescription = faultDescription;
	}
	public String getSendCarPerson() {
		return sendCarPerson;
	}
	public void setSendCarPerson(String sendCarPerson) {
		this.sendCarPerson = sendCarPerson;
	}
//	public JSONArray getVehicleAccessoriesList() {
//		return vehicleAccessoriesList;
//	}
//	public void setVehicleAccessoriesList(JSONArray vehicleAccessoriesList) {
//		this.vehicleAccessoriesList = vehicleAccessoriesList;
//	}
//	public JSONArray getOtherPicList() {
//		return otherPicList;
//	}
//	public void setOtherPicList(JSONArray otherPicList) {
//		this.otherPicList = otherPicList;
//	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
    //维修类别
    private String repairCategory;
    //维修性质
    private String repairNature;
    //客户类型 
    private String customerTypes;
    //业务员
    private String businessMan;
    //送车单位
    private String sendCar;
    //随车附件
    private String vehicleAccessories;
    //保险公司
    private String insuranceCompany;
    //事故性质
    private String accidentNature;
    //事故责任
    private String accidentResponsibility;
    //车身颜色
    private String bodyColor;
	public String getRepairCategory() {
		return repairCategory;
	}
	public void setRepairCategory(String repairCategory) {
		this.repairCategory = repairCategory;
	}
	public String getRepairNature() {
		return repairNature;
	}
	public void setRepairNature(String repairNature) {
		this.repairNature = repairNature;
	}
	public String getCustomerTypes() {
		return customerTypes;
	}
	public void setCustomerTypes(String customerTypes) {
		this.customerTypes = customerTypes;
	}
	public String getBusinessMan() {
		return businessMan;
	}
	public void setBusinessMan(String businessMan) {
		this.businessMan = businessMan;
	}
	public String getSendCar() {
		return sendCar;
	}
	public void setSendCar(String sendCar) {
		this.sendCar = sendCar;
	}
	public String getVehicleAccessories() {
		return vehicleAccessories;
	}
	public void setVehicleAccessories(String vehicleAccessories) {
		this.vehicleAccessories = vehicleAccessories;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getAccidentNature() {
		return accidentNature;
	}
	public void setAccidentNature(String accidentNature) {
		this.accidentNature = accidentNature;
	}
	public String getAccidentResponsibility() {
		return accidentResponsibility;
	}
	public void setAccidentResponsibility(String accidentResponsibility) {
		this.accidentResponsibility = accidentResponsibility;
	}
	public String getBodyColor() {
		return bodyColor;
	}
	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}
	public String getXjname() {
		return xjname;
	}
	public void setXjname(String xjname) {
		this.xjname = xjname;
	}
	public String getXjpassword() {
		return xjpassword;
	}
	public void setXjpassword(String xjpassword) {
		this.xjpassword = xjpassword;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getFamilyCode() {
		return familyCode;
	}
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
	public String getBrandId() {
		return BrandId;
	}
	public void setBrandId(String brandId) {
		BrandId = brandId;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getDlm() {
		return dlm;
	}
	public void setDlm(String dlm) {
		this.dlm = dlm;
	}
	public String getEvalinfoid() {
		return evalinfoid;
	}
	public void setEvalinfoid(String evalinfoid) {
		this.evalinfoid = evalinfoid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getJyXjdh() {
		return jyXjdh;
	}
	public void setJyXjdh(String jyXjdh) {
		this.jyXjdh = jyXjdh;
	}
	public String getWorkNumber() {
		return workNumber;
	}
	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}
	public String getPlateNoPicture() {
		return plateNoPicture;
	}
	public void setPlateNoPicture(String plateNoPicture) {
		this.plateNoPicture = plateNoPicture;
	}
	public String getInRepairMilePicture() {
		return inRepairMilePicture;
	}
	public void setInRepairMilePicture(String inRepairMilePicture) {
		this.inRepairMilePicture = inRepairMilePicture;
	}
	public String getDamageAreas() {
		return damageAreas;
	}
	public void setDamageAreas(String damageAreas) {
		this.damageAreas = damageAreas;
	}
	public String getDamagePicture() {
		return damagePicture;
	}
	public void setDamagePicture(String damagePicture) {
		this.damagePicture = damagePicture;
	}
//	public JSONArray getDamageConditionList() {
//		return damageConditionList;
//	}
//	public void setDamageConditionList(JSONArray damageConditionList) {
//		this.damageConditionList = damageConditionList;
//	}
	public String getZzid() {
		return zzid;
	}
	public void setZzid(String zzid) {
		this.zzid = zzid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getRequestMessage() {
		return requestMessage;
	}
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getVehicleModels() {
		return vehicleModels;
	}
	public void setVehicleModels(String vehicleModels) {
		this.vehicleModels = vehicleModels;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getInRepairTime() {
		return inRepairTime;
	}
	public void setInRepairTime(String inRepairTime) {
		this.inRepairTime = inRepairTime;
	}
	public String getOutRepairTime() {
		return outRepairTime;
	}
	public void setOutRepairTime(String outRepairTime) {
		this.outRepairTime = outRepairTime;
	}
	public String getInRepairMile() {
		return inRepairMile;
	}
	public void setInRepairMile(String inRepairMile) {
		this.inRepairMile = inRepairMile;
	}
	public String getInRepairOil() {
		return inRepairOil;
	}
	public void setInRepairOil(String inRepairOil) {
		this.inRepairOil = inRepairOil;
	}
	public String getInsComnameCode() {
		return insComnameCode;
	}
	public void setInsComnameCode(String insComnameCode) {
		this.insComnameCode = insComnameCode;
	}
	public String getCustomercarEndDate() {
		return customercarEndDate;
	}
	public void setCustomercarEndDate(String customercarEndDate) {
		this.customercarEndDate = customercarEndDate;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getDamageNum() {
		return damageNum;
	}
	public void setDamageNum(String damageNum) {
		this.damageNum = damageNum;
	}
	public String getDamageLevel() {
		return damageLevel;
	}
	public void setDamageLevel(String damageLevel) {
		this.damageLevel = damageLevel;
	}
	public String getRepairType() {
		return repairType;
	}
	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}
	public String getAppPath() {
		return appPath;
	}
	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}
	public String getDlUrl() {
		return dlUrl;
	}
	public void setDlUrl(String dlUrl) {
		this.dlUrl = dlUrl;
	}
	public String getVehicleCode() {
		return VehicleCode;
	}
	public void setVehicleCode(String vehicleCode) {
		VehicleCode = vehicleCode;
	}
	public String getVehicleName() {
		return VehicleName;
	}
	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	public String getDamageCata() {
		return damageCata;
	}
	public void setDamageCata(String damageCata) {
		this.damageCata = damageCata;
	}
	public String getWorkSheetId() {
		return workSheetId;
	}
	public void setWorkSheetId(String workSheetId) {
		this.workSheetId = workSheetId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getPhotoNames() {
		return photoNames;
	}
	public void setPhotoNames(String photoNames) {
		this.photoNames = photoNames;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getJsxx() {
		return jsxx;
	}
	public void setJsxx(String jsxx) {
		this.jsxx = jsxx;
	}
	public String getZdmc() {
		return zdmc;
	}
	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFzzzdmc() {
		return fzzzdmc;
	}
	public void setFzzzdmc(String fzzzdmc) {
		this.fzzzdmc = fzzzdmc;
	}
	public String getFzzid() {
		return fzzid;
	}
	public void setFzzid(String fzzid) {
		this.fzzid = fzzid;
	}
	public String getZdbm() {
		return zdbm;
	}
	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestZzbh() {
		return requestZzbh;
	}
	public void setRequestZzbh(String requestZzbh) {
		this.requestZzbh = requestZzbh;
	}

	public String getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(String vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public String getGeatboxType() {
		return geatboxType;
	}

	public void setGeatboxType(String geatboxType) {
		this.geatboxType = geatboxType;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getEngineDesc() {
		return engineDesc;
	}

	public void setEngineDesc(String engineDesc) {
		this.engineDesc = engineDesc;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAbbr() {
		return companyAbbr;
	}

	public void setCompanyAbbr(String companyAbbr) {
		this.companyAbbr = companyAbbr;
	}

	public String getEngineModel() {
		return engineModel;
	}

	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}

	public String getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

	public String getWtAddrUrl() {
		return wtAddrUrl;
	}

	public void setWtAddrUrl(String wtAddrUrl) {
		this.wtAddrUrl = wtAddrUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
