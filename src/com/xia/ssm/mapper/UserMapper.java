package com.xia.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.vo.UserQueryVo;

public interface UserMapper {
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);
	
	public UserCustom findUserById(String id);
	
	public void insertUser(UserCustom userCustom);
	
	public void deleteUserById(String id);
	

}
