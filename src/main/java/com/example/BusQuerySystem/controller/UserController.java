package com.example.BusQuerySystem.controller;

import com.example.BusQuerySystem.model.User;
import com.example.BusQuerySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean success = userService.register(user);
        return success ? "注册成功" : "注册失败";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        return user != null ? "登录成功" : "用户名或密码错误";
    }

    @GetMapping("/login")
    public ResponseEntity<Resource> getLoginPage() throws IOException {
        Resource resource = new ClassPathResource("static/html/loginAndRegister/login.html");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/register")
    public ResponseEntity<Resource> getRegisterPage() throws IOException {
        Resource resource = new ClassPathResource("static/html/loginAndRegister/register.html");
        return ResponseEntity.ok().body(resource);
    }
}