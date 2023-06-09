package com.vno.mapper;

import com.vno.entity.CartInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartInfoMapper extends Mapper<CartInfo> {

    /**
     * @description:根据用户后去购物车列表
     * @author: dx
     * @date: 2023/6/8 10:27
     * @param: [id]
     * @return: java.util.List<com.vno.entity.CartInfo>
     **/
    List<CartInfo> findCartByUserId(Long id);

    /**
     * @description: 删除用户购物车的某个商品
     * @author: dx
     * @date: 2023/6/8 16:11
     * @param: [userId, goodsId]
     * @return: int
     **/
    @Delete(" delete from cart_info where userId=#{userId} and goodsId=#{goodsId} ")
    int deleteGoods(@Param("userId") Long userId,@Param("goodsId") Long goodsId);

    /**
     * @description: 购物车对应的商品增加或减 1
     * @author: dx
     * @date: 2023/6/9 9:44
     * @param: [userId, goodsId]
     * @return: int
     **/
    int updateCartInfoCount(@Param("counts") Integer counts,@Param("userId") Long userId,@Param("goodsId") Long goodsId);

}