package com.vno.common;

/**
 * @Description: 统一返回前端结果类
 * @ClassName: Result
 * @Author: dx
 * @Date: 2023/5/30 9:37
 * @Version: 1.0
 */
public class Result<T> {

    /*返回码*/
    private String code;

    /*返回中文信息*/
    private String msg;

    /*返回的对象类*/
    private T data;

    /*不带参数成功的返回*/
    public static Result success(){
        Result result = new Result<>();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        return result;
    }

    /*不带参数失败的返回*/
    public static Result error(){
        Result result = new Result<>();
        result.setCode(ResultCode.ERROR.code);
        result.setMsg(ResultCode.ERROR.msg);
        return result;
    }

    /*自定义的带参数失败的返回*/
    public static Result error(String code,String msg){
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /*带参数成功的返回*/
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        return result;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
