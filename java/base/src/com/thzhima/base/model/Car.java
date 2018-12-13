package com.thzhima.base.model;

public class Car {
	
	public void run() {
		System.out.println("---car---run");
	}
	
	private Car() {
		
	}
	
	public static Car create() {
		return new Car();
	}
}
