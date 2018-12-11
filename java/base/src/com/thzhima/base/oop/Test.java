package com.thzhima.base.oop;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Human zhang = new Human("ZhangLiang", "male", new Date(89, 9, 1));
//		zhang.name = "Zhang";
//		zhang.gender = "male";
		// zhang.birthday = new Date(1999-1900,2,3);

		System.out.println(zhang.name + "," + zhang.gender + "," + zhang.birthday);

		zhang.work();
		
		Human li = new Human();
		System.out.println(li.cooking("大白菜","老干妈"));
	}
}
