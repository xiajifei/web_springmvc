package com.xia.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xia.ssm.mapper.UserMapper;
import com.xia.ssm.po.UserCustom;
import com.xia.ssm.service.UserService;
import com.xia.ssm.vo.UserQueryVo;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) {
		return userMapper.findUserList(userQueryVo);
	}
	
}
