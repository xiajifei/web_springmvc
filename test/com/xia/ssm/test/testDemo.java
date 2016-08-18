package com.xia.ssm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testDemo {
    
/*    1个1个拿，正好拿完。
    2个2个拿，还剩1个。
    3个3个拿，正好拿完。
    4个4个拿，还剩1个。
    5个5个拿，还剩1个
    6个6个拿，还剩3个。
    7个7个拿，正好拿完。
    8个8个拿，还剩1个。
    9个9个拿，正好拿完。*/
    
    public static void main(String[] args) {
        Date dd = new Date("Fri Aug 05 17:17:28 CST 2016");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String da = sdf.format(dd);
        System.out.println(da);
        System.out.println(dd.getTime());
        
        
    }

//    public int getNum(){
////        if(){}
//    }
}
