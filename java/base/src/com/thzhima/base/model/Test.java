package com.thzhima.base.model;

public class Test {
	public static void main(String[] args) {
		TVFactory factory = new TVFactory(); // 实例工厂
		
		TV tv = factory.createTV();
		
		tv.watch();
		
		
		//==================================
		TV t = TVFactory.createTV();   // 静态工厂
	}
}
