package com.example.demo.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 18:03
 * @modified by:
 */
public interface SinkInput3 {
    String INPUT3 = "input3";

    @Input(value = INPUT3)
    SubscribableChannel input();

}
