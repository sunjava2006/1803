package com.thzhima.base.oop;

public class Variable {
	
	int a = 10;
	
	void a(int a) {
		a += 10;
		System.out.println(a);
	}
	
	void b(Variable v) {
		v.a += 10;
		System.out.println(v.a);
	}
	
	void c(Variable v) {
		v = null;
	}
	
	void d(Variable v) {
		v = new Variable();
		v.a = 90;
	}
	
	public static void main(String[] args) {
	    Variable v =new Variable();
	    int i = 10;
	    
	    // 第一个方法在执行的时候，都会分配一个桟内存。
	    // 实参与形参都是实际存在的不同的内存空间。形参是在方法的栈上分配的。
	    
	    System.out.println(i); // 10
	    v.a(i); // 20
	    System.out.println(i); // 10
	    //----------------------------------
	    System.out.println(v.a); // 10
	    v.b(v); // 20
	    System.out.println(v.a); // 20
	    
	    
	}
}
