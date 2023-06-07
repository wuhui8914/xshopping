package com.vno.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vno.entity.TypeInfo;
import com.vno.mapper.TypeInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: 商品类别的service
 * @ClassName: TypeInfoService
 * @Author: dx
 * @Date: 2023/5/30 14:50
 * @Version: 1.0
 */
@Service
public class TypeInfoService {

    @Resource
    private TypeInfoMapper TypeInfoMapper;



    /**
     * @description: 分页查询用户列表
     * @author: dx
     * @date: 2023/5/30 17:14
     * @param: [pageNum, pageSize, name]
     * @return: com.github.pagehelper.PageInfo<com.vno.entity.UserInfo>
     **/
    public PageInfo<TypeInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<TypeInfo> list = TypeInfoMapper.findByName(name);
        return PageInfo.of(list);
    }

    /**
     * @description: 新增商品类别
     * @author: dx
     * @date: 2023/6/1 9:39
     * @param: [userInfo]
     * @return: com.vno.entity.UserInfo
     **/
    public TypeInfo add(TypeInfo TypeInfo){
        TypeInfoMapper.insertSelective(TypeInfo);
        return TypeInfo;
    }

    /**
     * @description: 修改商品类别
     * @author: dx
     * @date: 2023/6/1 9:37
     * @param: [userInfo]
     * @return: com.vno.entity.UserInfo
     **/
    public int update(TypeInfo TypeInfo){
        int i = TypeInfoMapper.updateByPrimaryKeySelective(TypeInfo);
        return i;
    }

    /**
     * @description:根据id删除商品类别
     * @author: dx
     * @date: 2023/6/1 9:50
     * @param: [id]
     * @return: int
     **/
    public int delete(Long id){
        int i = TypeInfoMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @description:根据id查询商品类别信息
     * @author: dx
     * @date: 2023/6/1 10:58
     * @param: [id]
     * @return: com.vno.entity.TypeInfo
     **/
    public TypeInfo findById(Long id){
        return TypeInfoMapper.selectByPrimaryKey(id);
    }
}
