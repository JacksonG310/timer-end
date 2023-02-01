package com.timer.controller.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterForm {
    private String code;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    @NotNull
    private String nickName;
}
