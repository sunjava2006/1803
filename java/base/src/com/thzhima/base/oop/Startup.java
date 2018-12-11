package com.thzhima.base.oop;

public class Startup {

	// 静态块，只在该类加载时，被执行。类只加载一次，其也只执行一次。
	static {
		System.out.println("=============================");
	}
	
	public static void main(String[] args) {
		System.out.println("-----in manin method.------");
		Apple a = null;
		a = new Apple();
	}
}
