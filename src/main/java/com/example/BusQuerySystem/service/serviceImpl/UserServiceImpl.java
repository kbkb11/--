package com.example.BusQuerySystem.service.serviceImpl;

import com.example.BusQuerySystem.mapper.UserMapper;
import com.example.BusQuerySystem.model.User;
import com.example.BusQuerySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean register(User user) {
        int result = userMapper.insert(user);
        return result > 0;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectById(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
