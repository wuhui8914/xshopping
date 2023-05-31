package com.vno.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.vno.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 控制器全局异常拦截
 * @ClassName: GloalExceptionHandler
 * @Author: dx
 * @Date: 2023/5/30 14:35
 * @Version: 1.0
 */
@ControllerAdvice(basePackages = "com.vno.controller")
public class GloalExceptionHandler {
    private static final Log log = LogFactory.get();

    /* 统一异常处理，主要用于Exception*/
    @ExceptionHandler(Exception.class)
    @ResponseBody  //返回json串
    public Result error(HttpServletRequest request, Exception e){
        log.error("异常信息",e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customError(HttpServletRequest request,CustomException customException){
        log.error("异常信息",customException.getMsg());
        return Result.error(customException.getCode(),customException.getMsg());
    }
}
