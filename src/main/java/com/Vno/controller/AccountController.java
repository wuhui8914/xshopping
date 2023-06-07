package com.vno.controller;

import cn.hutool.core.util.StrUtil;
import com.vno.common.Common;
import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.UserInfo;
import com.vno.exception.CustomException;
import com.vno.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;

/**
 * @Description: 登录、退出相关的控制器
 * @ClassName: AccountController
 * @Author: dx
 * @Date: 2023/5/30 9:52
 * @Version: 1.0
 */

@RestController
@RequestMapping("/user")
@Api(value = "提供用户的登录和注册接口",tags = "用户管理")
@CrossOrigin
public class AccountController {


    @Resource
    private UserInfoService userInfoService;

    /**
     * @description: 登录
     * @author: dx
     * @date: 2023/5/30 16:30
     * @param: [name, pwd, request]
     * @return: com.vno.common.Result<com.vno.entity.UserInfo>
     **/
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",required = true)
    })
    @GetMapping("/login")
    public Result<UserInfo> login(@RequestParam("username") String name,
                                @RequestParam(value = "password") String pwd,HttpServletRequest request){
        if(StrUtil.isBlank(name) || StrUtil.isBlank(pwd)){
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        //todo 从数据库查询账号和密码是否正确
        UserInfo login = userInfoService.login(name, pwd);
        HttpSession session = request.getSession();
        session.setAttribute(Common.USER_INFO,login);
        session.setMaxInactiveInterval(60*24);
        return Result.success(login);
    }

    /**
     * @description:用户重置密码
     * @author: dx
     * @date: 2023/5/30 16:30
     * @param: [name, request]
     * @return: com.vno.common.Result<com.vno.entity.UserInfo>
     **/
    @ApiOperation("用户重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",required = true)
    })
    @GetMapping("/reset")
    public Result<UserInfo> reset(@RequestParam("username") String name,HttpServletRequest request){
        return Result.success(userInfoService.resetPwd(name));
    }

    /**
     * @description: 退出
     * @author: dx
     * @date: 2023/5/30 16:32
     * @param: [request]
     * @return: com.vno.common.Result
     **/
    @ApiOperation("用户退出")
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().setAttribute(Common.USER_INFO,null);
        return Result.success();
    }

    /**
     * @description:小程序端用户注册
     * @author: dx
     * @date: 2023/6/7 9:53
     * @param: [request]
     * @return: com.vno.common.Result<com.vno.entity.UserInfo>
     *
     **/
    @ApiOperation("小程序端用户注册")
    @PostMapping("/register")
    public Result<UserInfo> register(@RequestBody UserInfo userInfo,HttpServletRequest request){
        if(StrUtil.isBlank(userInfo.getName()) || StrUtil.isBlank(userInfo.getPassword())){
            throw new CustomException(ResultCode.PARAM_ERROR);
        }
        UserInfo register = userInfoService.add(userInfo);
        HttpSession session = request.getSession();
        session.setAttribute(Common.USER_INFO,register);
        session.setMaxInactiveInterval(60*60*24); //60*60*24 一天
        return Result.success(register);
    }


    @GetMapping("/auth")
    @ApiOperation("小程序端用户是否登录")
    public Result getAuth(HttpServletRequest request){
        Object user = request.getSession().getAttribute(Common.USER_INFO);
        if(user == null){
            return Result.error("401","未登录");
        }
        return Result.success(user);
    }
}
