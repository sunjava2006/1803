package com.thzhima.base.inner;

import com.thzhima.base.oop.abst.G6;

public class A {

	private static int age;
	public static int money = 90;
	
	void about() {
		B b = new B();
	    int age = 	b.age;
	    int monty = b.money;
	}
	
	public class BB{
		
	}
	
	public static  class B {
		private int age = A.age;
		public static   int money = A.money;
		public String name = "XXX";
	}
	
	void todo() {
		class C{
			int xx;
		}
	}
	
	G6 g6 = new G6() {
		@Override
		public void fly() {
			System.out.println("----fly -------");
		}
	};
	
	Object o = new Object() {
		@Override
		public String toString(){
			return "hello";
		}
	};
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.o);
	}
	
}
