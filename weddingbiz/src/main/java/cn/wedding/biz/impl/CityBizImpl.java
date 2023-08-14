package cn.wedding.biz.impl;

import cn.wedding.biz.CityBiz;
import cn.wedding.dao.CityDao;
import cn.wedding.pojo.City;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CityBizImpl extends ServiceImpl<CityDao,City> implements CityBiz {
}
