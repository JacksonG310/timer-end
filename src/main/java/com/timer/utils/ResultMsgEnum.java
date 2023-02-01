package com.timer.utils;

public enum ResultMsgEnum {
    SUCCESS(200,"操作成功"),
    FAIT(500,"操作失败"),
    DATABASE_OPERATION_FAILED(504,"数据库操作失败");
    private int code;
    private String message;

    ResultMsgEnum(int code,String message){
        this.code = code;
        this.message = message;
    }
    public int getCode(){
        return this.code;
    }

    public String getMessage() {
        return message;
    }
}
