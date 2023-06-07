package com.vno.controller;

import com.github.pagehelper.PageInfo;
import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.GoodsInfo;
import com.vno.entity.TypeInfo;
import com.vno.exception.CustomException;
import com.vno.service.GoodsInfoService;
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
 * @Description: 商品增删改查控制器
 * @ClassName: TypeInfoController
 * @Author: dx
 * @Date: 2023/5/30 17:15
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/goodsInfo")
@Api(value = "提供商品的信息接口",tags = "商品")
@CrossOrigin
public class GoodsInfoController {

    @Resource
    private GoodsInfoService goodsInfoService;

    private Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    /**
     * @description: 分页查询商品列表
     * @author: dx
     * @date: 2023/5/30 17:20
     * @param: [pageNum, pageSize, name]
     * @return: com.vno.common.Result<com.github.pagehelper.PageInfo<com.vno.entity.goodsInfo>>
     **/
    @ApiOperation("分页查询商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum", value = "当前页",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "pageSize", value = "显示条数",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "name", value = "商品名",required = true)
    })
    @GetMapping("/page/{name}")
    public Result<PageInfo<GoodsInfo>> userInfoPaga(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @PathVariable String name){
        PageInfo<GoodsInfo> page = goodsInfoService.findPage(pageNum, pageSize, name);
        return Result.success(page);

    }

    /**
     * @description: 新增商品
     * @author: dx
     * @date: 2023/5/31 14:29
     * @param: [userInfo]
     * @return: com.vno.common.Result<com.vno.entity.goodsInfo>
     **/
    @ApiOperation("新增商品")
    @PostMapping("/add")
    public Result<GoodsInfo> add(@RequestBody GoodsInfo goodsInfo){
        GoodsInfo goodsInfoAdd = goodsInfoService.add(goodsInfo);
        return Result.success(goodsInfoAdd);

    }

    @ApiOperation("更新商品")
    @PutMapping("/update")
    public Result update(@RequestBody GoodsInfo goodsInfo){
        int i = goodsInfoService.update(goodsInfo);
        if( i== 0){
            throw new CustomException(ResultCode.USER_UPDATE_GOODSINFO);
        }
        return Result.success();
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        int i = goodsInfoService.delete(id);
        if( i== 0){
            throw new CustomException(ResultCode.USER_DELETE_GOODSINFO);
        }
        return Result.success();
    }

    @ApiOperation("根据商品id查询商品")
    @GetMapping("/detail/{id}")
    public Result<GoodsInfo> detail(@PathVariable Integer id){
        GoodsInfo byId = goodsInfoService.findById(id);
        return Result.success(byId);
    }

    @ApiOperation("获取推荐商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum", value = "当前页",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "pageSize", value = "显示条数",required = true)
    })
    @GetMapping("/findRecommendGoods")
    public Result<PageInfo<GoodsInfo>> findRecommendGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "100") Integer pageSize){
        PageInfo<GoodsInfo> page = goodsInfoService.findRecommendGoods(pageNum, pageSize);
        return Result.success(page);

    }

    @ApiOperation("获取热点推荐商品")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "pageNum", value = "当前页",required = true),
            @ApiImplicitParam(dataType = "Integer",name = "pageSize", value = "显示条数",required = true)
    })
    @GetMapping("/findHotSalesGoods")
    public Result<PageInfo<GoodsInfo>> findHotSalesGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                                         @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<GoodsInfo> page = goodsInfoService.findHotSalesGoods(pageNum, pageSize);
        return Result.success(page);

    }
}
