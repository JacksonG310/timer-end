package com.timer.controller.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FindAccountForm {
    @NotNull
    private String phone;
}
