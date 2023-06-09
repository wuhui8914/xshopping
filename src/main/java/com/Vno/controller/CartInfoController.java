package com.vno.controller;

import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.CartInfo;
import com.vno.entity.GoodsInfo;
import com.vno.exception.CustomException;
import com.vno.service.CartInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 购物车控制器
 * @ClassName: CartInfoController
 * @Author: dx
 * @Date: 2023/6/7 16:49
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/cartInfo")
@Api(value = "购物车控制器接口",tags = "购物车管理")
@CrossOrigin
public class CartInfoController {

    @Resource
    private CartInfoService cartInfoService;

    @ApiOperation("新增商品到购物车")
    @PostMapping("/add")
    public Result<CartInfo> add(@RequestBody CartInfo cartInfo){
        return Result.success(cartInfoService.add(cartInfo));
    }

    /**
     * @description:查询用户的购物车（不分页）
     * @author: dx
     * @date: 2023/6/8 10:45
     * @param:
     * @return:
     **/
    @ApiOperation("查询用户的购物车（不分页）")
    @GetMapping("/findAll")
    public Result<List<GoodsInfo>> findAll(@RequestParam Long userId){
        List<GoodsInfo> goodsInfoList = cartInfoService.findAll(userId);
        return Result.success(goodsInfoList);
    }

    @ApiOperation("从购物出中删除商品")

    @DeleteMapping("/goods/delete/{userId}/{goodsId}")
    public Result deleteGoods(@PathVariable Long userId,@PathVariable Long goodsId){
        int i = cartInfoService.deleteGoods(userId, goodsId);
        if(i>0){
           return  Result.success();
        }else{
            return Result.error();
        }
    }

    @ApiOperation("购物车对应的商品增加或减 1")
    @PutMapping("/updates/{type}/{userId}/{goodsId}")
    public Result updates(@PathVariable int type,@PathVariable Long userId,@PathVariable Long goodsId){
        int i = cartInfoService.updateS(type,userId,goodsId);
        if( i== 0){
            throw new CustomException(ResultCode.USER_UPDATE_CARTINFO);
        }
        return Result.success();
    }
}
