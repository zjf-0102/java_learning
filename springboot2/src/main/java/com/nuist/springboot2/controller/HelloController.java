package com.nuist.springboot2.controller;

import com.nuist.springboot2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//这个注解标识返回的是ResponseBody，不要解析成页面
public class HelloController {

    @Autowired
    private User user;
    
    @RequestMapping("/hello")
    public User test(){
        return user;
    }

}
