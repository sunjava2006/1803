package com.thzhima.base.extend;

public class People {
	public final String gender;
	String name;
	private int money = 100;
	protected String car = "OOOO";
	
	public People(String gender, String name) {
		this.gender = gender;
		this.name = name;
		
	}
	
	public int money() {
		return this.money/2;
	}
	
	// 自已访问自己，没有任何限制。
	public String aboutMe() {
		return "My name is "+this.name +", is " + gender 
				+", I have a "+ car +" and " + money +" money.";
	}
	
	
}
