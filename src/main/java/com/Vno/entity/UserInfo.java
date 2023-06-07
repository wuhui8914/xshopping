package com.vno.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *   用户信息表
 */
@Table(name = "user_info")
public class UserInfo {
    /**
     *   主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *   姓名
     */
    private String name;

    /**
     *   密码
     */
    private String password;

    /**
     *   昵称
     */
    private String nickname;

    /**
     *   性别
     */
    private String sex;

    /**
     *   年龄
     */
    private Integer age;

    /**
     *   生日
     */
    private String birthday;

    /**
     *   手机号
     */
    private String phone;

    /**
     *   地址
     */
    private String address;

    /**
     *   邮编
     */
    private String code;

    /**
     *   电子邮箱
     */
    private String email;

    /**
     *   身份证
     */
    private Integer cardid;

    /**
     *   权限登记（1管理员 2卖家 3买家）
     */
    private Integer level;

    /**
     *   余额
     */
    private Double account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }
}