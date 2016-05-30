package com.xia.ssm.service;

import java.util.List;

import com.xia.ssm.po.UserCustom;
import com.xia.ssm.vo.UserQueryVo;

public interface UserService {
	/**
	 * 根据多条件查询
	 * @param userQueryVo
	 * @return
	 */
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public UserCustom findUserById(String id);
	/**
	 * 插入用户
	 * @param userCustom
	 */
	public void insertUser(UserCustom userCustom);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteUserById(String id);

}
