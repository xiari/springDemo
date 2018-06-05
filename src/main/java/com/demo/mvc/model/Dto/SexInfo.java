package com.demo.mvc.model.Dto;

import java.io.Serializable;

public class SexInfo implements Serializable{

    private String sexName; // 性别名称
    private String sexValue ; // 性别枚举值

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getSexValue() {
        return sexValue;
    }

    public void setSexValue(String sexValue) {
        this.sexValue = sexValue;
    }
}
