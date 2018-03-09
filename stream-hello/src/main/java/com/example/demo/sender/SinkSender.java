package com.example.demo.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 11:40
 * @modified by:
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
