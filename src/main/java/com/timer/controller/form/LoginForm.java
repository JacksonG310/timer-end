package com.timer.controller.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    @NotNull
    String account;
    @NotNull
    String password;
    @NotNull
    boolean isMobile;
}
