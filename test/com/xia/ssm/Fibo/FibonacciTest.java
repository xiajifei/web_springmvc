package com.xia.ssm.Fibo;

import java.util.UUID;

/**
 * 菲波那切数列
 * @author summerboy
 *
 */
public class FibonacciTest {

	public static void main(String[] args) {
//		FibonacciTest.fi2();
		System.out.println();
		//递归调用
		for(int i = 0;i<20;i++){
			System.out.println(fi3(i));
		}
	}
	//三个变量
	public static void fi1(){
		int a = 0;
		int b = 1;
		int c = 0;
		for(int i = 0;i<=19;i++){
			System.out.println(c);
			c = a+b;
			a = b;
			b = c;
		}
	}
	//定义数组
	public static void fi2(){
		int[] arr = new int[20];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2;i<arr.length-2;i++){
			arr[i]=arr[i-1]+arr[i-2];
		}
		for(int i : arr){
			System.out.println(i);
		}
	}
	//递归
	private static int fi3(int i){
		if(i==0){
			return 0;
		}else if(i==1||i==2){
			return 1;
		}else{
			return fi3(i-1)+fi3(i-2);
		}
	}
}
