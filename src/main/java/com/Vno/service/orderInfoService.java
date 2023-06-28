package com.vno.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.vno.entity.OrderInfo;
import com.vno.entity.UserInfo;
import com.vno.mapper.OrderInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description: 订单相关的服务类
 * @ClassName: orderInfoService
 * @Author: dx
 * @Date: 2023/6/9 15:03
 * @Version: 1.0
 */
@Service
public class OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private CartInfoService cartInfoService;


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
        Long userid = orderInfo.getUserid();
        // 订单id：用户id+当前年月日时分+4位流水号
        String orderId = userid + DateUtil.format(new Date(), "yyyy-MM-dd") + RandomUtil.randomNumbers(4);
        orderInfo.setOrderid(orderId);
        //用户相关的
        UserInfo userInfo = userInfoService.findById(userid);
        orderInfo.setLinkaddress(userInfo.getAddress());
        orderInfo.setLinkman(userInfo.getNickname());
        orderInfo.setLinkphone(userInfo.getPhone());
        //2.保存订单表
        orderInfo.setCreatetime(DateUtil.formatDateTime(new Date()));
        orderInfoMapper.insertSelective(orderInfo);
        //3.查询订单里面的商品列表，遍历
        //4.库存
        //5.增加销量
        //6.商品订单关联表，增加关系
        //7.清空购物车

        return null;
    }

}
