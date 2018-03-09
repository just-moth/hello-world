package com.example.demo.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.InputStream;
import java.util.Date;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/7 10:15
 * @modified by:
 */

//@EnableBinding(value = {Processor.class})
public class AppReceiver {

    private static Logger log = LoggerFactory.getLogger(AppReceiver.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        log.info("AppReceiver Received: " + payload);
        return "From Input Channel Return - " + payload;
    }
}

/*

@EnableScheduling
@EnableBinding(value = {Processor.class})
public class AppReceiver {

    private static Logger log = LoggerFactory.getLogger(AppReceiver.class);

    @ServiceActivator(inputChannel = Processor.OUTPUT,outputChannel = Processor.INPUT)
    public Object receiveFromInput(Object payload) {
        log.info("AppReceiver Received: " + payload);
        return "From Input Channel Return - " + payload;
    }
}
*/

/*
@EnableRxJavaProcessor
public class AppReceiver {

    private static Logger log = LoggerFactory.getLogger(AppReceiver.class);

    @Bean
    public RxJavaProcessor<Date,String> processor(){
        return inputStream -> inputStream.map(data -> {
            log.info("AppReceiver : " + data);
            return data;
        }).map(data -> String.valueOf("From Input Channel Return - " +data));
    }
}
*/

/*
@EnableRxJavaProcessor
public class AppReceiver {

    private static Logger log = LoggerFactory.getLogger(AppReceiver.class);

    @Bean
    public RxJavaProcessor<Date,String> processor(){
        return inputStream -> inputStream.map(data -> {
            log.info("AppReceiver : " + data);
            return data;
        }).buffer(5).map(data -> String.valueOf("From Input Channel Return - " +data));
    }
}
*/
