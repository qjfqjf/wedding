package cn.wedding.biz.impl;

import cn.wedding.biz.UserBiz;
import cn.wedding.dao.UserDao;
import cn.wedding.pojo.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserBizImpl extends ServiceImpl<UserDao, User> implements UserBiz {
    //注入用户dao
    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        //1、生成主键
        String id = UUID.randomUUID().toString().replace("-", "");
        //设置主键
        user.setId(id);
        //2、对密码加密

        return null;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return null;
    }
}
