package com.xia.ssm.algorithm;

public class SortTest {
	
	public void intData(){
	    int[] array  = {1,3,2,7,6,4,7,9,23,66,23,2,65,34};
	} 
	//冒泡
	public static void bubbleSort(int[] array){
		for(int i = 0,j = array.length;i < j;i++){
			
			for(int m = i + 1;m < array.length;m++){
				if(array[i]<array[m]){
					int temp = array[m];
					array[m] = array[i];
					array[i] = temp;
				}
			}
		}
		System.out.println("冒泡");
		for(int i = 0, j = array.length;i<j ; i++){
			System.out.print("-"+array[i]);
		}
	}
	
	//直接插入排序
	public static void insertSort(int[] array){
		for (int i = 1; i < array.length; i++) {
			//待插入数
			int temp = array[i];
			int j;
			for (j = i-1; j >=0; j--) {
				if(temp>array[j]){
					array[j+1] = array[j];
				}else{
					break;
				}
			}
			array[j+1] = temp;
		}
		System.out.println("直接插入");
		for(int i = 0, j = array.length;i<j ; i++){
			System.out.print("-"+array[i]);
		}
		
	}

	
	//二分插入排序（降序）
	public static void towInsertSort(int[] data){
		for(int i = 1;i < data.length; i++)
		{
			int temp = data[i];
			int left = 0;
			int right = i-1;
			while(left<=right){
				int mid = (left+right)/2;
				if(data[mid]<temp){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
			for(int m = i - 1;m > right; m--){
				data[m+1]=data[m];
			}
			data[right+1] = temp;
		}
		System.out.println("二插插入");
		for(int i : data){
			System.out.print("-"+i);
		}
	}
	
	//希尔排序
	public static  void shellSort(int[] array){
		int arrlen = array.length;
		for(int increment = arrlen/2;increment>0;increment/=2){
			//对每组进行排序
			for(int i = 0;i < increment;i++){
				for(int m = i+increment;m < arrlen;m+=increment ){
					int temp = array[m];
					int k = m - increment;
					while (k >= 0 && array[k] > temp) {
						array[k + increment] = array[k];
                        k -= increment;
                    }
					array[k + increment] = temp;
				}
			}
		}
		for(int i : array){
			System.out.print("-"+i); 
		}
	}
	
	
	
	
	public static void main(String[] args) {
//		SortTest.bubbleSort();
//		System.out.println("-------------------");
//		SortTest.insertSort();
//		System.out.println("-------------------");
//		SortTest.towInsertSort(array);
	    int[] array  = {1,3,2,7,6,4,7,9,23,66,23,2,65,34}; 
		SortTest.insertSort(array);
	}
}
