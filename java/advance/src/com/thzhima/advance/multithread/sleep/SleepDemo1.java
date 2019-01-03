package com.thzhima.advance.multithread.sleep;

public class SleepDemo1 {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {

			@Override
			public void run() {

				try {
					for (int i = 0; i < 10; i++) {

						System.out.println("-------------------------");
						Thread.sleep(1000);
						System.out.println("==========================");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Thread t = new Thread(r);
		
		t.start();
		System.out.println("******************");
		t.interrupt(); // 打断t线程。
		System.out.println("******************");

//		for (int i = 0; i <= 20; i++) {
//			System.out.println(t.getState());
//			Thread.sleep(900);
//			if(i==4) {
//				t.interrupt(); // 打断t线程。
//			}
//		}

	}

}
