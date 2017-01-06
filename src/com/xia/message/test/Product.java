package com.xia.message.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Product {

    @Autowired
    private AmqpTemplate amqpTemplate;
    
    private final static Logger logger = LoggerFactory.getLogger(Product.class);
    
    public void sendData2Queue(String queueKey,Object object){
        try {
            amqpTemplate.convertAndSend(queueKey,object);
        } catch (AmqpException e) {
            logger.error("exeception={}",e);
            e.printStackTrace();
        }
    }
}
