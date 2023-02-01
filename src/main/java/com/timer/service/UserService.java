package com.timer.service;

import com.timer.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
//    登录
    HashMap login(HashMap loginParams);
    List<User> findAll();
    HashMap findAccount(String account);

    int register(HashMap registerParams);
}
