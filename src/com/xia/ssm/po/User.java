package com.xia.ssm.po;


public class User {
	
	private String id;
	//校验名字
	//@Size(min=1,max=32,message="{user.name.length.errow}")
	private String name;
	//@Null(message="{user.orderid.isNull}")
	private String orderid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	

}
