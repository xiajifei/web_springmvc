package com.xia.ssm.test;

public class Singleton {

	private Singleton(){};
	
//	private static Singleton single = new Singleton();
//	
//	public static  Singleton getSingle(){
//		return single;
//	}
	
	private static Singleton single;
	
	public static Singleton getInstance(){
		if(single == null){
			single = new Singleton();
		}
		return single;
	}
}
