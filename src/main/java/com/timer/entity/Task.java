package com.timer.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private  int id;
    private int classifyId;
    private int status;
    private int importance;
    private Date created;
    private Date updated;
    private String remark;
    private DateTime finishTime;
    private int finishState;
    private int creator;
}
