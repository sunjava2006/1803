package com.thzhima.base.extend.other;

import com.thzhima.base.extend.People;

public class Test {
    public static void main(String[] args) {
		People p = new People("male", "小张");
		
		// 其它类中，只能访问公共的属性和方法。
		System.out.println(p.gender);
		
		//System.out.println(p.name);
		//System.out.println(p.money);
//		System.out.println(p.car);
		
	}
}
