package com.example.demo.sender;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.output.SinkOutput2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 16:19
 * @modified by:
 */
@EnableBinding(value = SinkOutput2.class)
public class SinkSender2 {

    private static Logger log = LoggerFactory.getLogger(SinkSender2.class);

    @Bean
    @InboundChannelAdapter(value = SinkOutput2.INPUT2,poller = @Poller(fixedDelay = "5000"))
    public MessageSource<String> stringMessageSource2(){
        return () -> new GenericMessage<String>(JSONObject.toJSONString(new User("didi",30)) );
    }

}
