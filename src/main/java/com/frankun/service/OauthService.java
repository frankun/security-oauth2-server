package com.frankun.service;

import com.frankun.domain.dto.OauthClientDetailsDto;
import com.frankun.domain.oauth.OauthClientDetails;

import java.util.List;

/**
 * 2016/10/12
 *
 * @author frankun
 */
public interface OauthService {

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    List<OauthClientDetailsDto> loadOauthClientDetailsDtos();

    OauthClientDetails loadOauthClientDetails(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);

    void updateOauthClientDetailsArchive(String clientId);
}
