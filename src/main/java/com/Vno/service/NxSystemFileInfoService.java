package com.vno.service;

import com.vno.entity.NxSystemFileInfo;
import com.vno.mapper.NxSystemFileInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 文件的的service
 * @ClassName: NxSystemFileInfoService
 * @Author: dx
 * @Date: 2023/5/30 14:50
 * @Version: 1.0
 */
@Service
public class NxSystemFileInfoService {

    @Resource
    private NxSystemFileInfoMapper nxSystemFileInfoMapper;


    /**
     * @description: 新增文件
     * @author: dx
     * @date: 2023/6/1 9:39
     * @param: [userInfo]
     * @return: com.vno.entity.nxSystemFileInfo
     **/
    public NxSystemFileInfo add(NxSystemFileInfo nxSystemFileInfo){
        nxSystemFileInfoMapper.insertSelective(nxSystemFileInfo);
        return nxSystemFileInfo;
    }

    /**
     * @description: 修改文件
     * @author: dx
     * @date: 2023/6/1 9:37
     * @param: [userInfo]
     * @return: com.vno.entity.nxSystemFileInfo
     **/
    public int update(NxSystemFileInfo nxSystemFileInfo){
        int i = nxSystemFileInfoMapper.updateByPrimaryKeySelective(nxSystemFileInfo);
        return i;
    }

    /**
     * @description:根据id删除商品
     * @author: dx
     * @date: 2023/6/1 9:50
     * @param: [id]
     * @return: int
     **/
    public int delete(Long id){
        int i = nxSystemFileInfoMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @description:根据id查询文件
     * @author: dx
     * @date: 2023/6/1 10:58
     * @param: [id]
     * @return: com.vno.entity.GoodsInfo
     **/
    public NxSystemFileInfo findById(Long id){
        return  nxSystemFileInfoMapper.selectByPrimaryId(id);
    }
}
