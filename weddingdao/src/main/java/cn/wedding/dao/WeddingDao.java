package cn.wedding.dao;

import cn.wedding.pojo.Wedding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeddingDao extends BaseMapper<Wedding> {
}
