package com.frankun.service;

import com.frankun.domain.dto.UserOverviewDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 2016/10/12
 *
 * @author frankun
 */
public interface UserService extends UserDetailsService{

    boolean isUsernameExisted(String username);

    UserOverviewDto loadUserOverviewDto(UserOverviewDto overviewDto);
}
