package com.xia.ssm.po;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Null;



public class User {
	
	private String id;
	//校验名字
//	@Size(min=1,max=32,message="{user.name.length.errow}")
	@Null(message="{user.name.isNull}")
	private String name;
	
	@Null(message="{user.orderid.isNull}")
	private String orderid;
	
	private Date createdate;
	
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
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", orderid=" + orderid
				+ ", createdate=" + createdate + "]";
	}
	
	

}
