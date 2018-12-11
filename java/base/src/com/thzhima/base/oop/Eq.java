package com.thzhima.base.oop;

public class Eq {
	// static 静态，静态所表示的意思是，这个方法或变量是该类型共有的。不需要创建对象就存在，可以直接使用。
	
	
	
    public static void main(String[] args) {
		int a = 10;
		int b = 10;
		System.out.println(a == b);
		
		Variable v1 = new Variable();
		Variable v2 = v1; // new Variable();
		System.out.println(v1 == v2);
	}
}
