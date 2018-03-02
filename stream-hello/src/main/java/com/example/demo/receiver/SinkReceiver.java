package com.example.demo.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/1 16:53
 * @modified by:
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static final Logger log = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        log.info("Received: " + payload);
    }
}
