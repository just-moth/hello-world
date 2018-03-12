package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： lxh
 * @description：
 * @created: 16:01 2018/1/20
 * @modified by:
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class Trace2Application {

    private static Logger logger = LoggerFactory.getLogger(Trace2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }

    @GetMapping(value ="/trace-2")
    public String trace(HttpServletRequest request){
        logger.info("====== call trace-2 ======");
        logger.info("TraceId : {};" , request.getHeader("X-B3-TraceId"));
        logger.info("SpanId : {};" , request.getHeader("X-B3-SpanId"));
        return "trace";
    }
}
