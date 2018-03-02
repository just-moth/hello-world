package com.example.demo;

import com.example.demo.filter.TestErrorAttributes;
import com.example.demo.filter.TestFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;

/**
 * @author： lxh
 * @description：
 * @created: 16:01 2018/1/20
 * @modified by:
 */
@SpringBootApplication
public class ApiGatewayExceptionApplication {

    public static void main(String[] args) {
        FilterProcessor.setProcessor(new TestFilterProcessor());
        SpringApplication.run(ApiGatewayExceptionApplication.class, args);
    }

    @Bean
    public DefaultErrorAttributes errorAttributes() {
        return new TestErrorAttributes();
    }
}
