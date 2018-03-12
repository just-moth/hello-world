package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/12 15:28
 * @modified by:
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class TraceStream1Application {

    private static Logger logger = LoggerFactory.getLogger(TraceStream1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(TraceStream1Application.class,args);
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/trace-stream-1")
    public String trace(){
        return restTemplate().getForEntity("http://trace-stream-2/trace-stream-2",String.class).getBody();
    }
}
