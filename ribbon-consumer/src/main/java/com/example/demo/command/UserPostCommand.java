package com.example.demo.command;

import com.example.demo.entity.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.springframework.web.client.RestTemplate;

/**
 * @author： lxh
 * @description：
 * @created: 10:43 2018/1/31
 * @modified by:
 */
public class UserPostCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private User user;

    protected UserPostCommand(Setter setter,RestTemplate restTemplate,User user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("UserPost"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPost")));
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @Override
    protected User run() throws Exception {
        User r = restTemplate.postForObject("httpL//USER-SERVICE/user",user,User.class);
        UserGetCommand.flushCache(r.getId());
        return r;
    }
}
