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

    @Override
    public int addTag(HashMap params) {
        int row1 = todoClassifyMapper.addTag(params);
        HashMap nextParams = new HashMap();
        nextParams.put("tagId",params.get("tagId"));
        nextParams.put("creatorId",params.get("creatorId"));
        int row2 = todoClassifyMapper.updateUserTags(nextParams);
        return row1 + row2;
    }

    @Override
    public int updateTagName(HashMap params) {
        return todoClassifyMapper.updateTagName(params);
    }
}
