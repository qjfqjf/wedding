package cn.wedding.controller;


import cn.wedding.biz.UserBiz;
import cn.wedding.pojo.User;
import cn.wedding.util.JwtUtil;
import cn.wedding.util.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserBiz userBiz;
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(String username, String password) {

        //避免非空
        Optional<String> nameOptional = Optional.ofNullable(username);
        Optional<String> passwordOptional = Optional.ofNullable(password);

        //构建条件构造器
        LambdaQueryWrapper<User> lambdaQueryWrapper = new QueryWrapper<User>().lambda();
        nameOptional.ifPresent(name -> {
            lambdaQueryWrapper.eq(User::getUserName,name);
            //因为加了盐，所以先通过唯一索引（用户名）来查询一下数据库中的盐值
            List<User> userlist = userBiz.list(lambdaQueryWrapper);
            System.out.println(userlist);
        });
        //passwordOptional.ifPresent(pass -> lambdaQueryWrapper.eq(User::getUserName, MD5.getSaltMD5(pass)));

        System.out.println("username:"+username+"   "+"password"+password);
        Map<String, String> map = new HashMap<>();
        if (!"tom".equals(username) || !"123".equals(password)) {
            map.put("msg", "用户名密码错误");
            return ResponseEntity.ok(map);
        }
        JwtUtil jwtUtil = new JwtUtil();
        Map<String, Object> chaim = new HashMap<>();
        chaim.put("username", username);
        String jwtToken = jwtUtil.encode(username, 60 * 60 * 1000, chaim);
        map.put("msg", "登录成功");
        map.put("token", jwtToken);
        return ResponseEntity.ok(map);
    }
    @GetMapping("/testdemo")
    public ResponseEntity<String> testdemo() {
        return ResponseEntity.ok("我爱蛋炒饭");
    }

}

