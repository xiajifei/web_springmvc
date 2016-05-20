package com.xia.ssm.mapper;

import java.util.List;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.vo.UserQueryVo;

public interface UserMapper {
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);
	

}
