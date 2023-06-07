package com.vno.controller;

import com.github.pagehelper.PageInfo;
import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.TypeInfo;
import com.vno.exception.CustomException;
import com.vno.service.TypeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 商品类别增删改查控制器
 * @ClassName: TypeInfoController
 * @Author: dx
 * @Date: 2023/5/30 17:15
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/typeInfo")
@Api(value = "提供商品类别的信息接口",tags = "商品类别")
@CrossOrigin
public class TypeInfoController {

    @Resource
    private TypeInfoService typeInfoService;

    private Logger logger = LoggerFactory.getLogger(TypeInfoController.class);

    /**
     * @description: 分页查询商品类别列表
     * @author: dx
     * @date: 2023/5/30 17:20
     * @param: [pageNum, pageSize, name]
     * @return: com.vno.common.Result<com.github.pagehelper.PageInfo<com.vno.entity.typeInfo>>
     **/
    @ApiOperation("分页查询商品类别列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum", value = "当前页",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "pageSize", value = "显示条数",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "name", value = "商品类别名",required = true)
    })
    @GetMapping("/page/{name}")
    public Result<PageInfo<TypeInfo>> userInfoPaga(@RequestParam(defaultValue = "1") Integer pageNum,
                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @PathVariable String name){
        PageInfo<TypeInfo> page = typeInfoService.findPage(pageNum, pageSize, name);
        return Result.success(page);

    }

    /**
     * @description: 新增商品类别
     * @author: dx
     * @date: 2023/5/31 14:29
     * @param: [userInfo]
     * @return: com.vno.common.Result<com.vno.entity.typeInfo>
     **/
    @ApiOperation("新增商品类别")
    @PostMapping("/add")
    public Result<TypeInfo> add(@RequestBody TypeInfo typeInfo){
        TypeInfo typeInfoAdd = typeInfoService.add(typeInfo);
        return Result.success(typeInfoAdd);

    }

    @ApiOperation("更新商品类别")
    @PutMapping("/update")
    public Result update(@RequestBody TypeInfo typeInfo){
        int i = typeInfoService.update(typeInfo);
        if( i== 0){
            throw new CustomException(ResultCode.USER_UPDATE_TYPEINFO);
        }
        return Result.success();
    }

    @ApiOperation("删除商品类别")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        int i = typeInfoService.delete(id);
        if( i== 0){
            throw new CustomException(ResultCode.USER_DELETE_TYPEINFO);
        }
        return Result.success();
    }

    @ApiOperation("根据商品类别id查询商品类别")
    @GetMapping("/detail/{id}")
    public Result<TypeInfo> detail(@PathVariable Long id){
        TypeInfo byId = typeInfoService.findById(id);
        return Result.success(byId);
    }
}
