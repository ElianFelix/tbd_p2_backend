package com.tbd.bank_backend.services;

import java.util.Date;

import com.tbd.bank_backend.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.tbd.bank_backend.models.User;

@Component public class JwtUtil {
private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    public String generateAccessToken(User user) {
    return Jwts.builder()
    .setSubject(String.format("%s,%s", user.getUserName(), user.getEmail()))
    .setIssuer("CodeJava")
    .setIssuedAt(new Date())
    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
    .compact();

    }
}

