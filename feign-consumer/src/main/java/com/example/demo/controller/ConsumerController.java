package com.example.demo.controller;


import com.example.demo.dto.User;
import com.example.demo.service.HelloService;
import com.example.demo.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： lxh
 * @description：
 * @created: 18:10 2018/2/2
 * @modified by:
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @GetMapping("/feign-consumer")
    public  String helloConsumer(){
        return  helloService.hello();
    }


    @GetMapping("/feign-consumer2")
    public  String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello1("张三")).append("\n");
        sb.append(helloService.hello2("zhongwenluanma","16")).append("\n");
        sb.append(helloService.hello3(new User("王五","20"))).append("\n");
        return  sb.toString();
    }

    @GetMapping("/feign-consumer3")
    public  String helloConsumer3() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello()).append("\n");
        sb.append(refactorHelloService.hello1("张三")).append("\n");
        sb.append(refactorHelloService.hello2("zhongwenluanma","16")).append("\n");
        sb.append(refactorHelloService.hello3(new com.example.demo.dto.User("王五","20"))).append("\n");
        return  sb.toString();
    }
}
