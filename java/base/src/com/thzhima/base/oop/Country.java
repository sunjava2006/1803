package com.thzhima.base.oop;

public class Country {
	public static final String name = "China"; // final 常量
	
	
	
	
	static{
		System.out.println();
	}
	
	{
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		
		
		String yourCountry = Country.name;
		System.out.println(yourCountry);
		
		Country c = new Country();
		System.out.println(c.name);
		
		//Country.name = "中国";
		System.out.println(c.name);
		
		Country c2 = new Country();
		System.out.println("c2 name: "+c2.name);
	}
}
