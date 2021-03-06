package com.frankun.dao;

import com.frankun.dao.base.BaseMapper;
import com.frankun.domain.oauth.OauthClientDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2016/11/18
 * @author frankun
 */
public interface OauthMapper extends BaseMapper{

    OauthClientDetails findClientDetails(String clientId);

    List<OauthClientDetails> findAllClientDetails();

    void saveOauthClientDetails(OauthClientDetails oauthClientDetails);

    void updateOauthClientDetailsArchive(@Param("clientId") String clientId, @Param("archived") boolean archived);
}
