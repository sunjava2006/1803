package com.thzhima.advance.multithread.work;

import java.util.Arrays;

public class Station {

	static Ticket[] tks = null;
	static int count = 50;
	
	static{
		tks = new Ticket[50];
		for(int i=1;i<=50;i++) {
			tks[i-1] = new Ticket(i);
		}
	}
	
	public static synchronized Ticket[] buy(int s) {
		Ticket[] ts = null;
		try {
			int c = s < count? s :count;
			
			ts = new Ticket[c];
			Thread.sleep(100);
			System.arraycopy(tks, count-c, ts, 0, c);
			Thread.sleep(100);
			count-=c;
			Thread.sleep(1000);
			Arrays.fill(tks, count, count+c, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return ts;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			public void run() {
				Ticket[] b = Station.buy(16);
				System.out.println(b.length);
				
			}
		};
		
		
			Thread t = new Thread(r);
			Thread t2 = new Thread(r);
			Thread t3 = new Thread(r);
			Thread t4 = new Thread(r);
			t.start();
			t2.start();
			t3.start();
			t4.start();
			t.join();
			t2.join();
			t3.join();
			t4.join();
		
		
		
		System.out.println("剩余："+Station.count);
		
	}
	
}
