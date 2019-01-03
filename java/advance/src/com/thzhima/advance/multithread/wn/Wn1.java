package com.thzhima.advance.multithread.wn;

public class Wn1 {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		
		Thread t = new Thread() {
			public void run() {
				try {
					synchronized (o) {
						System.out.println("----------run--------");
						
						o.wait();
						
						System.out.println("==========end=======");
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
		
		Thread.sleep(1000);
		
		synchronized (o) {
			o.notify(); // notifyAll()
		}
		
		
	}
}
