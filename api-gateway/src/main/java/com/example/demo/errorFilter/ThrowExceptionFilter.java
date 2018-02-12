package com.example.demo.errorFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author： lxh
 * @description：
 * @created: 2018/2/8 15:01
 * @modified by:
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {

    private final static Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext cxt = RequestContext.getCurrentContext();
            logger.info("this is a pre filter , it will throw RuntimeException");
            doSomething();
            return null;
    }

    private void doSomething(){
        throw new RuntimeException("exit some error...");
    }
}
