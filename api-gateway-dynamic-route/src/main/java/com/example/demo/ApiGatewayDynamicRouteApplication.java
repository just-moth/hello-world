package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author： lxh
 * @description：
 * @created: 16:01 2018/1/20
 * @modified by:
 */
@SpringCloudApplication
@EnableZuulProxy
public class ApiGatewayDynamicRouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayDynamicRouteApplication.class, args);
    }

    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
