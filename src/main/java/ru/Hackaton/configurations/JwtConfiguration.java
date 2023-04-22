package ru.Hackaton.configurations;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtConfiguration {
    @Value("${jwt.token.access.secret}")
    private String secretKeyForAccessToken;
    @Value("${jwt.token.refresh.secret}")
    private String secretKeyForRefreshToken;
    @Value("${jwt.token.access.action-time}")
    private long actionTimeOfAccessTokenInMinutes;
    @Value("${jwt.token.refresh.action-time}")
    private long actionTimeOfRefreshTokenInMinutes;
    @Value("${backend-url}")
    private String issuer;

    private JwtParser verifierForAccessToken;
    private JwtParser verifierForRefreshToken;

    @PostConstruct
    public void init() {
        verifierForAccessToken =  Jwts.parserBuilder()
                .setSigningKey(secretKeyForAccessToken)
                .build();
        verifierForRefreshToken = Jwts.parserBuilder()
                .setSigningKey(secretKeyForRefreshToken)
                .build();
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(actionTimeOfAccessTokenInMinutes).toInstant()))
                .setIssuedAt(new Date())
                .setIssuer(issuer)
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS256, secretKeyForAccessToken)
                .compact();
    }

    public String generateRefreshToken(long id) {
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(actionTimeOfRefreshTokenInMinutes).toInstant()))
                .setIssuedAt(new Date())
                .setIssuer(issuer)
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, secretKeyForRefreshToken)
                .compact();
    }

    public boolean verifyAccessToken(String token) {
        return verifierForAccessToken.isSigned(token);
    }

    public boolean verifyRefreshToken(String token) {
        return verifierForRefreshToken.isSigned(token);
    }

    public String getUsernameFromAccessToken(String accessToken) {
        return (String) verifierForAccessToken.parseClaimsJws(accessToken).getBody().get("username");
    }

    public long getIdFromRefreshToken(String refreshToken) {
        return (long) verifierForRefreshToken.parseClaimsJws(refreshToken).getBody().get("id");
    }
}