package cn.wedding.biz.impl;

import cn.wedding.biz.ImageBiz;
import cn.wedding.dao.ImageDao;
import cn.wedding.pojo.Image;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ImageBizImpl extends ServiceImpl<ImageDao, Image> implements ImageBiz {
}
