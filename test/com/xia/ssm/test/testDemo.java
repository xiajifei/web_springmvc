package com.xia.ssm.test;

import java.text.DateFormat;
import java.text.ParseException;
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
    
    public static void main(String[] args) throws ParseException {
//        Date dd = new Date("Fri Aug 05 17:17:28 CST 2016");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String da = sdf.format(dd);
//        System.out.println(da);
//        System.out.println(dd.getTime());
        
        
//        Calendar c = Calendar.getInstance(Locale.CHINA);
//        System.out.println(sdf.format(c.getTime()));
        
        DateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//        try {
//            System.out.println(sdf.parse("2001.12.1208:23:21"));
////            System.out.println(sdf.parse((new Date()).toString()));
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        Date dd = sdf.parse("1970-01-01 00:00:00");
        System.out.println(dd);
        
        
        
        Double a = 0.00;
        System.out.println(0!=a);
                
                
        String str = "http://localhost:8080/lexiugo";
        
        System.out.println("subString------"+str.substring(0,4));
                
                
    }


}
