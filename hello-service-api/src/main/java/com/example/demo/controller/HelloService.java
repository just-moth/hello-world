package com.example.demo.controller;

import com.example.demo.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： lxh
 * @description：
 * @created: 17:27 2018/1/20
 * @modified by:
 */
@RequestMapping("/refactor")
public interface HelloService {

    @GetMapping("/hello4")
    String hello() throws InterruptedException;

    @GetMapping("/hello5")
    String hello1(@RequestParam("name") String name);

    @GetMapping(value="/hello6")
    User hello2(@RequestHeader("name") String name, @RequestHeader("age") String age);

    @PostMapping("/hello7")
    String hello3(@RequestBody User user);
}
