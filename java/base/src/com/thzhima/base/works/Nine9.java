package com.thzhima.base.works;

public class Nine9 {

	public static void main(String[] args) {
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=i ; j++) {
				int ji = j * i;
				System.out.print(j + "*" + i + " = " + ji + " \t ");
			}
			System.out.println();
				
		}
	}
}
