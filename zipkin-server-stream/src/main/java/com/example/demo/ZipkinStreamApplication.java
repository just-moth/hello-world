package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author： lxh
 * @description：
 * @created: 16:01 2018/1/20
 * @modified by:
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinStreamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStreamApplication.class, args);
    }
}
