package com.xia.ssm.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xia.ssm.tools.SecurityCode;

public class TestSecurityCode {

    @Test
    public void test() {
       System.out.println(SecurityCode.getSecurityCode());
    }
}
