package com.frankun.dao;

import com.frankun.dao.base.BaseMapper;
import com.frankun.domain.oauth.OauthClientDetails;

import java.util.List;

/**
 * 2016/11/18
 * @author frankun
 */
public interface OauthMapper extends BaseMapper{

    List<OauthClientDetails> findAllClientDetails();

    void saveOauthClientDetails(OauthClientDetails oauthClientDetails);
}
