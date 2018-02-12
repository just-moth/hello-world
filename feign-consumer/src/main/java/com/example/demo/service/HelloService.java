package com.example.demo.service;

import com.example.demo.config.FullLogConfiguration;
import com.example.demo.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author： lxh
 * @description：
 * @created: 18:07 2018/2/2
 * @modified by:
 */
//@FeignClient(value= "hello-service")
@FeignClient(name= "HELLO-SERVICE",fallback = HelloServiceFallback.class,configuration = FullLogConfiguration.class)
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello1(@RequestParam("name") String name);

    @GetMapping(value="/hello2")
    User hello2(@RequestHeader("name") String name, @RequestHeader("age") String age);

    @PostMapping("/hello3")
    String hello3(@RequestBody User user);
}
