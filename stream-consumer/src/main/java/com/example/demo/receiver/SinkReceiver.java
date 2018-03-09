package com.example.demo.receiver;

import com.example.demo.input.SinkInput1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;


/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 15:28
 * @modified by:
 */
//@EnableBinding(value = {SinkInput1.class})
public class SinkReceiver {
    private static Logger log = LoggerFactory.getLogger(SinkReceiver.class);

    //@StreamListener(value = Sinkinput1.INPUT1)
    @ServiceActivator(inputChannel = SinkInput1.INPUT1)
    public void receive(Object payload){
        log.info("SinkReceiver1 : " + payload);
    }
}
