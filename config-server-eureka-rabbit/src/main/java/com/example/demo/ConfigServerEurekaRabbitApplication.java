package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author： lxh
 * @description：
 * @created: 16:01 2018/1/20
 * @modified by:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerEurekaRabbitApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerEurekaRabbitApplication.class, args);
    }
}
