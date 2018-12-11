package com.thzhima.base.extend.example;

import java.util.Date;

public class Student extends Human {
	
	public String studentID;
	public String name = "LaLa";
	
	public void learning() {
		System.err.println("学习中");
	}
	
	public String getName() {
		return super.name;
	}
	
     @Override 
      void work() {
//    	super.super.toString();
    	 System.out.println("----------->>>>>>>>>>>>>");
     }
     
     public static void main(String[] args) {
		Student s = new Student();
		s.work();
	    int ran = (int)(Math.random()*100);	
		Human h = null;
		//if(ran%2 == 0) {
		//	h = new Human();

		//}else {
    	     h = new Student();

		//}
//   		h.work();
//   		
//   		System.out.println(s.getName());
//   		
//   		System.out.println(s.name);
   		System.out.println(h.name);
	}
}
