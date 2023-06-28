package com.vno.controller;

import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.GoodsInfo;
import com.vno.entity.OrderInfo;
import com.vno.exception.CustomException;
import com.vno.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version: 0.1.1
 * @Author: Dx Orange
 * @description:订单控制器
 * @date: 2023-06-27 10:04
 */
@RestController
@RequestMapping(value = "orderInfo")
@Api(value = "提供购物车下单接口",tags = "用户订单管理")
@CrossOrigin
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 功能描述:下订单
     * @author Dx
     * @date 2023/6/27 0027
     * @param orderInfo
     * @return com.vno.common.Result<com.vno.entity.OrderInfo>
     */
    @ApiOperation("购物车下订单")
    @PostMapping("/add")
    public Result<OrderInfo> add(@RequestBody OrderInfo orderInfo){
        Long userid = orderInfo.getUserid();
        List<GoodsInfo> goodsInfoList = orderInfo.getGoodsInfoList();
        if(userid == null || goodsInfoList == null || goodsInfoList.size() == 0){
            throw new CustomException(ResultCode.PARAM_ERROR);
        }
        orderInfo.setState("待付款");
        return Result.success(orderInfoService.add(orderInfo));
    }
}
