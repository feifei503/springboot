package com.feifei.springboot.handle;

import com.feifei.springboot.enum1.BusinessMsgEnum;

/**
 * @description: 自定义异常
 * @author: 闲得无聊
 * @date: 2020-02-19 14:14
 **/
public class BusinessErrorException {

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常提示信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.code();
        this.message = businessMsgEnum.msg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
