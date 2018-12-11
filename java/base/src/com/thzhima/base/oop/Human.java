package com.thzhima.base.oop;

import java.util.Date;

// class 关键字，用来定义一个（类）类型。
public class Human {
	
	// 构造方法。（与类名同名，没有返回类型申明的方法）
	Human(String name, String gender, Date birthday) {
	    this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	// 方法名相同，而参数不同，称为方法的重载。
	Human(String name, String gender){ 
		this.name = name;
		this.gender = gender;
		this.birthday = new Date();
	}
	
	public Human() {
		
	}

	// 在类中定义的变量，称为属性。
	String name;
	String gender;
	Date birthday;
	
	// 在类中定义的函数，称为方法。
	void work() {
		System.out.println(this.name + " is  working now.");
	}
	
	String cooking(String arg, String...args) {
		String name = arg;
		if(null != args) {
			for (String n : args) {
				name +=", "+n;
			}
		}
			return name;
	}
	
	
}
