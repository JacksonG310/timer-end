package com.timer.controller.form;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UpdateTaskForm {
    @NotNull
    private int taskId;
    @NotNull
    private int classifyId;
    @NotNull
    private int importance;
    @NotNull
    private Date updated;
    private String remark;
    @NotNull
    private String title;
    @NotNull
    private int userId;
    @NotNull
    private Date endTime;
    @NotNull
    private Date startTime;
}
