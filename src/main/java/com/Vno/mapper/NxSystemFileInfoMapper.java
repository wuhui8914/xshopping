package com.vno.mapper;

import com.vno.entity.GoodsInfo;
import com.vno.entity.NxSystemFileInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface NxSystemFileInfoMapper extends Mapper<NxSystemFileInfo> {

    NxSystemFileInfo selectByPrimaryId(Long id);

}