package com.example.demo.output;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 17:41
 * @modified by:
 */
public interface SinkOutput2{
    String INPUT2 = "input2";

    @Output(value = INPUT2)
    MessageChannel output();

}
