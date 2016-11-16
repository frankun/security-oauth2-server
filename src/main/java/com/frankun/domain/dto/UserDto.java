package com.frankun.domain.dto;

import com.frankun.domain.user.Privilege;
import com.frankun.domain.user.User;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 2016/10/25
 *
 * @author frankun
 */
public class UserDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private String guid;

    private String username;

    private String phone;
    private String email;

    private String createTime;

    private List<Privilege> privileges = new ArrayList<Privilege>();

    public UserDto(){
    }

    public UserDto(User user){
        this.guid = user.getGuid();
        this.username = user.username();
        this.phone = user.phone();
        this.email = user.email();
        this.privileges = user.privileges();
        this.createTime = user.getCreateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public static List<UserDto> toDtos(List<User> users){
        List<UserDto> dtos = new ArrayList<UserDto>(users.size());
        for (User user : users){
            dtos.add(new UserDto(user));
        }
        return dtos;
    }
}
