package com.example.demo.service;

import com.example.demo.controller.*;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author： lxh
 * @description：
 * @created: 14:17 2018/2/3
 * @modified by:
 */
@FeignClient(value = "hello-service")
public interface RefactorHelloService extends com.example.demo.controller.HelloService {
}
