package cn.wedding.biz.impl;

import cn.wedding.biz.WedInfoBiz;
import cn.wedding.dao.WedInfoDao;
import cn.wedding.pojo.WedInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class WedInfoBizImpl extends ServiceImpl<WedInfoDao, WedInfo> implements WedInfoBiz {

}
