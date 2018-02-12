package com.example.demo.command;

import com.example.demo.entity.User;
import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

/**
 * @author： lxh
 * @description：
 * @created: 10:43 2018/1/31
 * @modified by:
 */
public class UserGetCommand extends HystrixCommand<User> {

    public final static HystrixCommandKey GETTER_COMMAND = HystrixCommandKey.Factory.asKey("UserGet");

    private RestTemplate restTemplate;
    private Long id;

    protected UserGetCommand(Setter setter,RestTemplate restTemplate,Long id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup"))
                    .andCommandKey(GETTER_COMMAND)
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserGet")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

    public static void flushCache(Long id){
        HystrixRequestCache.getInstance(GETTER_COMMAND, (HystrixConcurrencyStrategyDefault.getInstance())).clear(String.valueOf(id));
    }
}
