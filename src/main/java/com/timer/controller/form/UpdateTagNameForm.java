package com.timer.controller.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTagNameForm {
    @NotNull
    private int tagId;
    @NotNull
    private  String title;
}
