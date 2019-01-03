package com.thzhima.advance.multithread.join;

import java.util.ArrayList;
import java.util.List;

public class JoinDemo {

	public static void main(String[] args)  {
		List<Integer> list = new ArrayList<>();//new Vector<>();
		
		Thread t = new Thread() {
			public void run() {
				for(int i=0;i<200;i++) {
					list.add(i);
					System.out.println("+" + i);
					
				}
			}
		};
		
		t.start();
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i=0;i<200;i++) {
					list.add(i);
					System.out.println("++" + i);
				}
			}
		};
		
		t2.start();
		
		
		
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("-------------size is : "+list.size());
		
		
	}
}
