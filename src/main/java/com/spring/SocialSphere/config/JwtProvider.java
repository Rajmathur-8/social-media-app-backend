package com.spring.SocialSphere.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;



public class JwtProvider {

    private static final SecretKey key = 
    		Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
    private static final String ISSUER = "Raj Mathur";
    private static final long EXPIRATION_TIME = 86400000L; // 24 hours
    private static final String BEARER_PREFIX = "Bearer ";

    public static String generateToken(Authentication auth) {
        String jwt = Jwts.builder()
                .setIssuer(ISSUER)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + EXPIRATION_TIME))
                .claim("email", auth.getName())
                .signWith(key)
                .compact();

        return jwt;
    }

    public static String getEmailFromJwtToken(String jwt) {
        if (jwt != null && jwt.startsWith(BEARER_PREFIX)) {
            try {
                jwt = jwt.substring(BEARER_PREFIX.length());
                Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
                return String.valueOf(claims.get("email"));
            } catch (JwtException e) {
                // Handle the exception as needed, e.g., log the error, throw a custom exception, etc.
                throw new IllegalArgumentException("Invalid JWT token", e);
            }
        }
        throw new IllegalArgumentException("JWT token does not begin with Bearer prefix");
    }
}
