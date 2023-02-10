package com.timer.service.Imp;

import com.timer.mapper.TaskMapper;
import com.timer.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Override
    public int addTask(HashMap params) {
        return taskMapper.addTask(params);
    }

    @Override
    public List<HashMap> findUserAllTask(int userId) {
        return taskMapper.findUserAllTask(userId);
    }
}
