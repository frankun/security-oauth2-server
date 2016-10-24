package com.frankun.domain.user;

import com.frankun.domain.BaseDomain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 2016/10/13
 *
 * 用户实体类
 *
 * @author frankun
 */
public class User extends BaseDomain{

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    //Default user is initial when create database, do not delete
    private boolean defaultUser = false;

    private String email;

    private String phone;

    private Date lastLoginTime;

    private List<Privilege> privileges = new ArrayList<>();

    public User(){
    }

    public User(String username, String password, String email, String phone){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDefaultUser() {
        return defaultUser;
    }

    public void setDefaultUser(boolean defaultUser) {
        this.defaultUser = defaultUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString(){
        final StringBuffer sb =  new StringBuffer();
        sb.append("{username='").append(username).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", guid='").append(guid).append('\'');
        sb.append(", defaultUser='").append(defaultUser).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append("}");
        return sb.toString();
    }
}
