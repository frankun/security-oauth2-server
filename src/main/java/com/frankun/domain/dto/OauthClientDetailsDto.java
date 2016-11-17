package com.frankun.domain.dto;

import com.frankun.domain.oauth.OauthClientDetails;
import com.frankun.infrastructure.GuidGenerator;
import com.frankun.infrastructure.utils.DateUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 2016/10/12
 * @author frankun
 */
public class OauthClientDetailsDto implements Serializable{

	private static final long serialVersionUID = -822651119753956222L;
	
	private String createTime;
    private boolean archived;

    private String clientId = GuidGenerator.generate();
    private String resourceIds;

    private String clientSecret = GuidGenerator.generateClientSecret();

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    // optional
    private String additionalInformation;

    private boolean trusted;

    public OauthClientDetailsDto(){

    }

    public OauthClientDetailsDto(OauthClientDetails oauthClientDetails){
        this.clientId = oauthClientDetails.clientId();
        this.clientSecret = oauthClientDetails.clientSecret();
        this.scope = oauthClientDetails.scope();

        this.createTime = DateUtils.toDateTime(oauthClientDetails.createTime());
        this.archived = oauthClientDetails.archived();
        this.resourceIds = oauthClientDetails.resourceIds();

        this.webServerRedirectUri = oauthClientDetails.webServerRedirectUri();
        this.authorities = oauthClientDetails.authorities();
        this.accessTokenValidity = oauthClientDetails.accessTokenValidity();

        this.refreshTokenValidity = oauthClientDetails.refreshTokenValidity();
        this.additionalInformation = oauthClientDetails.additionalInformation();
        this.trusted = oauthClientDetails.trusted();

        this.authorizedGrantTypes = oauthClientDetails.authorizedGrantTypes();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public String getScopeWithBlank(){
        if (scope != null && scope.contains(",")){
            return scope.replaceAll(",", " ");
        }
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public static List<OauthClientDetailsDto> toDtos(List<OauthClientDetails> oauthClientDetailses){
        List<OauthClientDetailsDto> dtos = new ArrayList<>(oauthClientDetailses.size());
        for (OauthClientDetails oauthClientDetails : oauthClientDetailses){
            dtos.add(new OauthClientDetailsDto(oauthClientDetails));
        }
        return dtos;
    }

    public boolean isContainsAuthorizationCode() {
        return this.authorizedGrantTypes.contains("authorization_code");
    }

    public boolean isContainsPassword() {
        return this.authorizedGrantTypes.contains("password");
    }

    public boolean isContainsImplicit() {
        return this.authorizedGrantTypes.contains("implicit");
    }

    public boolean isContainsClientCredentials() {
        return this.authorizedGrantTypes.contains("client_credentials");
    }

    public boolean isContainsRefreshToken() {
        return this.authorizedGrantTypes.contains("refresh_token");
    }


    public OauthClientDetails createDomain() {
        OauthClientDetails clientDetails = new OauthClientDetails()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .resourceIds(resourceIds)
                .authorizedGrantTypes(authorizedGrantTypes)
                .scope(scope);

        if (StringUtils.isNotEmpty(webServerRedirectUri)) {
            clientDetails.webServerRedirectUri(webServerRedirectUri);
        }

        if (StringUtils.isNotEmpty(authorities)) {
            clientDetails.authorities(authorities);
        }

        clientDetails.accessTokenValidity(accessTokenValidity)
                .refreshTokenValidity(refreshTokenValidity)
                .trusted(trusted);

        if (StringUtils.isNotEmpty(additionalInformation)) {
            clientDetails.additionalInformation(additionalInformation);
        }

        return clientDetails;
    }
}
