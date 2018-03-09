package com.example.demo.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 18:03
 * @modified by:
 */
public interface SinkInput2 {
    String INPUT2 = "input2";

    @Input(value = INPUT2)
    SubscribableChannel input();

}
