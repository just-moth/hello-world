package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author： lxh
 * @description：
 * @created: 16:01 2018/1/20
 * @modified by:
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineamqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineamqpApplication.class, args);
    }
}
