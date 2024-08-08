package com.example.BusQuerySystem.service;

import org.springframework.stereotype.Service;
import com.example.BusQuerySystem.model.User;


public interface UserService {
    boolean register(User user);
    User login(String username, String password);
}
