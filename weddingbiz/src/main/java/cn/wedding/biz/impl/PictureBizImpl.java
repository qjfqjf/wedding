package cn.wedding.biz.impl;

import cn.wedding.biz.PictureBiz;
import cn.wedding.dao.PictureDao;
import cn.wedding.pojo.Picture;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PictureBizImpl extends ServiceImpl<PictureDao, Picture> implements PictureBiz {
}
