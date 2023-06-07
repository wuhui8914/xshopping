package com.vno.service;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vno.entity.GoodsInfo;
import com.vno.mapper.GoodsInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 商品的service
 * @ClassName: GoodsInfoService
 * @Author: dx
 * @Date: 2023/5/30 14:50
 * @Version: 1.0
 */
@Service
public class GoodsInfoService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;



    /**
     * @description: 分页查询商品列表
     * @author: dx
     * @date: 2023/5/30 17:14
     * @param: [pageNum, pageSize, name]
     * @return: com.github.pagehelper.PageInfo<com.vno.entity.GoodsInfo>
     **/
    public PageInfo<GoodsInfo> findPage(Integer pageNum, Integer pageSize, String name){
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findByName(name,null);
        return PageInfo.of(list);
    }

    /**
     * @description: 新增商品
     * @author: dx
     * @date: 2023/6/1 9:39
     * @param: [userInfo]
     * @return: com.vno.entity.GoodsInfo
     **/
    public GoodsInfo add(GoodsInfo goodsInfo){
        converFileListTOFiles(goodsInfo);
        goodsInfoMapper.insertSelective(goodsInfo);
        return goodsInfo;
    }

    /**
     * @description: 修改商品
     * @author: dx
     * @date: 2023/6/1 9:37
     * @param: [userInfo]
     * @return: com.vno.entity.GoodsInfo
     **/
    public int update(GoodsInfo goodsInfo){
        converFileListTOFiles(goodsInfo);
        int i = goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
        return i;
    }

    /**
     * @description:页面传来的文件列表转换成以逗号隔开的ID列表
     * @author: dx
     * @date: 2023/6/2 16:25
     * @param:
     * @return:
     **/

    private void converFileListTOFiles(GoodsInfo goodsInfo){
        List<Long> fileList = goodsInfo.getFileList();
        if(!CollectionUtil.isEmpty(fileList)){
            goodsInfo.setFileids(fileList.toString());
        }
    }

    /**
     * @description:根据id删除商品
     * @author: dx
     * @date: 2023/6/1 9:50
     * @param: [id]
     * @return: int
     **/
    public int delete(Long id){
        int i = goodsInfoMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * @description:根据id查询商品信息
     * @author: dx
     * @date: 2023/6/1 10:58
     * @param: [id]
     * @return: com.vno.entity.GoodsInfo
     **/
    public GoodsInfo findById(Integer id){
        List<GoodsInfo> list = goodsInfoMapper.findByName(null,id);
        if(list == null || list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    /**
     * @description:查询推荐商品
     * @author: dx
     * @date: 2023/6/5 16:52
     * @param: [pageNum, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.vno.entity.GoodsInfo>
     **/
    public PageInfo<GoodsInfo> findRecommendGoods(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findRecommendGoods();
        return PageInfo.of(list);
    }

    /**
     * @description:查询热卖商品
     * @author: dx
     * @date: 2023/6/5 16:52
     * @param: [pageNum, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.vno.entity.GoodsInfo>
     **/
    public PageInfo<GoodsInfo> findHotSalesGoods(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findHotSalesGoods();
        return PageInfo.of(list);
    }
}
