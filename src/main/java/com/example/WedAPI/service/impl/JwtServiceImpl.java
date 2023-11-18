package com.example.WedAPI.service.impl;

import com.example.WedAPI.model.User;
import com.example.WedAPI.repository.IUserRepository;
import com.example.WedAPI.service.JwtService;
import com.example.WedAPI.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtServiceImpl implements JwtService {
    @Autowired
    private IUserRepository iUserRepository;
    String secretKey = "JWTAuthenticationHIGHsecuredPasswordVVVp1OH7Xasd707";
    int expirationTime = 12 * 60 * 60 * 1000; // 12 hour
    long now = System.currentTimeMillis();
    Date expiration = new Date(now + expirationTime);

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    // Tạo signing key mới mỗi lần generate token
    byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
    Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

    public String generateToken(User user) {
        Date issuedAt = new Date();

        String[] roles = iUserRepository.getRolesOfUser(user.getId());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("name", user.getFullName())
                .claim("email", user.getEmail())
                .claim("roles", roles)
                .setIssuedAt(issuedAt)
                .signWith(signatureAlgorithm, signingKey)
                .setExpiration(expiration)
                .compact();
    }

    public Claims validateToken(String token) {
        Jws<Claims> jwsClaims = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token);
        Claims claims = jwsClaims.getBody();

        return claims;

    }



}
