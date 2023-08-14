package cn.wedding.biz.impl;

import cn.wedding.dao.JiGouDao;
import cn.wedding.pojo.JiGou;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class JiGouBizImpl extends ServiceImpl<JiGouDao, JiGou> implements cn.wedding.biz.JiGouBiz {
}
