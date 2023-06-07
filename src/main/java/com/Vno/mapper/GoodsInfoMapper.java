package com.vno.mapper;

import com.vno.entity.AdvertiserInfo;
import com.vno.entity.GoodsInfo;
import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GoodsInfoMapper extends Mapper<GoodsInfo> {

    /*根据商品名称或者根据id模糊查询*/
    List<GoodsInfo> findByName(@Param("name") String name,@Param("id") Integer id);

    /*查询推荐商品*/
    @Select("select * from goods_info where recommend='是'")
    List<GoodsInfo> findRecommendGoods();

    /*查询热卖商品*/
    @Select("select * from goods_info order by sales desc")
    List<GoodsInfo> findHotSalesGoods();

}