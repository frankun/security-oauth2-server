package com.frankun.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 2016/10/12
 *
 * @author frankun
 */
public interface UserService extends UserDetailsService{

    boolean isUsernameExisted(String username);
}
