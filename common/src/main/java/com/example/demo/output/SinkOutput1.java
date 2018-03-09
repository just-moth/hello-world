package com.example.demo.output;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/7 10:40
 * @modified by:
 */
public interface SinkOutput1 {
    String INPUT1 = "input1";

    @Output(value = INPUT1)
    SubscribableChannel input();
}
