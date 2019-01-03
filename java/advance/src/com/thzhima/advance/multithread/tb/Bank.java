package com.thzhima.advance.multithread.tb;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	int total = 100;
	Map<Integer, Object> map = new HashMap<>();
	
	public Object getAccount(int NO) {
		Object o = map.get(NO);
		if(o==null) {
			o = String.valueOf(NO);
			map.put(NO, o);
		}
		return o;
	}
	
	public  void add(int i ,Object o) {
		
		synchronized (o) {
			System.out.println("----------------------");
			try {
				Thread.sleep(110);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			total +=i;
			System.out.println("========================");
		}
		
		
		
	}
	
	public  int get(int i, Object o) {
		synchronized (o) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
			if(i <= total) {
				try {
					Thread.sleep(130);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				total -= i;
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
				return i;
			}else {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
				return 0;
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		Object o = bank.getAccount(123);
		Object o1 = bank.getAccount(123);
		
		System.out.println(o==o1);
		
		
		
		Runnable r = new Runnable() {
			public void run() {
				bank.add(500, o);
			}
		};
		
		Runnable r2 = new Runnable() {
			public void run() {
				bank.get(550,o1);
			}
		};
		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r2);
		
		t2.start();
		t.start();
		
		t.join();
		t2.join();
		
		System.out.println(bank.total);
	}
}
