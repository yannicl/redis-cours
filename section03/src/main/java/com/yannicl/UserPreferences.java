package com.yannicl;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("user-prefs")
public class UserPreferences {

    @Id
    private String userId;
    @Indexed
    private String accountId;
    private String language;
    private String consentCookies;
    @TimeToLive
    Long timeout = 30L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getConsentCookies() {
        return consentCookies;
    }

    public void setConsentCookies(String consentCookies) {
        this.consentCookies = consentCookies;
    }
}
