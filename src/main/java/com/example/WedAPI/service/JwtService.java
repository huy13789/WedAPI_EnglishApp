package com.example.WedAPI.service;

import com.example.WedAPI.model.User;
import io.jsonwebtoken.Claims;

import java.util.Map;

public interface JwtService {

    String generateToken(User user);

    Claims validateToken(String token);

}
