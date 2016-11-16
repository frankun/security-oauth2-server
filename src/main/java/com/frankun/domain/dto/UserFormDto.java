package com.frankun.domain.dto;

import com.frankun.domain.user.Privilege;
import com.frankun.domain.user.User;
import com.frankun.infrastructure.PasswordHandler;

/**
 * 2016/10/25
 *
 * @author frankun
 */
public class UserFormDto extends UserDto {

    private String password;

    public Privilege[] getAllPrivileges(){
        return new Privilege[] {Privilege.MOBILE, Privilege.UNITY};
    }

    public UserFormDto(){
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User newUser(){
        final User user = new User()
                .username(getUsername())
                .phone(getPhone())
                .email(getEmail())
                .password(PasswordHandler.md5(getPassword()));
        user.privileges().addAll(getPrivileges());
        return user;
    }
}
