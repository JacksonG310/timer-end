package com.timer.service.Imp;


import com.timer.entity.User;
import com.timer.mapper.UserMapper;
import com.timer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public HashMap login(HashMap loginParams) {
        HashMap info = userMapper.login(loginParams);
        return info;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAllUsers();
        return users;
    }

    @Override
    public HashMap findAccount(String account) {
        HashMap data = userMapper.findAccount(account);
        return data;
    }

    @Override
    public int register(HashMap registerParams) {
        return userMapper.register(registerParams);
    }
//    @Override
//    public User findUserByAccount(String account) {
//        User user = userMapper.findUserByAccount(account);
//        return user;
//    }


}
