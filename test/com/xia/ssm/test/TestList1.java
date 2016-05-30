package com.xia.ssm.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2016年5月26日上午8:37:39
 * @author SummerBoy
 *
 */
public class TestList1 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(12);
		list.add(12);
		list.add(12);
		list.add(14);
		list.add(14);
		list.add(14);
		list.add(16);
		list.add(16);
		System.out.println("old----"+list.toString());
		List Nlist = new ArrayList();
		Set<List> set = new HashSet<List>();
		
		for(int i = 0, j = list.size();i < j; i++){
			List listN = new ArrayList();
			int temp = (int) list.get(i);
			for(int a = 0,b = list.size();a < b; a++){
				int temps = (int) list.get(a);
				if(temps==temp){
					listN.add(temps);
				}
			}
			set.add(listN);
		}
		System.out.println("new----"+set);
	}
	
	
}
