package com.example.demo;

import com.example.demo.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 11:42
 * @modified by:
 */
@RunWith(SpringRunner.class)
@EnableBinding(value = SinkSender.class)
public class StreamHelloApplicationTests2 {

    @Autowired
    SinkSender sinkSender;

    @Test
    public void sinkSenderTester(){
        sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
    }
}
