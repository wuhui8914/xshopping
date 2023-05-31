package com.vno.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vno.common.ResultCode;
import com.vno.entity.UserInfo;
import com.vno.exception.CustomException;
import com.vno.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户相关的service
 * @ClassName: UserInfoService
 * @Author: dx
 * @Date: 2023/5/30 14:50
 * @Version: 1.0
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * @description:登录
     * @author: dx
     * @date: 2023/5/30 15:59
     * @param: [name, pwd]
     * @return: com.vno.entity.UserInfo
     **/
    public UserInfo login(String name,String pwd){
        //判断数据库里是否有该用户
        List<UserInfo> list = userInfoMapper.findByName(name);
        if(CollectionUtil.isEmpty(list)){
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }

        //判断密码是否正确
        if(!SecureUtil.md5(pwd).equals(list.get(0).getPassword())){
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return list.get(0);
    }

    /**
     * @description: 重置密码
     * @author: dx
     * @date: 2023/5/30 15:59
     * @param: [name]
     * @return: com.vno.entity.UserInfo
     **/
    public UserInfo resetPwd(String name){
        List<UserInfo> list = userInfoMapper.findByName(name);
        if(CollectionUtil.isEmpty(list)){
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }

        list.get(0).setPassword(SecureUtil.md5("123456"));

        int i = userInfoMapper.updateByPrimaryKeySelective(list.get(0));

        if(i == 0){
            throw new CustomException(ResultCode.USER_UPDATE_PWD);
        }
        return list.get(0);
    }

    /**
     * @description: 分页查询用户列表
     * @author: dx
     * @date: 2023/5/30 17:14
     * @param: [pageNum, pageSize, name]
     * @return: com.github.pagehelper.PageInfo<com.vno.entity.UserInfo>
     **/
    public PageInfo<UserInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> list = userInfoMapper.findByName(name);
        return PageInfo.of(list);
    }

    public UserInfo add(UserInfo userInfo){
        int count = userInfoMapper.chckRepeat("name",userInfo.getName());
        if (count >0){
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }

        if (StrUtil.isBlank(userInfo.getPassword())){
            //默认密码123456
            userInfo.setPassword(SecureUtil.md5("123456"));
        }else {
            userInfo.setPassword(SecureUtil.md5(userInfo.getPassword()));
        }

        //设置新增用户是买家
        userInfo.setLevel(3);
        userInfoMapper.insertSelective(userInfo);
        return userInfo;
    }
}
