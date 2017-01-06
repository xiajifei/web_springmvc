package com.xia.message.test;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class TestController {

    
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @Resource
    private Product product;
    
    @RequestMapping("/testSendMsg/{msg}")
    public String send(@PathVariable("msg") String msg){
        logger.info("#TestController.send#abc={msg}",msg);
        System.out.println("msg "+msg);
        product.sendData2Queue("test_queue", msg);
        return "user/userList";

    }
}
