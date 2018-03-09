package com.example.demo.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 15:06
 * @modified by:
 */
@EnableBinding(value = {Sink.class})
public class SinkReceiver {
    private static Logger log = LoggerFactory.getLogger(SinkReceiver.class);

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload){
        log.info("Received : " + payload);
    }
}
