package com.example.demo.filter.post;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author： lxh
 * @description：
 * @created: 2018/2/24 15:42
 * @modified by:
 */
@Component
public class ThrowExceptionPostFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(ThrowExceptionPostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("This is a post filter, it will throw a RuntimeException");
        doSomething();
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }
}
