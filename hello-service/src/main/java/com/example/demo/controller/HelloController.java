package com.example.demo.controller;

import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author： lxh
 * @description：
 * @created: 17:27 2018/1/20
 * @modified by:
 */
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        /*List<String> services = discoveryClient.getServices();
        logger.info(services.toString());*/

        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);

        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:{},service_id:{}",instance.getHost(),instance.getServiceId());*/
        return "hello";
    }

    @GetMapping("/hello1")
    public String hello1(@RequestParam String name) throws InterruptedException {
        /*List<String> services = discoveryClient.getServices();
        logger.info(services.toString());*/

        //int sleepTime = new Random().nextInt(3000);
        //logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);

        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:{},service_id:{}",instance.getHost(),instance.getServiceId());*/
        return "hello : " + name;
    }


    @GetMapping(value = "/hello2")
    public User hello2(@RequestHeader String name,@RequestHeader String age) throws InterruptedException {

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


    @PostMapping("/hello3")
    public String hello3(@RequestBody User user)throws InterruptedException{
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
