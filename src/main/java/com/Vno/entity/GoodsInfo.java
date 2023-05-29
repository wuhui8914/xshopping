package com.vno.entity;

/**
 * Database Table Remarks:
 *   商品详情表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table goods_info
 */
public class GoodsInfo {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商品名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   商品价格
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     * Database Column Remarks:
     *   商品折扣
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.discount
     *
     * @mbg.generated
     */
    private Double discount;

    /**
     * Database Column Remarks:
     *   商品销量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.sales
     *
     * @mbg.generated
     */
    private Integer sales;

    /**
     * Database Column Remarks:
     *   商品点赞数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.hot
     *
     * @mbg.generated
     */
    private Integer hot;

    /**
     * Database Column Remarks:
     *   是不是推荐
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.recommend
     *
     * @mbg.generated
     */
    private String recommend;

    /**
     * Database Column Remarks:
     *   库存
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.count
     *
     * @mbg.generated
     */
    private Integer count;

    /**
     * Database Column Remarks:
     *   所属类别
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.typeId
     *
     * @mbg.generated
     */
    private Long typeid;

    /**
     * Database Column Remarks:
     *   商品图片id，用英文逗号隔开
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.fileIds
     *
     * @mbg.generated
     */
    private String fileids;

    /**
     * Database Column Remarks:
     *   所属卖家
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.userId
     *
     * @mbg.generated
     */
    private Long userid;

    /**
     * Database Column Remarks:
     *   所属卖家登记
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.level
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * Database Column Remarks:
     *   商品描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.id
     *
     * @return the value of goods_info.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.id
     *
     * @param id the value for goods_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.name
     *
     * @return the value of goods_info.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.name
     *
     * @param name the value for goods_info.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.price
     *
     * @return the value of goods_info.price
     *
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.price
     *
     * @param price the value for goods_info.price
     *
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.discount
     *
     * @return the value of goods_info.discount
     *
     * @mbg.generated
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.discount
     *
     * @param discount the value for goods_info.discount
     *
     * @mbg.generated
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.sales
     *
     * @return the value of goods_info.sales
     *
     * @mbg.generated
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.sales
     *
     * @param sales the value for goods_info.sales
     *
     * @mbg.generated
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.hot
     *
     * @return the value of goods_info.hot
     *
     * @mbg.generated
     */
    public Integer getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.hot
     *
     * @param hot the value for goods_info.hot
     *
     * @mbg.generated
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.recommend
     *
     * @return the value of goods_info.recommend
     *
     * @mbg.generated
     */
    public String getRecommend() {
        return recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.recommend
     *
     * @param recommend the value for goods_info.recommend
     *
     * @mbg.generated
     */
    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.count
     *
     * @return the value of goods_info.count
     *
     * @mbg.generated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.count
     *
     * @param count the value for goods_info.count
     *
     * @mbg.generated
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.typeId
     *
     * @return the value of goods_info.typeId
     *
     * @mbg.generated
     */
    public Long getTypeid() {
        return typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.typeId
     *
     * @param typeid the value for goods_info.typeId
     *
     * @mbg.generated
     */
    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.fileIds
     *
     * @return the value of goods_info.fileIds
     *
     * @mbg.generated
     */
    public String getFileids() {
        return fileids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.fileIds
     *
     * @param fileids the value for goods_info.fileIds
     *
     * @mbg.generated
     */
    public void setFileids(String fileids) {
        this.fileids = fileids == null ? null : fileids.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.userId
     *
     * @return the value of goods_info.userId
     *
     * @mbg.generated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.userId
     *
     * @param userid the value for goods_info.userId
     *
     * @mbg.generated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.level
     *
     * @return the value of goods_info.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.level
     *
     * @param level the value for goods_info.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.description
     *
     * @return the value of goods_info.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.description
     *
     * @param description the value for goods_info.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}