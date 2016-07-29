package com.xia.ssm.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.GrantedAuthority;

import com.xia.ssm.po.SysUsers;
import com.xia.ssm.po.UserCustom;
import com.xia.ssm.vo.UserQueryVo;

public interface SysUserMapper {
	
    public SysUsers getByUsername(String username);  
    
    public Collection<GrantedAuthority> loadUserAuthorities(String username);  
	

}
