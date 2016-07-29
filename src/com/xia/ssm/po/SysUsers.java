package com.xia.ssm.po;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "sys_users")
public class SysUsers implements UserDetails, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6976596648726947488L;
    
 // Fields  
    
    private String userId;  
    private String username;  
    private String name;  
    private String password;  
    private Date dtCreate;  
    private Date lastLogin;  
    private Date deadline;  
    private String loginIp;  
    private String VQzjgid;  
    private String VQzjgmc;  
    private String depId;  
    private String depName;  
    private boolean enabled;  
    private boolean accountNonExpired;  
    private boolean accountNonLocked;  
    private boolean credentialsNonExpired; 
    
    
    
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getVQzjgid() {
        return VQzjgid;
    }

    public void setVQzjgid(String vQzjgid) {
        VQzjgid = vQzjgid;
    }

    public String getVQzjgmc() {
        return VQzjgmc;
    }

    public void setVQzjgmc(String vQzjgmc) {
        VQzjgmc = vQzjgmc;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

}
