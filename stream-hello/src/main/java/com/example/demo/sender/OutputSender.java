package com.example.demo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 14:53
 * @modified by:
 */
@Component
public class OutputSender {

    @Autowired
    @Qualifier("Output-1")
    private MessageChannel output;

}
