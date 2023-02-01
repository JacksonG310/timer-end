package com.timer.controller;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.timer.controller.form.FindAccountForm;
import com.timer.controller.form.LoginForm;
import com.timer.controller.form.RegisterForm;
import com.timer.service.UserService;
import com.timer.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.stp.SaTokenInfo;

import javax.validation.Valid;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
//    登录
    @PostMapping("/login")
    public Result userLogin(@Valid @RequestBody LoginForm loginForm) throws Exception {
        try {
            HashMap params = JSONUtil.parse(loginForm).toBean(HashMap.class);
            HashMap data = userService.login(params);
            if(data != null && data.get("id") != null){
                StpUtil.login(data.get("id"));
                SaTokenInfo token = StpUtil.getTokenInfo();
                data.put("token",token.tokenValue);
                data.put("loginStatus",1);
                data.put("username",loginForm.getAccount());
                return Result.success(data);
            }else{
                HashMap exceptionData = new HashMap();
                exceptionData.put("loginStatus",0);
                return Result.success(exceptionData);
            }
        }catch(Exception e) {
            return Result.error(500,"请求出错");
        }
    }
//    查找某个账户是否存在
    @PostMapping("/findAccount")
    public Result findAccount(@Valid @RequestBody FindAccountForm findAccountForm){
        HashMap<String,String> params = JSONUtil.parse(findAccountForm).toBean(HashMap.class);
        HashMap info = userService.findAccount(params.get("phone"));
        HashMap data = new HashMap();

        if(info != null){
            data.put("phone",info.get("phone"));
            data.put("exist",true);
        }else{
            data.put("phone",params.get("phone"));
            data.put("exist",false);
        }
        return Result.success(data);
    }

//    注册
    @PostMapping("/register")
    public Result register(@Valid @RequestBody RegisterForm registerForm){
        HashMap<String,String> params = JSONUtil.parse(registerForm).toBean(HashMap.class);

        int row = userService.register(params);
        HashMap data = new HashMap();
        if(row > 0) {
            data.put("message","注册成功");
            data.put("account",params.get("phone"));
            data.put("status",1);
        }else{
            data.put("message","注册失败");
            data.put("status",0);
        }
        return Result.success(data);
    }
}
