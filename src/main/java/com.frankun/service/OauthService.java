package com.frankun.service;

import com.frankun.domain.oauth.OauthClientDetails;

/**
 * 2016/10/12
 *
 * @author frankun
 */
public interface OauthService {
    OauthClientDetails loadOauthClientDetails(String clientId);
}
