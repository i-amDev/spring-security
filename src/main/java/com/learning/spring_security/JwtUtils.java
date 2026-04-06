package com.learning.spring_security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "cXdlcnR5dWlvcGFzZGZnaGprbHp4Y3Zibm09cXdlcnR5dWlvcGFzZGZnaGprbHp4Y3Zibm0=";
    private final int jwtExpirationMs = 1000 * 60 * 60; // 1 hour

    public String generateTokenFromUsername(String userName) {
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

}
