package com.frankun.service.impl;

import com.frankun.dao.OauthMapper;
import com.frankun.domain.dto.OauthClientDetailsDto;
import com.frankun.domain.oauth.OauthClientDetails;
import com.frankun.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2016/10/12
 *
 * @author frankun
 */

@Service("oauthService")
public class OauthServiceImpl implements OauthService{

    @Autowired
    private OauthMapper oauthMapper;

    @Override
    public OauthClientDetailsDto loadOauthClientDetailsDto(String clientId) {
        final OauthClientDetails oauthClientDetails = oauthMapper.findClientDetails(clientId);
        return oauthClientDetails != null ? new OauthClientDetailsDto(oauthClientDetails) : null;
    }

    @Override
    public List<OauthClientDetailsDto> loadOauthClientDetailsDtos() {
        List<OauthClientDetails> oauthClientDetailses = oauthMapper.findAllClientDetails();
        return OauthClientDetailsDto.toDtos(oauthClientDetailses);
    }

    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) {
        return null;
    }

    @Override
    public void registerClientDetails(OauthClientDetailsDto formDto) {
        OauthClientDetails oauthClientDetails = formDto.createDomain();
        oauthMapper.saveOauthClientDetails(oauthClientDetails);
    }
}
