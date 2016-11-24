package com.frankun.service.impl;

import com.frankun.dao.UserMapper;
import com.frankun.domain.dto.UserDto;
import com.frankun.domain.dto.UserOverviewDto;
import com.frankun.domain.security.myUserDetails;
import com.frankun.domain.user.User;
import com.frankun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2016/10/12
 *
 * @author frankun
 */

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public boolean isUsernameExisted(String username){
        return false;
    }

    @Override
    public UserOverviewDto loadUserOverviewDto(UserOverviewDto overviewDto) {
        List<User> users = userMapper.searchUserByUsername(overviewDto.getUsername());
        overviewDto.setUserDtos(UserDto.toDtos(users));
        return overviewDto;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null || user.isArchived()){
            throw new UsernameNotFoundException("Not found user for this username [" + username + "]");
        }
        return new myUserDetails(user);
    }
}
