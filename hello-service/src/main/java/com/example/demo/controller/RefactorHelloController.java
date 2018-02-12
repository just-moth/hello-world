package com.example.demo.controller;

import com.example.demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @author： lxh
 * @description：
 * @created: 14:08 2018/2/3
 * @modified by:
 */
@RestController
public class RefactorHelloController implements HelloService {

    @Autowired
    DiscoveryClient discoveryClient;

    private static final Logger logger = LoggerFactory.getLogger(RefactorHelloController.class);


    @Override
    public String hello() throws InterruptedException {
        /*List<String> services = discoveryClient.getServices();
        logger.info(services.toString());*/

       /* int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);*/

        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:{},service_id:{}",instance.getHost(),instance.getServiceId());*/
        return "hello";
    }

    @Override
    public String hello1(@RequestParam("name") String name) {
        /*List<String> services = discoveryClient.getServices();
        logger.info(services.toString());*/

        //int sleepTime = new Random().nextInt(3000);
        //logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);

        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:{},service_id:{}",instance.getHost(),instance.getServiceId());*/
        return "hello : " + name;
    }

    @Override
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") String age) {
        User user = new User(name, age);

        /*List<String> services = discoveryClient.getServices();
        logger.info(services.toString());*/

        //int sleepTime = new Random().nextInt(3000);
        //logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);

        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:{},service_id:{}",instance.getHost(),instance.getServiceId());*/
        return user;
    }

    @Override
    public String hello3(@RequestBody User user) {
        /*List<String> services = discoveryClient.getServices();
        logger.info(services.toString());*/

        //int sleepTime = new Random().nextInt(3000);
        //logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);

        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:{},service_id:{}",instance.getHost(),instance.getServiceId());*/
        return "hello : " + user.getName() + ",age : " + user.getAge();
    }
}
