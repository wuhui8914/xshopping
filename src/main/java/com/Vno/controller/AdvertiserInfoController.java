package com.vno.controller;

import com.github.pagehelper.PageInfo;
import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.AdvertiserInfo;
import com.vno.entity.UserInfo;
import com.vno.exception.CustomException;
import com.vno.service.AdvertiserInfoService;
import com.vno.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 公告信息增删改查控制器
 * @ClassName: UserInfoController
 * @Author: dx
 * @Date: 2023/5/30 17:15
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/advertiserInfo")
@Api(value = "提供公告的信息接口",tags = "公告信息")
@CrossOrigin
public class AdvertiserInfoController {

    @Resource
    private AdvertiserInfoService advertiserInfoService;

    private Logger logger = LoggerFactory.getLogger(AdvertiserInfoController.class);

    /**
     * @description: 分页查询公告列表
     * @author: dx
     * @date: 2023/5/30 17:20
     * @param: [pageNum, pageSize, name]
     * @return: com.vno.common.Result<com.github.pagehelper.PageInfo<com.vno.entity.AdvertiserInfo>>
     **/
    @ApiOperation("分页查询公告列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum", value = "当前页",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "pageSize", value = "显示条数",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "name", value = "公告名",required = true)
    })
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdvertiserInfo>> userInfoPaga(@RequestParam(defaultValue = "1") Integer pageNum,
                                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                                         @PathVariable String name){
        PageInfo<AdvertiserInfo> page = advertiserInfoService.findPage(pageNum, pageSize, name);
        return Result.success(page);

    }

    /**
     * @description: 新增公告
     * @author: dx
     * @date: 2023/5/31 14:29
     * @param: [userInfo]
     * @return: com.vno.common.Result<com.vno.entity.AdvertiserInfo>
     **/
    @ApiOperation("新增公告")
    @PostMapping("/add")
    public Result<AdvertiserInfo> add(@RequestBody AdvertiserInfo advertiserInfo){
        AdvertiserInfo advertiserInfoAdd = advertiserInfoService.add(advertiserInfo);
        return Result.success(advertiserInfoAdd);

    }

    @ApiOperation("更新公告")
    @PutMapping("/update")
    public Result update(@RequestBody AdvertiserInfo AdvertiserInfo){
        int i = advertiserInfoService.update(AdvertiserInfo);
        if( i== 0){
            throw new CustomException(ResultCode.USER_UPDATE_ADVERTISERINFO);
        }
        return Result.success();
    }

    @ApiOperation("删除公告")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        int i = advertiserInfoService.delete(id);
        if( i== 0){
            throw new CustomException(ResultCode.USER_DELETE_ADVERTISERINFO);
        }
        return Result.success();
    }

    @ApiOperation("根据公告id查询公告")
    @GetMapping("/detail/{id}")
    public Result<AdvertiserInfo> detail(@PathVariable Long id){
        AdvertiserInfo byId = advertiserInfoService.findById(id);
        return Result.success(byId);
    }
}
