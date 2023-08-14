package cn.wedding.biz.impl;

import cn.wedding.biz.VideoBiz;
import cn.wedding.dao.VideoDao;
import cn.wedding.pojo.Video;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class VideoBizImpl extends ServiceImpl<VideoDao, Video> implements VideoBiz {
}
