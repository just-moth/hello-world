package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author： lxh
 * @description：
 * @created: 2018/2/24 11:25
 * @modified by:
 */
@ConfigurationProperties("zuul.filter")
@Data
public class FilterConfiguration {

    private String root;
    private Integer interval;
}
