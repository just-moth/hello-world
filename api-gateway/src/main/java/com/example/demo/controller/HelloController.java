package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dell on 2018/2/7.
 */
@RestController
public class HelloController {
    @GetMapping("/local/hello")
    public String hello(){
        return " local hello ";
    }
}
