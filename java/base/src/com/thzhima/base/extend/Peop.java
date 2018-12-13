package com.thzhima.base.extend;

public class Peop {
	public static String firstName = "李";
	
	public String lastName;
	
	public Peop(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return Peop.firstName+this.lastName;
	}
	
	public static void main(String[] args) {
		Peop p1 = new Peop("长亮");
		Peop p2 = new Peop("小光");
		Peop p3 = new Peop("立群");
		
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		Peop.firstName = "张";
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}
}
