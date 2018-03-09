package com.example.demo.sender;

import com.example.demo.input.SinkInput1;
import com.example.demo.output.SinkOutput1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 15:29
 * @modified by:
 */
//@EnableBinding(value = {SinkOutput1.class})
public class SinkSender {

    private static Logger log = LoggerFactory.getLogger(SinkSender.class);

    private static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Bean
    @InboundChannelAdapter(value = SinkOutput1.INPUT1,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){
        return () -> new GenericMessage<Date>(new Date());
    }

    @Transformer(inputChannel = SinkInput1.INPUT1,outputChannel = SinkOutput1.INPUT1)
    public String transform(Date message){
        String date= sdf.format(message);
        return date;
    }
}
