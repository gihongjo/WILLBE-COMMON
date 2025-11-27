package com.willbe.common.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * Secret key for signing JWT tokens.
     */
    private String secret;

    /**
     * Access token expiration time in milliseconds.
     */
    private long accessTokenExpiration = 1000L * 60 * 60 * 24 * 7; // 7 days

    /**
     * Refresh token expiration time in milliseconds.
     */
    private long refreshTokenExpiration = 1000L * 60 * 60 * 24 * 30; // 30 days

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getAccessTokenExpiration() {
        return accessTokenExpiration;
    }

    public void setAccessTokenExpiration(long accessTokenExpiration) {
        this.accessTokenExpiration = accessTokenExpiration;
    }

    public long getRefreshTokenExpiration() {
        return refreshTokenExpiration;
    }

    public void setRefreshTokenExpiration(long refreshTokenExpiration) {
        this.refreshTokenExpiration = refreshTokenExpiration;
    }
}

