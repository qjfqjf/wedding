package cn.wedding.controller;


import cn.wedding.dao.UserDao;
import cn.wedding.pojo.User;
import cn.wedding.util.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(String username, String password) {

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

    //shiro加持的注册方法
    @PostMapping("/register")
    public ResponseEntity<String> register(String username,String password) {
        //先取得用户的名字，密码，这两个是画面传进来的参数，放在User里
        String name = HtmlUtils.htmlEscape(username);

        //判断用户名是否已经存在，如果已存在，那就返回错误信息
        User user1 = userDao.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, name));
        if(user1!=null){
            String message ="用户名已经被使用,不能使用";
            return ResponseEntity.ok(message);
        }
        //SecureRandomNumberGenerator类随机方法创建盐，进行两次加密，加密算法用md5
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";

        //SimpleHash类使用md5加密算法加密两次，把盐加进去，生成新的密码
        String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();

        //把盐和生成的加密密码，存到数据库里
        User user = new User();
        user.setUserName(name);
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userDao.insert(user);

        return ResponseEntity.ok("成功！！");
    }


}

