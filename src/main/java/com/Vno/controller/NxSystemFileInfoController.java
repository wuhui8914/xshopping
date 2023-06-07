package com.vno.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.vno.common.Result;
import com.vno.common.ResultCode;
import com.vno.entity.NxSystemFileInfo;
import com.vno.exception.CustomException;
import com.vno.service.NxSystemFileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @Description: 文件增删改查控制器
 * @ClassName: NxSystemFileInfoController
 * @Author: dx
 * @Date: 2023/5/30 17:15
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/nxSystemFileInfo")
@Api(value = "提供文件的信息接口",tags = "商品")
@CrossOrigin
public class NxSystemFileInfoController {

    private static final String BASE_PATH = System.getProperty("user.dir")+"/src/main/resources/static/file/";

    @Resource
    private NxSystemFileInfoService nxSystemFileInfoService;

    private Logger logger = LoggerFactory.getLogger(NxSystemFileInfoController.class);


    /**
     * @description: 上传文件
     * @author: dx
     * @date: 2023/5/31 14:29
     * @param: [userInfo]
     * @return: com.vno.common.Result<com.vno.entity.goodsInfo>
     **/
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        if(originalFilename == null){
            return Result.error("1001","文件名不能为空");
        }

        if(!originalFilename.contains("png") && !originalFilename.contains("jpg") &&
                !originalFilename.contains("jpeg") && !originalFilename.contains("gif")){
            return Result.error("1002","只能上传(png/jpg/jpeg/gif)四种格式图片");
        }

        //文件名加时间戳
        String fileName =FileUtil.mainName(originalFilename)+System.currentTimeMillis()+"."+ FileUtil.extName(originalFilename);

        //文件上传
        FileUtil.writeBytes(multipartFile.getBytes(),BASE_PATH+fileName);
        //信息入库，获取文件的id
        NxSystemFileInfo nxSystemFileInfo = new NxSystemFileInfo();
        nxSystemFileInfo.setOriginname(originalFilename);
        nxSystemFileInfo.setFilename(fileName);
        NxSystemFileInfo addNxSystemFileInfo = nxSystemFileInfoService.add(nxSystemFileInfo);
        if(addNxSystemFileInfo != null){
            return Result.success(addNxSystemFileInfo);
        }
        return Result.error("1003","上传失败");

    }

    @ApiOperation("更新文件")
    @PutMapping("/update")
    public Result update(@RequestBody NxSystemFileInfo nxSystemFileInfo){
        int i = nxSystemFileInfoService.update(nxSystemFileInfo);
        if( i== 0){
            throw new CustomException(ResultCode.USER_UPDATE_GOODSINFO);
        }
        return Result.success();
    }

    @ApiOperation("删除文件")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        int i = nxSystemFileInfoService.delete(id);
        if( i== 0){
            throw new CustomException(ResultCode.USER_DELETE_GOODSINFO);
        }
        return Result.success();
    }

    @ApiOperation("根据商品文件id查询文件")
    @GetMapping("/detail/{id}")
    public Result<NxSystemFileInfo> detail(@PathVariable Long id){
        NxSystemFileInfo byId = nxSystemFileInfoService.findById(id);
        return Result.success(byId);
    }

    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        if(StrUtil.isBlank(id) || "null".endsWith(id)){
            throw new CustomException("1001","您未上传文件");
        }

        NxSystemFileInfo nxSystemFileInfo = nxSystemFileInfoService.findById(Long.parseLong(id));
        if(nxSystemFileInfo == null){
            throw new CustomException("1001","没有找到该文件");
        }

        byte[] bytes = FileUtil.readBytes(BASE_PATH + nxSystemFileInfo.getFilename());
        httpServletResponse.reset();
        // 设置httpServletResponse 的header
        httpServletResponse.addHeader("Content-Disposition",
                "attachment;filename="+ URLEncoder.encode(nxSystemFileInfo.getOriginname(),"UTF-8"));
        httpServletResponse.addHeader("Content-Length",""+bytes.length);
        OutputStream toClient = new BufferedOutputStream(httpServletResponse.getOutputStream());
        httpServletResponse.setContentType("application/octet-stream");
        toClient.write(bytes);
        toClient.flush();
        toClient.close();
    }
}
