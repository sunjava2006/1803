package com.thzhima.base.oop;

public class Apple {
    public String color;
    public boolean ok;
    public int size;
    
    static { // 静态块
    	System.out.println();
    }
    
    { //  语句块
    	System.out.println(color);
    	System.out.println(ok);
    	System.out.println(size);
    }
    
    public Apple() {
    	this.color = "Green";
    }
    
    public Apple(String color) {
    	this.color = color;
    }
}
