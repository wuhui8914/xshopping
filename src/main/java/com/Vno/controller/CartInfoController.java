package com.vno.controller;

import com.vno.common.Result;
import com.vno.entity.CartInfo;
import com.vno.service.CartInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 购物车控制器
 * @ClassName: CartInfoController
 * @Author: dx
 * @Date: 2023/6/7 16:49
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/cartInfo")
public class CartInfoController {

    @Resource
    private CartInfoService cartInfoService;

    @PostMapping("/add")
    public Result<CartInfo> add(@RequestBody CartInfo cartInfo){
        return Result.success(cartInfoService.add(cartInfo));
    }
}
