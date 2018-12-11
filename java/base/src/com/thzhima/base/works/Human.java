package com.thzhima.base.works;

public class Human {
    public String name;
    public int age;
    public String gender;
    
    
    public void sing() {
    	System.out.println("sing...");
    }
    
    public void dance() {
    	System.out.println("dancing.....");
    }
    
	public static void main(String[] args) {
		Human h = new Actor();
		
		h.age = 30;
		h.name = "小张";
		h.gender = "male";
		
		h.sing();
		h.dance();
		
		((Actor)h).drive();
		((Actor)h).sumba();
		((Actor)h).role = "大圣";
		System.out.println(((Actor)h).role);
	}
}


class Actor extends Human{
	
	public String alias;
	public String role;
	
	public void drive() {
		System.out.println("drive..........");
	}
	
	public void sumba() {
		System.out.println("sumba.........");
	}
	
	

}