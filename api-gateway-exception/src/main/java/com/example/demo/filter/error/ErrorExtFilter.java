package com.example.demo.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @author： lxh
 * @description：从POST抛出的异常,使用该过滤器返回错误信息
 * @created: 2018/2/24 15:45
 * @modified by:
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {
    private static final Logger log = LoggerFactory.getLogger(ErrorExtFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter zuulFilter = (ZuulFilter) ctx.get("failed.filter");
        if(zuulFilter != null && zuulFilter.filterType().equals("post")){
            return true;
        }
        return false;
    }
}
