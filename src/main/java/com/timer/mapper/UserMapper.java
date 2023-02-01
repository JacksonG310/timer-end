package com.timer.mapper;

import com.timer.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface UserMapper {
    List<User> findAllUsers();
    HashMap findAccount(String phone);
    HashMap login(HashMap loginParams);

    int register (HashMap registerParams);
}
