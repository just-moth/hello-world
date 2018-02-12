package com.example.demo.service;

import com.example.demo.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author： lxh
 * @description：
 * @created: 10:10 2018/2/5
 * @modified by:
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello1(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") String age) {
        return new User("error","-1");
    }

    @Override
    public String hello3(@RequestBody User user) {
        return "error";
    }
}
