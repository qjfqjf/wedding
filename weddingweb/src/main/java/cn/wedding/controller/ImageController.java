package cn.wedding.controller;

import cn.wedding.biz.ImageBiz;
import cn.wedding.dao.ImageDao;
import cn.wedding.exception.SysException;
import cn.wedding.pojo.Image;
import cn.wedding.pojo.constant.SysCode;
import cn.wedding.pojo.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api("ImageController")
@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ImageBiz imageBiz;
    @Autowired
    private ImageDao imageDao;

    @GetMapping("/{weddingid}")
    public String queryByWeddingId(@PathVariable("weddingid")String weddingid){
        try {
            //构建查询条件对象
            QueryWrapper<Image> wrapper = new QueryWrapper<>();
            //添加查询条件
            wrapper.eq("wedding_id", weddingid);
            //执行业务对象的查询方法
            List<Image> list = imageBiz.list(wrapper);
            //创建响应对象
            ResultVO<List<Image>> rsvo = new ResultVO<>();
            //初始化响应对象
            rsvo.success(SysCode.COMMON_SUCCESS,"查询成功",list);
            String jsonStr = mapper.writeValueAsString(rsvo);
            return jsonStr;
        } catch (JsonProcessingException e) {
            throw new SysException(SysCode.COMMON_FAIL,e.getMessage());
        }
    }


    @ApiOperation("图片上传")
    @PostMapping
    public String upload(@RequestParam("file")MultipartFile file)throws Exception{
        ResultVO<String> resultVO = null;

        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //生成随机文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newFileName = uuid+originalFilename;
        String datePath = new Date().toString();

        return mapper.writeValueAsString(resultVO);
    }
}
