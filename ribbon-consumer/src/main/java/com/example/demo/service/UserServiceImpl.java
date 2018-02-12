package com.example.demo.service;

import com.example.demo.entity.User;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author： lxh
 * @description：
 * @created: 15:38 2018/1/31
 * @modified by:
 */
@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User find(Long id) {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
    }

    @Override
    public List<User> findALl(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}",List.class, StringUtils.join(ids,','));
    }

    @HystrixCollapser(batchMethod = "findList",collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "100")
    })
    public  User findOne(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
    }

    @HystrixCommand
    public List<User> findList(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}",List.class, StringUtils.join(ids,','));
    }
}
