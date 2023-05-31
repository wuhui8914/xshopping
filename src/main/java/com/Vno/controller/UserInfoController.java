package com.vno.controller;

import com.github.pagehelper.PageInfo;
import com.vno.common.Result;
import com.vno.entity.UserInfo;
import com.vno.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 用户信息增删改查控制器
 * @ClassName: UserInfoController
 * @Author: dx
 * @Date: 2023/5/30 17:15
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/userInfo")
@Api(value = "提供用户的信息接口",tags = "用户个人信息")
@CrossOrigin
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * @description: 分页查询用户列表
     * @author: dx
     * @date: 2023/5/30 17:20
     * @param: [pageNum, pageSize, name]
     * @return: com.vno.common.Result<com.github.pagehelper.PageInfo<com.vno.entity.UserInfo>>
     **/
    @ApiOperation("分页查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum", value = "当前页",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "pageSize", value = "显示条数",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "name", value = "用户名",required = true)
    })
    @GetMapping("/page/{name}")
    public Result<PageInfo<UserInfo>> userInfoPaga(@RequestParam(defaultValue = "1") Integer pageNum,
                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @PathVariable String name){
        PageInfo<UserInfo> page = userInfoService.findPage(pageNum, pageSize, name);
        return Result.success(page);

    }

    /**
     * @description: 新增用户
     * @author: dx
     * @date: 2023/5/31 14:29
     * @param: [userInfo]
     * @return: com.vno.common.Result<com.vno.entity.UserInfo>
     **/
    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result<UserInfo> add(@RequestBody UserInfo userInfo){
        UserInfo userInfoAdd = userInfoService.add(userInfo);
        return Result.success(userInfoAdd);

    }
}
