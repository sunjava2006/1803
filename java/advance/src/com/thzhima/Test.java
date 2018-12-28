package com.thzhima;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
		System.out.println(System.nanoTime());
		
		for(int i=0;i<10;i++) {
			System.out.println(Math.random());
		}
		System.out.println("--------------------------------------");
		Random r = new Random();
		for(int i=0;i<10;i++) {
			System.out.println(r.nextLong());
		}
	}

}
