package com.timer.service;

import java.util.HashMap;

public interface TodoClassifyService {
    HashMap findUserTags(Integer userId);

    int addTag(HashMap params);

    int updateTagName(HashMap params);
}
