package com.timer.service;

import com.timer.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public interface TaskService {
    public int addTask(HashMap params);
    public List<HashMap> findUserAllTask(int userId);
    public  int updateStatus(HashMap params);

    public HashMap findTaskById(HashMap params);

    public int updateTask(HashMap params);
    public  int deleteTask(HashMap params);
}
