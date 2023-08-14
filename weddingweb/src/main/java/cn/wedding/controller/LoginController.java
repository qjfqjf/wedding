package cn.wedding.controller;


import cn.wedding.biz.UserBiz;
import cn.wedding.dao.UserDao;
import cn.wedding.pojo.User;
import cn.wedding.pojo.vo.UserRegisterVo;
import cn.wedding.util.JwtUtil;
import cn.wedding.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserBiz userBiz;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(String username, String password) {

        //避免非空
        Optional<String> nameOptional = Optional.ofNullable(username);
        Optional<String> passwordOptional = Optional.ofNullable(password);

        //构建条件构造器
        LambdaQueryWrapper<User> lambdaQueryWrapper = new QueryWrapper<User>().lambda();
        AtomicBoolean isSuccess = new AtomicBoolean(false);
        nameOptional.ifPresent(name -> {
            lambdaQueryWrapper.eq(User::getUserName,name);
            //因为加了盐，所以先通过唯一索引（用户名）来查询一下数据库中的盐值
            User user = userBiz.getOne(lambdaQueryWrapper);
            Optional<String> saltOptional = Optional.ofNullable(user.getSalt());
            //用盐加密密码
            int times = 2;
            String algorithmName = "md5";
            //SimpleHash类使用md5加密算法加密两次，把盐加进去，生成新的密码
            saltOptional.ifPresent(salt -> passwordOptional.ifPresent(pass -> {
                isSuccess.set(user.getPassword().equals(new SimpleHash(algorithmName, pass, salt, times).toString()));
            }));
        });

        Map<String, String> map = new HashMap<>();
        System.out.println(isSuccess.get());
        if (!isSuccess.get()) {
            map.put("msg", "用户名密码错误");
            return ResponseEntity.ok(map);
        }
        JwtUtil jwtUtil = new JwtUtil();
        Map<String, Object> chaim = new HashMap<>();
        chaim.put("username", username);
        String jwtToken = jwtUtil.encode(username, 60 * 60 * 1000, chaim);
        redisUtil.set("token",jwtToken,(long)60 * 60 * 1000);
        //测试
        //System.out.println(redisUtil.get("token"));
        map.put("msg", "登录成功");
        map.put("token", jwtToken);
        map.put("code","20000");
        map.put("username",username);
        return ResponseEntity.ok(map);
    }
    @GetMapping("/testdemo")
    public ResponseEntity<String> testdemo() {
        return ResponseEntity.ok("我爱蛋炒饭");
    }

    //shiro加持的注册方法
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserRegisterVo userRegisterVo) {
        //先取得用户的名字，密码，这两个是画面传进来的参数，放在User里
        String name = HtmlUtils.htmlEscape(userRegisterVo.getUsername());
        Map<String, String> map = new HashMap<>();
        //判断用户名是否已经存在，如果已存在，那就返回错误信息
        User user1 = userDao.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, name));
        if(user1!=null){
            map.put("msg", "用户名已经注册！！！");
            return ResponseEntity.ok(map);
        }
        //SecureRandomNumberGenerator类随机方法创建盐，进行两次加密，加密算法用md5
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        //SimpleHash类使用md5加密算法加密两次，把盐加进去，生成新的密码
        String encodedPassword = new SimpleHash(algorithmName, userRegisterVo.getPassword(), salt, times).toString();
        //把盐和生成的加密密码，存到数据库里
        User user = new User();
        user.setUserName(name);
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userDao.insert(user);
        map.put("msg", "注册成功！！！");
        return ResponseEntity.ok(map);
    }


}

