package com.example.demo.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 15:09
 * @modified by:
 */
@EnableBinding(value = {SinkSender.SinkOutput.class})
public class SinkSender {

    private static Logger log = LoggerFactory.getLogger(SinkSender.class);

    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource(){
        return () -> new GenericMessage<Date>(new Date());
    }

    public interface SinkOutput{
        String OUTPUT = "input";

        @Output(SinkOutput.OUTPUT)
        MessageChannel output();
    }
}
