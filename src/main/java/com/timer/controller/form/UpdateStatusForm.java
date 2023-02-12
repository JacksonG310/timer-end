package com.timer.controller.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UpdateStatusForm {

    private Date finishTime;
    private int finishStatus;
    @NotNull
    private Date updated;
    @NotNull
    private int status;
    @NotNull
    private int userId;
    @NotNull
    private int taskId;
}
