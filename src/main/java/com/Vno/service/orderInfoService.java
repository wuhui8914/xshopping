package com.vno.service;

import com.vno.entity.OrderInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 订单相关的服务类
 * @ClassName: orderInfoService
 * @Author: dx
 * @Date: 2023/6/9 15:03
 * @Version: 1.0
 */
@Service
public class orderInfoService {

    /**
     * @description: 下单
     * @author: dx
     * @date: 2023/6/9 15:03
     * @param:
     * @return:
     **/

    @Transactional  //事务
    public OrderInfo add(OrderInfo orderInfo){
        //1.生成最基本的订单信息，用户信息，放到orderInfo里
        //2.保存订单表
        //3.查询订单里面的商品列表，遍历
        //4.库存
        //5.增加销量
        //6.商品订单关联表，增加关系
        //7.清空购物车

        return null;
    }

}
