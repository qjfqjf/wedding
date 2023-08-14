package cn.wedding.controller;

import cn.wedding.biz.WedInfoBiz;
import cn.wedding.exception.SysException;
import cn.wedding.pojo.WedInfo;
import cn.wedding.pojo.constant.SysCode;
import cn.wedding.pojo.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wedInfo")
public class WedInfoController {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private WedInfoBiz wedInfoBiz;

    //查询真实婚礼资讯：老师
    @ApiOperation("查询真实婚礼资讯")
    @GetMapping("/real")
    public String getRealWeddingInfo(){
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","真实婚礼");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1,4);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page,wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询真实婚礼资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询真实婚礼资讯失败！");
        }
    }


    //查询最新资讯：老师
    @GetMapping("/new")
    public String getNewInfo(){
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","最新资讯");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1,5);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page,wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询最新资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询最新资讯失败！");
        }
    }

    @ApiOperation("查询婚礼攻略资讯")
    @GetMapping("/skill")
    public String getSkillInfo(){
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","婚礼攻略");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1,4);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page,wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询婚礼攻略资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询婚礼攻略资讯失败！");
        }
    }

    //查询风尚大片资讯：杨合军
    @ApiOperation("查询风尚大片资讯")
    @GetMapping("/fashoon")
    public String getFashoonInfo(){
        try {
            //构建查询对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","风尚大片");
            //构建分页对象
            Page<WedInfo> page = new Page<>();
            page.setCurrent(1);
            page.setSize(4);
            //执行
            List<WedInfo> records = wedInfoBiz.page(page).getRecords();
            //执行wedInfoBiz
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询风尚大片资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            throw new SysException(SysCode.COMMON_FAIL,"查询风尚大片资讯失败");
        }
    }

    //查询人物观点资讯：李鹏飞
    @ApiOperation("查询人物观点资讯")
    @GetMapping("/view")
    public String getPersonViewInfo(){
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","人物观点");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1,4);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page,wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询真实婚礼资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询真实婚礼资讯失败！");
        }
    }

    //查询专题策划资讯：李鹏飞
    @ApiOperation("查询专题策划资讯")
    @GetMapping("/Subject")
    public String getSubjectInfo(){
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","专题策划");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1,8);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page,wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询专题策划资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询专题策划资讯失败！");
        }
    }


    //查询行业快报资讯：张霆辉
    @ApiOperation("查询行业快报资讯")
    @GetMapping("/industry")
    public String getIndustryInfo(){
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type","行业快报");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1,4);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page,wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS,"查询行业快报资讯成功",records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询行业快报资讯失败！");
        }
    }

    //查询风尚活动资讯:陈海东
    @ApiOperation("查询风尚活动资讯")
    @GetMapping("/activity")
    public String getActivityInfo() {
        try {
            //构建查询条件对象
            QueryWrapper<WedInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("info_type", "风尚活动");
            //构建分页对象
            Page<WedInfo> page = new Page<>(1, 4);

            //执行wedInfoBiz查询
            List<WedInfo> records = wedInfoBiz.page(page, wrapper).getRecords();
            //构建响应对象
            ResultVO<List<WedInfo>> vo = new ResultVO<>();
            vo.success(SysCode.COMMON_SUCCESS, "查询风尚活动资讯成功", records);
            //将vo转化json
            String json = mapper.writeValueAsString(vo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SysException(SysCode.COMMON_FAIL, "查询风尚活动资讯失败！");
        }
    }
}
