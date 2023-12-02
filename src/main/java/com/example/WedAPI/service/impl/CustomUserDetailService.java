package com.example.WedAPI.service.impl;

import com.example.WedAPI.model.CustomUserDetail;
import com.example.WedAPI.model.User;
import com.example.WedAPI.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user, userRepository);
    }
    // Phương thức kiểm tra người dùng có phải là Admin
    public boolean isAdmin(String username) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getRoles().stream()
                .anyMatch(role -> role.getName().equals("Admin"));
    }
}
