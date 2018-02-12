package com.example.demo.collapser;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author： lxh
 * @description：
 * @created: 15:54 2018/1/31
 * @modified by:
 */
public class UserCollapserCommand extends HystrixCollapser<List<User>,User,Long> {

    private UserService userService;
    private Long userId;

    public UserCollapserCommand(UserService userService, Long userId) {
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("userCollapseCommand"))
                    .andCollapserPropertiesDefaults(
                            HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)
                    ));
        this.userService = userService;
        this.userId = userId;
    }

    @Override
    public Long getRequestArgument() {
        return userId;
    }

    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        List<Long> userIds = new ArrayList<>(collapsedRequests.size());
        userIds.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return null;
    }

    @Override
    protected void mapResponseToRequests(List<User> batchResponse, Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        int count = 0;
        for (CollapsedRequest<User,Long> collapsedRequest: collapsedRequests){
            User user = batchResponse.get(count++);
            collapsedRequest.setResponse(user);
        }
    }
}
