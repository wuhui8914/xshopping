package com.vno.common;

/**
 * @Description: 统一返回码
 * @ClassName: ResultCode
 * @Author: dx
 * @Date: 2023/5/30 9:41
 * @Version: 1.0
 */
public enum ResultCode {
    SUCCESS("0","成功"),
    ERROR("-1","系统异常"),
    PARAM_ERROR("1001","参数异常"),
    USER_EXIST_ERROR("2001","用户已存在"),
    USER_ACCOUNT_ERROR("2002","账户或密码错误"),
    USER_NOT_EXIST_ERROR("2003","用户不存在"),
    USER_UPDATE_PWD("2004","密码重置失败"),
    USER_UPDATE_USER("2005","用户信息更新失败"),
    USER_DELETE_USER("2006","用户删除失败"),
    USER_UPDATE_ADVERTISERINFO("2007","公告信息更新失败"),
    USER_DELETE_ADVERTISERINFO("2008","公告信息删除失败"),
    USER_UPDATE_TYPEINFO("2009","商品类别更新失败"),
    USER_DELETE_TYPEINFO("2010","商品类别删除失败"),
    USER_UPDATE_GOODSINFO("2009","商品更新失败"),
    USER_DELETE_GOODSINFO("2010","商品删除失败"),
    USER_UPDATE_CARTINFO("2012","购物车商品数量更新失败");


    public String code;

    public String msg;

    ResultCode(String code,String msg){
        this.code = code;
        this.msg =msg;
    }
}
