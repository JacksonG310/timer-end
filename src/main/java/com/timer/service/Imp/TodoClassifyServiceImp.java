package com.timer.service.Imp;

import com.timer.mapper.TodoClassifyMapper;
import com.timer.service.TodoClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TodoClassifyServiceImp implements TodoClassifyService {
    @Autowired
    private TodoClassifyMapper todoClassifyMapper;

    @Override
    public HashMap findUserTags(Integer userId) {
        return todoClassifyMapper.findUserTags(userId);
    }
}
