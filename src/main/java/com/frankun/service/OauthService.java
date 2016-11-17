package com.frankun.service;

import com.frankun.domain.dto.OauthClientDetailsDto;

/**
 * 2016/10/12
 *
 * @author frankun
 */
public interface OauthService {

    OauthClientDetailsDto loadOauthClientDetails(String clientId);

}
