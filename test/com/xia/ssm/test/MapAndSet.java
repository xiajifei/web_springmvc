package com.xia.ssm.test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.util.Set;

public class MapAndSet {
    
    public static void main(String[] args) {
        
        /**
         * 遍历map
         */
        Map<Integer,String> map = new HashMap<Integer,String>(); 
        for(int i = 0; i < 100; i++){
            map.put(i, "123");
        }
        long start = System.currentTimeMillis();
        for(Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"------"+entry.getValue());
        }
        System.out.println(System.currentTimeMillis()-start);
        
        long start2 = System.currentTimeMillis();
        for(Object object : map.keySet()){
            System.out.println(map.get(object));
        }
        System.out.println("------------"+(System.currentTimeMillis()-start2));
        
        /**
         * 遍历set
         */
         
        Set set = new HashSet();
        for(int i = 0; i < 100; i++){
            set.add(i);
        }
        
        for(Iterator it = set.iterator(); it.hasNext();){
            System.out.println("set"+it.next());
        }
        
        
        /**
         * hashTable
         */
        Hashtable hashTable = new Hashtable();
        hashTable.put("1", "1");
        hashTable.put("2", "2");
        hashTable.put("3", "3");
        
        Enumeration e = hashTable.keys();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        
        e = hashTable.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        
    }

}
