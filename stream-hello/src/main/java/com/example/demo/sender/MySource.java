package com.example.demo.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 14:54
 * @modified by:
 */
public interface MySource {

    @Output("Output-1")
    MessageChannel output1();

    @Output("Output-2")
    MessageChannel output2();
}
