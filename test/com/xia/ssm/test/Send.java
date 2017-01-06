package com.xia.ssm.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
    
    private final static String QUEUE_NAMW = "first";
    
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.120.253");
        factory.setUsername("rabbitadmin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare( QUEUE_NAMW, false, false, false, null);
        String message = "hello world!";
        channel.basicPublish("", QUEUE_NAMW, null, message.getBytes());
        System.out.println("发送消息为:'"+message+"'");
        channel.close();
        connection.close();
    }
    

}
