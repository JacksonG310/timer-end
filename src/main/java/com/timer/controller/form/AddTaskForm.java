package com.timer.controller.form;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AddTaskForm {
    @NotNull
    private int classifyId;
    @NotNull
    @Min(0)
    @Max(1)
    private int status;
    @NotNull
    @Min(1)
    @Max(4)
    private int importance;
    @NotNull
    private Date created;
    private Date updated;
    private String remark;
    @NotNull
    private int creator;
    @NotNull
    private Date from;
    @NotNull
    private Date to;
    @NotNull
    private String title;
}
