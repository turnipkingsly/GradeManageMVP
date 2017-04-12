package com.student.grademanagermvp.model.response;

/**
 * Created by huangbiao on 2016/10/30.
 */

public class BaseRes {

    private String code;
    private String innercode;
    private String wrongmessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInnercode() {
        return innercode;
    }

    public void setInnercode(String innercode) {
        this.innercode = innercode;
    }

    public String getWrongmessage() {
        return wrongmessage;
    }

    public void setWrongmessage(String wrongmessage) {
        this.wrongmessage = wrongmessage;
    }
}
