package com.thzhima.base.ext;

public class B extends A {
    int age = 10;
    static {
    	System.out.println();
    }
    
	public B(String name) {
//		super();
//		super(name);
	}
	
	public B() {
		super();
		System.out.println("B()");
	}

	
}
