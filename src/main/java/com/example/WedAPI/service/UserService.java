package com.example.WedAPI.service;

import com.example.WedAPI.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

    String login(String username, String password);

    public List<String> getAllowedRoles(String username);

}
