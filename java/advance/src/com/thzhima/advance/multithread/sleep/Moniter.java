package com.thzhima.advance.multithread.sleep;

public class Moniter {

	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					try {
						Thread.sleep(1000);
						System.out.println("---------------");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		
		
		Thread td = new Thread() {
			public void run() {
				try {
					while(true) {
						System.out.println(t.getState());
						Thread.sleep(0);
					}
				} catch (Exception e) {
					
				}
				
			}
		};
		
		td.setDaemon(true);
		
		td.start();
		t.start();
		
	}
}
