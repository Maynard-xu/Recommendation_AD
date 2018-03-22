package com.xujin.ad_sender.controller;

import com.xujin.ad_sender.entity.RegisterEntity;
import com.xujin.ad_sender.entity.UserEntity;
import com.xujin.ad_sender.service.RegisterService;
import com.xujin.ad_sender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* Description:
 * \* User: xujin
 * \* Date: 2018/3/16
 * \* Time: 21:14
 * \
 */
@Controller
public class LoginController {
    private final RegisterService registerService;
    private final UserService userService;

    @Autowired
    public LoginController(RegisterService registerService, UserService userService) {
        this.registerService = registerService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "ad_login";
    }

    @GetMapping("/ad_register")
    public String register() {
        return "ad_register";
    }

    @GetMapping("/ad_index")
    public String index() {
        return "ad_index";
    }

    @GetMapping("/ad_dsp_index")
    public String ad_dsp_index() {
        return "ad_dsp_index";
    }


    @ResponseBody
    @PostMapping("/register")
    public Map<String, Object> register(RegisterEntity registerEntity) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(registerEntity.toString());
        if (registerEntity != null) {
            registerService.register(registerEntity);
            map.put("success", true);
            map.put("message", "register successful");
            map.put("code", "200");
        } else {
            map.put("success", false);
            map.put("message", "register failed!");
            map.put("code", "505");
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(String userName, String password) {
        System.out.println(userName + password);
        Map<String, Object> map = new HashMap<>();
        UserEntity user = userService.searchUserByName(userName);
        System.out.println(user.getUserName() + user.getPassWord());
        if (user != null) {
            if (password.equals(user.getPassWord())) {
                map.put("success", true);
                map.put("message", "login in successful");
                map.put("code", "200");
                return map;
            } else {
                map.put("success", false);
                map.put("message", "Username or password false");
                map.put("code", "403");
                return map;
            }
        } else {
            map.put("success", false);
            map.put("message", "User not exist!");
            map.put("code", "404");
            return map;
        }
    }
}