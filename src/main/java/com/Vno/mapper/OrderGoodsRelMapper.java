package com.vno.mapper;

import com.vno.entity.OrderGoodsRel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods_rel
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods_rel
     *
     * @mbg.generated
     */
    int insert(OrderGoodsRel row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods_rel
     *
     * @mbg.generated
     */
    int insertSelective(OrderGoodsRel row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods_rel
     *
     * @mbg.generated
     */
    OrderGoodsRel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods_rel
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrderGoodsRel row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods_rel
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrderGoodsRel row);
}