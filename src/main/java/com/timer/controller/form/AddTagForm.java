package com.timer.controller.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddTagForm {
    @NotNull
    private String title;
    @NotNull
    private String color;
    @NotNull
    private Integer creatorId;
    @NotNull
    private Integer tagId;
    @NotNull
    private String iconId;
}
