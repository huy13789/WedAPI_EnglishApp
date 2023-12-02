package com.example.WedAPI.service.impl;

import com.example.WedAPI.model.User;
import com.example.WedAPI.repository.IRoleRepository;
import com.example.WedAPI.repository.IUserRepository;
import com.example.WedAPI.service.JwtService;
import com.example.WedAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private JwtService jwtService;

    @Override
    public void save(User user) {
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("User");
        if(roleId != 0 && userId != 0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(new
                BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("User");
        if(roleId != 0 && userId != 0) {
            userRepository.addRoleToUser(userId, roleId);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public String login(String username, String password) {
        // Kiểm tra username và password
        User user = userRepository.findByUsername(username);
        //String hashpw =  new BCryptPasswordEncoder().encode(password);
        if(user == null || !new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return null;
        }
        // Tạo JWT
        String token = jwtService.generateToken(user);

        return token;
    }

    @Override
    public List<String> getAllowedRoles(String username) {
        List<String> allowedRoles = new ArrayList<>();
        User user = userRepository.findByUsername(username);
        // Kiểm tra role của user đó
        if(user.getRoles().equals("User")) {
            allowedRoles.add("User");
        }
        else {
            allowedRoles.add("Admin");
        }

        return allowedRoles;

    }
}
