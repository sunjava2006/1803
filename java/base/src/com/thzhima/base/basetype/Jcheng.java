package com.thzhima.base.basetype;

public class Jcheng {

	static int chen(int a){
		if(a==1) {
			return 1;
		}else {
			return a*chen(a-1);
		}
	}
	
	
	public static void main(String[] args) {
		int a = 4;
		int result = a;
		while(a>1) {
			result *= --a;
		}
		
		System.out.println(result);
		
		
		System.out.println(chen(4));
	}
}
