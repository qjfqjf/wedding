package cn.wedding.biz;

import cn.wedding.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserBiz extends IService<User> {
    //用户注册
    User register(User user);
    //用户登录
    User login(User user);
}
