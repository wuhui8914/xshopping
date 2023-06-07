package com.vno.mapper;

import com.vno.entity.AdvertiserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdvertiserInfoMapper extends Mapper<AdvertiserInfo> {

    /*根据公告标题模糊查询*/
    List<AdvertiserInfo> findByName(@Param("name") String name);
}