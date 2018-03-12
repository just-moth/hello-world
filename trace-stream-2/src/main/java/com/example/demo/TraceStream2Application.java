package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/12 15:33
 * @modified by:
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class TraceStream2Application {

    private static Logger logger = LoggerFactory.getLogger(TraceStream2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(TraceStream2Application.class,args);
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

    @GetMapping("/trace-stream-2")
    public String trace(HttpServletRequest request){
        logger.info("=====<call trace-stream-2,TraceId={},SpanId={}====="
                , request.getHeader("X-B3-TraceId")
                , request.getHeader("X-B3-SpanId"));
        return "trace-stream-2";
    }
}
