package com.frankun.web.validator;

import com.frankun.domain.dto.OauthClientDetailsDto;
import com.frankun.service.OauthService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 2016/11/17
 * @author frankun
 */

@Component
public class OauthClientDetailsDtoValidator implements Validator {

    @Autowired
    private OauthService oauthService;

    @Override
    public boolean supports(Class<?> clazz) {
        return OauthClientDetailsDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OauthClientDetailsDto oauthClientDetailsDto = (OauthClientDetailsDto) target;

        validateClientId(oauthClientDetailsDto, errors);
        validateClientSecret(oauthClientDetailsDto, errors);

        validateGrantTypes(oauthClientDetailsDto, errors);
    }

    public void validateClientId(OauthClientDetailsDto oauthClientDetailsDto, Errors errors){
        final String clientId = oauthClientDetailsDto.getClientId();
        if (StringUtils.isBlank(clientId)){
            errors.rejectValue("clientId", null, "client_id is required");
            return;
        }
        if (clientId.length() < 5){
            errors.rejectValue("clientId", null, "client_id 长度至少5位");
            return;
        }
        OauthClientDetailsDto dto = oauthService.loadOauthClientDetailsDto(clientId);
        if (dto != null){
            errors.rejectValue("clientId", null, "client_id [" + clientId + "] 已存在");
        }
    }

    public void validateClientSecret(OauthClientDetailsDto oauthClientDetailsDto, Errors errors){
        final String clientSecret = oauthClientDetailsDto.getClientSecret();
        if (StringUtils.isEmpty(clientSecret)){
            errors.rejectValue("clientSecret", null, "client_secret is required");
            return;
        }
        if (clientSecret.length() < 8){
            errors.rejectValue("clientSecret", null, "client_secret 长度至少8位");
        }
    }

    public void validateGrantTypes(OauthClientDetailsDto oauthClientDetailsDto, Errors errors){
        final String grantTypes = oauthClientDetailsDto.getAuthorizedGrantTypes();
        if (StringUtils.isEmpty(grantTypes)) {
            errors.rejectValue("authorizedGrantTypes", null, "grant_type(s) is required");
            return;
        }
        if ("refresh_token".equalsIgnoreCase(grantTypes)) {
            errors.rejectValue("authorizedGrantTypes", null, "grant_type(s) 不能只是[refresh_token]");
        }
    }
}
