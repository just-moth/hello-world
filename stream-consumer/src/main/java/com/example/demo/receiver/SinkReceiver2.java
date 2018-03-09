package com.example.demo.receiver;

import com.example.demo.entity.User;
import com.example.demo.input.SinkInput2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author： lxh
 * @description：
 * @created: 2018/3/2 16:19
 * @modified by:
 */
@EnableBinding(value = {SinkInput2.class})
public class SinkReceiver2 {

    private static Logger log = LoggerFactory.getLogger(SinkReceiver2.class);

    @StreamListener(SinkInput2.INPUT2)
    private void receive(User user){
        log.info("SinkReceiver2 : " + user);
    }

    /*@ServiceActivator(inputChannel = SinkInput2.INPUT1)
    public void receive(User user){
        log.info("SinkReceiver2 Received : " + user);
    }

    @Transformer(inputChannel =SinkInput2.INPUT1,outputChannel = SinkOutput2.INPUT1)
    public User transform(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message, User.class);
        return user;
    }*/

}
