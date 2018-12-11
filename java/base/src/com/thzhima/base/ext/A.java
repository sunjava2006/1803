package com.thzhima.base.ext;

public class A {
	String name;
	static {
		System.out.println();
	}
	
	public A(String name){
		System.out.println("A(name)");
		this.name = name;
	}
	
	public A() {
		this("小张");
		System.out.println("A()");
		
		//this.name = "小张";
	}

	
}
