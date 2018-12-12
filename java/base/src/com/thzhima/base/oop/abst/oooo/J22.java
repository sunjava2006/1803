package com.thzhima.base.oop.abst.oooo;

import com.thzhima.base.oop.abst.G6;
import com.thzhima.base.oop.abst.G7;

public class J22 implements G6, G7{

	@Override
	public void fly() {
		System.out.println("fly-------------------");
		
	}
	
	@Override
	public void autoDrive() {
		System.out.println("-----auto drive--------");
		
	}
	
	public static void main(String[] args) {
		G6 plane = new J22();
		plane.fly();
		//G6.maxLoad = 900;
		System.out.println(G6.maxLoad);
	}

	

}
