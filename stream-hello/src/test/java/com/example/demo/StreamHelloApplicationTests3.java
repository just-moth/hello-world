package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 14:07
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamHelloApplication.class)
@WebAppConfiguration
public class StreamHelloApplicationTests3 {

    @Autowired
    private MessageChannel input;

    @Test
    public void contextLoads(){
        input.send(MessageBuilder.withPayload("From MessageChannel").build());
    }
}
