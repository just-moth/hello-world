package com.example.demo.service;

import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

/**
 * @author： lxh
 * @description：
 * @created: 17:56 2018/1/26
 * @modified by:
 */
@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloOther")
    public String helloConsumer(){
        Long start = System.currentTimeMillis();
        String resut = restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        Long end = System.currentTimeMillis();

        logger.info("用时:{}" , end);

        return resut;
    }

    @HystrixCommand(fallbackMethod = "helloOther")
    public String helloConsumer2(){
        Long start = System.currentTimeMillis();
        String resut = restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        Long end = System.currentTimeMillis();

        logger.info("用时:{}" , end);

        return resut;
    }

    public String helloOther(){
        return "error:internet exception";
    }


    //同步发射一次
    @HystrixCommand(fallbackMethod = "defaultUser")
    public User getUserById(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
    }
    @HystrixCommand(fallbackMethod = "defaultUserSec")
    public User defaultUser(Long id) {
        return new User();
    }
    public User defaultUserSec(Long id){
        return new User();
    }

    //同异步发射一次
    @HystrixCommand
    public Future<User> getUserByIdAsync(final String id){
        return new AsyncResult<User>(){
            @Override
            public User invoke(){
                return restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
            }
        };
    }

    //hot observable发射多次
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER)
    public Observable<User> getUserByIdHot(final String id){
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                try{
                    if(!subscriber.isUnsubscribed()){
                        User user = restTemplate.getForObject("http://HELLO-SERVICE/hello",User.class,id);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }

    //cold observable发射多次
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY)
    public Observable<User> getUserByIdCold(final String id){
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                try{
                    if(!subscriber.isUnsubscribed()){
                        User user = restTemplate.getForObject("http://HELLO-SERVICE/hello",User.class,id);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }

    //忽略异常与捕捉异常
    @HystrixCommand(fallbackMethod = "defaultUser",
            ignoreExceptions = {HystrixBadRequestException.class})
    public User getUserByIdIgnoreE(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}",User.class,id);
    }
    public User defaultUserCacheE(Long id,Throwable e) {
        assert"getUserId command failed".equals(e.getMessage());
        return new User();
    }

    //设置命令名,分组名,县城名
    @HystrixCommand(commandKey = "getUserById",
                    groupKey = "UserGroup",
                    threadPoolKey = "getUserByIdThread")
    public User getUserByIdSetName(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}",User.class,id);
    }

    //设置缓存
    @HystrixCommand
    @CacheResult
    public User getUserByIdCache(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}",User.class,id);
    }

    //设置缓存key1
    @HystrixCommand
    @CacheResult(cacheKeyMethod = "getUserByIdCacheKeyMethod")
    public User getUserByIdCacheKey1(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}",User.class,id);
    }
    private  Long getUserByIdCacheKeyMethod(Long id){
        return  id;
    }

    //设置缓存key2-1
    @HystrixCommand
    @CacheResult
    public User getUserByIdCacheKey21(@CacheKey("id") Long id){
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}",User.class,id);
    }

    //设置缓存key2-12
    @HystrixCommand
    @CacheResult
    public User getUserByIdCacheKey22(@CacheKey("id") User user){
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}",User.class,user.getId());
    }

    //缓存清理
    @CacheRemove(commandKey = "getUserByIdCacheKey21")
    @HystrixCommand
    public void update(@CacheKey("id") User user){
        restTemplate.postForObject("http://USER-SERVICE/user",user,User.class);
    }



}
