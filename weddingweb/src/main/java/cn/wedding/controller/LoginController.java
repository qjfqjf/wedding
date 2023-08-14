package cn.wedding.controller;


import cn.wedding.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
public class LoginController {

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

}

