package com.vno.mapper;

import com.vno.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {

    /*根据用户名查询*/
    List<UserInfo> findByName(@Param("name") String name);

    /*用户唯一性判断*/
    int chckRepeat(@Param("column")String  column,@Param("value")String value);
}