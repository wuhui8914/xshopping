package com.vno.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.vno.entity.CartInfo;

import com.vno.entity.GoodsInfo;
import com.vno.mapper.CartInfoMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private GoodsInfoService goodsInfoService;

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

    /**
     * @description:根据用户后去购物车商品列表（带购物车数量）
     * @author: dx
     * @date: 2023/6/8 10:27
     * @param: [id]
     * @return: java.util.List<com.vno.entity.CartInfo>
     **/
    public List<GoodsInfo> findAll(Long id){
        List<CartInfo> cartInfoList = cartInfoMapper.findCartByUserId(id);

        List<GoodsInfo> goodsInfoList = new ArrayList<>();

        for (CartInfo cartInfo:cartInfoList) {
            long goodsId =cartInfo.getGoodsid();
            GoodsInfo goodsInfo = goodsInfoService.findById(goodsId);
            if(goodsInfo != null){
                //这里的count是用户加入购物车的商品数量，不是商品数量
                goodsInfo.setCount(cartInfo.getCount());
                //这里的id是购物车里商品的id
                goodsInfo.setId(cartInfo.getGoodsid());
                goodsInfoList.add(goodsInfo);
            }
        }

        return goodsInfoList;

    }

    /**
     * @description: 删除用户购物车的某个商品
     * @author: dx
     * @date: 2023/6/8 16:13
     * @param: [userId, goodsId]
     * @return: int
     **/
    public int deleteGoods(Long userId,Long goodsId){
        return cartInfoMapper.deleteGoods(userId, goodsId);
    }

    /**
     * @description: 购物车对应的商品增加或减 1
     * @author: dx
     * @date: 2023/6/7 16:53
     * @param: [detaCartInfo]
     * @return: com.vno.entity.CartInfo
     **/
    public int updateS(int type,Long userId,Long goodsId){
        //根据传过来的userId和goodsId来更新对应购物车商品数量
        int sum = 0;
        Example example = new Example(CartInfo.class);
        example.createCriteria().andEqualTo("userid",userId).andEqualTo("goodsid",goodsId);
        List<CartInfo> cartInfoList = cartInfoMapper.selectByExample(example);
        int i = cartInfoMapper.updateCartInfoCount(cartInfoList.get(0).getCount() + type, userId, goodsId);
        return  i;
    }
}
