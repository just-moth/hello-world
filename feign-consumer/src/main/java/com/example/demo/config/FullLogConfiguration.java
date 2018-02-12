package com.example.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author： lxh
 * @description：
 * @created: 11:39 2018/2/5
 * @modified by:
 */
@Configuration
public class FullLogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
