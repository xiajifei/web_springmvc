package com.xia.message.test;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class Reveiver implements MessageListener{

    @Autowired
    private MongoOperations mongo;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onMessage(Message paramMessage) {
        System.out.println("paramMessage---------------"+paramMessage);
        
//        TestVo testVo = JsonUtil.jsonToObject(paramMessage.getBody(), TestVo.class);
        TestVo testVo = new TestVo();
        testVo.setMsg("dddddd");
//        testVo.setId(UUID.randomUUID().toString());
//        mongo.insert(testVo, "messTest");
//        mongoTemplate.insert(testVo, "messTest");
//        mongo.inse
    }

    public MongoOperations getMongo() {
        return mongo;
    }

    public void setMongo(MongoOperations mongo) {
        this.mongo = mongo;
    }
    
    
}
