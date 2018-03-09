package com.example.demo.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/7 10:39
 * @modified by:
 */
public interface SinkInput1 {
    String INPUT1 = "input1";

    @Input(value = INPUT1)
    SubscribableChannel input();
}
