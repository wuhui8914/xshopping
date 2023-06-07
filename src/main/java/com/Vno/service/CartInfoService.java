package com.vno.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.vno.entity.CartInfo;

import com.vno.mapper.CartInfoMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description: 购物车fuwu
 * @ClassName: CartInfoService
 * @Author: dx
 * @Date: 2023/6/7 16:51
 * @Version: 1.0
 */
@Service
public class CartInfoService {

    @Resource
    private CartInfoMapper cartInfoMapper;

    /**
     * @description: 加入购入车
     * @author: dx
     * @date: 2023/6/7 16:53
     * @param: [detaCartInfo]
     * @return: com.vno.entity.CartInfo
     **/
    public CartInfo add(CartInfo detaCartInfo){
        //1.先判断该商品是否已经存在购物车，不存在则加入
        //2.已存在则数量加1
        Long userId = detaCartInfo.getUserid();
        Long goodsId = detaCartInfo.getGoodsid();
        // 先查询购物车有没有该上商品,有更新，没有则加入
        Example example = new Example(CartInfo.class);
        example.createCriteria().andEqualTo("userid",userId).andEqualTo("goodsid",goodsId);
        List<CartInfo> cartInfoList = cartInfoMapper.selectByExample(example);
        if(CollectionUtil.isEmpty(cartInfoList)){
            //新增
            detaCartInfo.setCreatetime(DateUtil.formatDateTime(new Date()));
            cartInfoMapper.insertSelective(detaCartInfo);
        }else{
            //更新
            CartInfo cartInfo = cartInfoList.get(0);
            cartInfo.setCount(cartInfo.getCount() + detaCartInfo.getCount());
            cartInfoMapper.updateByPrimaryKeySelective(cartInfo);
        }
        return detaCartInfo;
    }
}
