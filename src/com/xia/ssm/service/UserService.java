package com.xia.ssm.service;

import java.util.List;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.vo.UserQueryVo;

public interface UserService {
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);

}
