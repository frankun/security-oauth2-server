package com.frankun.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016/11/21
 * @author frankun
 */
public class UserOverviewDto {

    private String username;

    private List<UserDto> userDtos = new ArrayList<>();

    public UserOverviewDto(){

    }

    public int getSize(){
        return userDtos.size();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }
}
