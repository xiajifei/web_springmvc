package com.xia.message.test;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reveiver {

    private CountDownLatch latch = new CountDownLatch(1);
    
    private void receiveMessage(String message){
        System.out.println("receiveMessage msg = "+message.toString());
        latch.countDown();
    }
}
