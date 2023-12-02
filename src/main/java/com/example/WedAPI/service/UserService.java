package com.example.WedAPI.service;

import com.example.WedAPI.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User saveUser(User user);
    void deleteUserById(long id);
    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

    String login(String username, String password);

    public List<String> getAllowedRoles(String username);

}
