package com.thzhima.base.basetype;

public class FeiBe1 {

	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int sum = a + b;
		while(sum < 5000) {
	        int n = a + b;
	        System.out.print(n + ", ");
	        a = b;
	        b = n;
	        sum += b;
		}
		System.out.println("\nsum:" + sum);
		System.out.println("last: " + b);
	}
}
