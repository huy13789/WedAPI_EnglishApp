package com.example.WedAPI.controller;

import com.example.WedAPI.model.User;
import com.example.WedAPI.repository.IUserRepository;
import com.example.WedAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Author: Ngô Nguyễn Huy
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        //Lấy token
        String users = userService.login(user.getUsername(), user.getPassword());
        if (users != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.badRequest().body("Tên người dùng hoặc mật khẩu không đúng");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?>  register(@Valid @RequestBody User user){
        if(iUserRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body("Đã có user tên đó");
        }
        User newuser = userService.saveUser(user);
        if (newuser != null) {
            return ResponseEntity.ok("Tạo user thành công");
        } else {
            return ResponseEntity.badRequest().body("Lỗi");
        }
    }


}
