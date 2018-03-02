package com.example.demo.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author： lxh
 * @description：
 * 捕获为处理的异常统一做一些处理,让'SendErrorFilter'可以正确的返回异常信息
 * 当时'POST'过滤器抛出的话,错误信息会让'ErrorExtFilter'返回异常信息
 * @created: 2018/2/24 15:45
 * @modified by:
 */
@Component
public class ErrorFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        log.error("this is a ErrorFilter : {}" ,throwable.getCause().getMessage());
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception", throwable.getCause());
        return null;
    }
}
