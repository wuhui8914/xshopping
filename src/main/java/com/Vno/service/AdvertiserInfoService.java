package com.vno.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vno.entity.AdvertiserInfo;
import com.vno.mapper.AdvertiserInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: 公告相关的service
 * @ClassName: UserInfoService
 * @Author: dx
 * @Date: 2023/5/30 14:50
 * @Version: 1.0
 */
@Service
public class AdvertiserInfoService {

    @Resource
    private AdvertiserInfoMapper advertiserInfoMapper;



    /**
     * @description: 分页查询用户列表
     * @author: dx
     * @date: 2023/5/30 17:14
     * @param: [pageNum, pageSize, name]
     * @return: com.github.pagehelper.PageInfo<com.vno.entity.UserInfo>
     **/
    public PageInfo<AdvertiserInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<AdvertiserInfo> list = advertiserInfoMapper.findByName(name);
        return PageInfo.of(list);
    }

    /**
     * @description: 新增公告
     * @author: dx
     * @date: 2023/6/1 9:39
     * @param: [userInfo]
     * @return: com.vno.entity.UserInfo
     **/
    public AdvertiserInfo add(AdvertiserInfo advertiserInfo){
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        advertiserInfo.setTime(format);
        advertiserInfoMapper.insertSelective(advertiserInfo);
        return advertiserInfo;
    }

    /**
     * @description: 修改公告
     * @author: dx
     * @date: 2023/6/1 9:37
     * @param: [userInfo]
     * @return: com.vno.entity.UserInfo
     **/
    public int update(AdvertiserInfo advertiserInfo){
        int i = advertiserInfoMapper.updateByPrimaryKeySelective(advertiserInfo);
        return i;
    }

    /**
     * @description:根据id删除公告
     * @author: dx
     * @date: 2023/6/1 9:50
     * @param: [id]
     * @return: int
     **/
    public int delete(Long id){
        int i = advertiserInfoMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @description:根据id查询公告信息
     * @author: dx
     * @date: 2023/6/1 10:58
     * @param: [id]
     * @return: com.vno.entity.AdvertiserInfo
     **/
    public AdvertiserInfo findById(Long id){
        return advertiserInfoMapper.selectByPrimaryKey(id);
    }
}
