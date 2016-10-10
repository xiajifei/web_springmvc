package com.xia.ssm.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.xia.ssm.po.User;
import com.xia.ssm.tools.JsonUtil;

public class jacksonTest {
    
    private User user;
    private String strJson;
    private byte[] bb;
    
    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId("1");
        user.setName("张三");
        user.setCreatedate(new Date());
        user.setOrderid("44");
        
        strJson = "{\"id\":\"1\",\"name\":\"张三\",\"orderid\":\"44\",\"createdate\":1475917782664}";
        bb = strJson.getBytes();
    }

   
    public void test() {
        fail("Not yet implemented");
    }
    
    public void jsonToObject1(){
        User uu = JsonUtil.jsonToObject(strJson, User.class);
        System.out.println("jsonToObject1"+uu.toString());
    }
    @Test
    public void jsonToObject2(){
        User uu = JsonUtil.jsonToObject(bb, User.class);
        System.out.println("jsonToObject2"+uu.toString());
    }
    public void objectToJson(){
        String userString  = JsonUtil.objectToJson(user);
        System.out.println(userString);
    }
    

}
