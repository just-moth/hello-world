package com.example.demo.command;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.List;

/**
 * @author： lxh
 * @description：
 * @created: 15:45 2018/1/31
 * @modified by:
 */
public class UserBatchCommand extends HystrixCommand<List<User>> {
    UserService userService;
    List<Long> userIds;

    protected UserBatchCommand(UserService userService,List<Long> userIds) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userServiceCommand")));
        this.userService = userService;
        this.userIds = userIds;
    }

    @Override
    protected List<User> run() throws Exception {
        return userService.findALl(userIds);
    }
}
