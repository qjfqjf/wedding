package cn.wedding.biz.impl;

import cn.wedding.biz.PictureTypeBiz;
import cn.wedding.dao.PictureTypeDao;
import cn.wedding.pojo.PictureType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PictureTypeBizImpl extends ServiceImpl<PictureTypeDao, PictureType> implements PictureTypeBiz {
}
