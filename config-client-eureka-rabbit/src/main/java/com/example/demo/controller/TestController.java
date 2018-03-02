package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： lxh
 * @description：
 * @created: 2018/2/23 14:59
 * @modified by:
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String from;

    @GetMapping("/from")
    public String from(){
        return this.from;
    }
}
