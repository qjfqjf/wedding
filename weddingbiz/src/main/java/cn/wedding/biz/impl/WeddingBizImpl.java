package cn.wedding.biz.impl;

import cn.wedding.biz.WeddingBiz;
import cn.wedding.dao.WeddingDao;
import cn.wedding.pojo.Wedding;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WeddingBizImpl extends ServiceImpl<WeddingDao, Wedding>implements WeddingBiz {
}
