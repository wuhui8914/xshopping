package com.vno.entity;

/**
 * Database Table Remarks:
 *   订单商品关系映射表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table order_goods_rel
 */
public class OrderGoodsRel {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods_rel.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   所属订单id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods_rel.orderId
     *
     * @mbg.generated
     */
    private Long orderid;

    /**
     * Database Column Remarks:
     *   所属商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods_rel.goodsId
     *
     * @mbg.generated
     */
    private Long goodsid;

    /**
     * Database Column Remarks:
     *   商品数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods_rel.count
     *
     * @mbg.generated
     */
    private Integer count;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.id
     *
     * @return the value of order_goods_rel.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.id
     *
     * @param id the value for order_goods_rel.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.orderId
     *
     * @return the value of order_goods_rel.orderId
     *
     * @mbg.generated
     */
    public Long getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.orderId
     *
     * @param orderid the value for order_goods_rel.orderId
     *
     * @mbg.generated
     */
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.goodsId
     *
     * @return the value of order_goods_rel.goodsId
     *
     * @mbg.generated
     */
    public Long getGoodsid() {
        return goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.goodsId
     *
     * @param goodsid the value for order_goods_rel.goodsId
     *
     * @mbg.generated
     */
    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.count
     *
     * @return the value of order_goods_rel.count
     *
     * @mbg.generated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.count
     *
     * @param count the value for order_goods_rel.count
     *
     * @mbg.generated
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}