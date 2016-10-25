package com.frankun.service.impl;

import com.frankun.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 2016/10/12
 *
 * @author frankun
 */

@Service("userService")
public class UserServiceImpl implements UserService{

    public boolean isUsernameExisted(String username){
        return false;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
