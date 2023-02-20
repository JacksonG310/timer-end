package com.timer.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TaskMapper {
    public List<HashMap> findUserAllTask(int userId);
    public int addTask(HashMap params);
    public int updateStatus(HashMap params);
    public HashMap findTaskById(HashMap params);
    public int updateTask(HashMap params);
    public int deleteTask(HashMap params);
}
