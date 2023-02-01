package com.timer.entity;

import lombok.Data;

@Data
public class TodoClassify {
    private int id;
    private String name;
    private String color;
    private boolean isFold;
    private int creator;
    private int tagId;
}
