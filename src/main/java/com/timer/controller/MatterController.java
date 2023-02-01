package com.timer.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.timer.service.TodoClassifyService;
import com.timer.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MatterController {
    @Autowired
    private TodoClassifyService todoClassifyService;

    @SaCheckLogin
    @GetMapping("/findTags")
    public Result findUserTags(@RequestParam("userId") Integer id){
        HashMap data = todoClassifyService.findUserTags(id);
        return Result.success(data);
    }
}
