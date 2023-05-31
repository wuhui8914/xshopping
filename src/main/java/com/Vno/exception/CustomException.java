package com.vno.exception;

import com.vno.common.ResultCode;

/**
 * @Description: 用户自定义异常，用户前端返回错误信息
 * @ClassName: CustomException
 * @Author: dx
 * @Date: 2023/5/30 14:31
 * @Version: 1.0
 */
public class CustomException extends RuntimeException{

    private String code;
    private String msg;

    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CustomException(ResultCode resultCode) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
