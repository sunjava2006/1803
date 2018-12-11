package com.thzhima.base.extend;

public class Test2 {
	public static void main(String[] args) {
		People p = new People("mail" , "Li");
		
		// 同包中，只有私有属性和方法不能访问。
		System.out.println(p.gender);
		System.out.println(p.name);
		System.out.println(p.car);
//		System.out.println(p.money);
	}
}
