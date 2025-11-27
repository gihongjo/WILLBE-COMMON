package com.willbe.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    public String createAccessToken(String uid) {
        return createToken(uid, jwtProperties.getAccessTokenExpiration());
    }

    public String createRefreshToken(String uid) {
        return createToken(uid, jwtProperties.getRefreshTokenExpiration());
    }

    private String createToken(String uid, long validityTime) {
        Assert.hasText(jwtProperties.getSecret(), "JWT secret must be configured");

        Claims claims = Jwts.claims().setSubject(uid);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    public String getEmail(String token) {
        Assert.hasText(jwtProperties.getSecret(), "JWT secret must be configured");

        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Assert.hasText(jwtProperties.getSecret(), "JWT secret must be configured");
            Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

