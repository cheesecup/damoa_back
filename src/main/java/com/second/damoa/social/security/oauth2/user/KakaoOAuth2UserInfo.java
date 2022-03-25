package com.second.damoa.social.security.oauth2.user;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {
    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public String getName() {
        Map<String, Object> propertiesObj = (Map<String, Object>) attributes.get("properties");
        return (String) propertiesObj.get("profile_nickname");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("account_email");
    }

    @Override
    public String getProfile() {
        Map<String, Object> propertiesObj = (Map<String, Object>) attributes.get("properties");
        return (String) propertiesObj.get("profile_image");
    }
}
