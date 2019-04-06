package com.peng.common.domain;


import com.peng.web.exception.ErrorCodeMsg;

/**
 * created by guoqingpeng on 2019/4/6
 */
@ErrorCodeMsg(name="ErrorCodeMsgEnum",getMsgMethod = "getMessage",getCodeMethod = "getCode")
public enum ErrorCodeMsgEnum {
    PARAMS_NULL(10002,"%s参数为空"),
    PARAMS_NULL_WITHOUT_MSG(10003,"参数缺失"),
    SERVICE_ERROR(99998,"%s");
    private Integer code;
    private String message;

    ErrorCodeMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
