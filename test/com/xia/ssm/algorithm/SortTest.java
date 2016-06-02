package com.xia.ssm.algorithm;

public class SortTest {
	
	static final int[] array  = {1,3,2,7,6,4,7,9,23,66,23,2,65,34};
	//冒泡
	public static void bubbleSort(){
		for(int i = 0,j = array.length;i < j;i++){
			
			for(int m = i + 1, n = array.length;m < n;m++){
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
	public static void insertSort(){
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

	
	//二分插入排序
	public static void towInsertSort(int[] data){
		for(int i = 1;i < data.length; i++)
		{
			int temp = data[i];
			int left = 0;
			int right = i-1;
			while(left<=right){
				int mid = (left+right)/2;
				if(data[mid]<temp)
				{
					right = mid - 1;
				}
				else
				{
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
	
	
	public static void sort(int[] data){  
        for (int i = 1; i < data.length; i++)  
        {  
            int temp = data[i];  
            int low = 0;  
            int high = i - 1;  
            while (low <= high)  
            {  
                int mid = (low + high) / 2;  
                if (temp < data[mid])  
                {  
                    high = mid - 1;  
                }  
                else  
                {  
                    low = mid + 1;  
                }  
            }  
            for (int j = i - 1; j > high; j--)  
            {  
                data[j + 1] = data[j];  
            }  
            data[high + 1] = temp; // 或者data[low] = temp;  
  
        }  
        for(int i : data){
			System.out.print("-"+i);
		}
    }  
	
	
	
	public static void main(String[] args) {
//		SortTest.bubbleSort();
//		System.out.println("-------------------");
//		SortTest.insertSort();
//		System.out.println("-------------------");
		SortTest.towInsertSort(array);
//		SortTest.sort(array);
	}
}
