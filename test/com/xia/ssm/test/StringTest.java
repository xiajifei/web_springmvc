package com.xia.ssm.test;

import java.util.ArrayList;

import com.xia.ssm.tools.StringUtils;

import javassist.compiler.ast.StringL;

public class StringTest {

    public static void main(String[] args) {
        String str1 = "abcxefghijk";
        String str2 = "abcyefghijk";
        
        ArrayList list = new ArrayList();
        for(int i = 0;i<str1.length();i++){
            for(int j = i;j<str2.length();j++){
                String sub = str1.substring(i, j);
                    if(str2.indexOf(sub)!=-1){
                        if(StringUtils.notEmpty(sub)){
                            list.add(sub);
                        }
                    }
            }
        }
    }
}
