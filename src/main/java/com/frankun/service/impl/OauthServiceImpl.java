package com.frankun.service.impl;

import com.frankun.domain.oauth.OauthClientDetails;
import com.frankun.service.OauthService;
import org.springframework.stereotype.Service;

/**
 * 2016/10/12
 *
 * @author frankun
 */

@Service("oauthService")
public class OauthServiceImpl implements OauthService{

    public OauthClientDetails loadOauthClientDetails(String clientId) {
        return null;
    }
}
