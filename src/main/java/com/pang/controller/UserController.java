package com.pang.controller;


import com.pang.entity.User;
import com.pang.service.UserService;
import com.pang.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            //生成JWT的令牌
            payload.put("id", userDB.getId());
            payload.put("username", userDB.getUsername());
            String token = JWTUtils.getToken(payload);
            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token", token);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }


    @PostMapping("/user/test")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        //业务代码
        map.put("state", true);
        map.put("msg", "请求成功");
        return map;
    }


}
