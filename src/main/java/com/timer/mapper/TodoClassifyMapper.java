package com.timer.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
@Mapper
public interface TodoClassifyMapper {
    HashMap findUserTags(Integer userId);
}
