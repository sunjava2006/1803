package com.thzhima.base.basetype;

public class FeiBe2 {
	public static void main(String[] args) {
		int[] array = new int[100];
		array[0] = 1;
		array[1] = 1;
		int sum = 0;
		
        for(int i = 0; sum<5000 && i<array.length-2; i++ ) {
        	int n = array[i] + array[i+1];
        	sum += n;
        	array[i+2] = n;
        	System.out.println(n);
        }
        
//        for(int i : array) {
//        	System.out.println(i);
//        }
	}
}
