package com.thzhima.base.oop.abst;

public abstract class J21 {
	int maxPush = 200;
	
	public void fly() {
		System.out.println("fly--------------");
	}
	
	protected abstract void run();
	
	public static void main(String[] args) {
		J21 j21 = new J21Impl();
	}
	
}

class J21Impl extends J21{
	@Override
	public void run() {
		System.out.println("run-----------------");
	}
}
