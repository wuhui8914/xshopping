package com.vno.entity;

import javax.persistence.*;
import java.util.List;

/**
 *   商品订单表
 */
@Table(name = "order_info")
public class OrderInfo {
    /**
     *   主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *   订单ID
     */
    @Column(name = "orderId")
    private String orderid;

    /**
     *   总价格
     */
    @Column(name = "totaPrice")
    private Double totaprice;

    /**
     *   所属用户
     */
    @Column(name = "userId")
    private Long userid;

    /**
     *   用户等级
     */
    @Column(name = "level")
    private Integer level;

    /**
     *   联系地址
     */
    @Column(name = "linkAddress")
    private String linkaddress;

    /**
     *   联系电话
     */
    @Column(name = "linkPhone")
    private String linkphone;

    /**
     *   联系人
     */
    @Column(name = "linkMan")
    private String linkman;

    /**
     *   创建时间
     */
    @Column(name = "createTime")
    private String createtime;

    /**
     *   订单状态
     */
    @Column(name = "status")
    private String state;

    @Transient
    private  UserInfo userInfo;

    @Transient
    private List<GoodsInfo> goodsInfoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Double getTotaprice() {
        return totaprice;
    }

    public void setTotaprice(Double totaprice) {
        this.totaprice = totaprice;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLinkaddress() {
        return linkaddress;
    }

    public void setLinkaddress(String linkaddress) {
        this.linkaddress = linkaddress == null ? null : linkaddress.trim();
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }
}