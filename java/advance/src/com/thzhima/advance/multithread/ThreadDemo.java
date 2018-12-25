package com.thzhima.advance.multithread;

import java.awt.Toolkit;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Thread curr = Thread.currentThread(); // 当前main的执行线程，是主线程。
		System.out.println(curr.getName());
		
		Thread t = new MyTask();
		t.start();
//		t.run();
		
		//Thread t2 = new MyTask2();
		//t2.start();
		
		System.out.println("================over----------------");

		for(int i=0;i<50;i++) {
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(10);
		}
		
	
		
	}
}

class MyTask extends Thread{

	@Override
	public void run() {
		for(int i=0; i<1000000; i++) {
			System.out.println("---------"+Thread.currentThread().getName());
		}
	}
}

class MyTask2 extends Thread{

	@Override
	public void run() {
		for(int i=0; i<1000000; i++) {
			System.out.println("++++++++++++++"+ Thread.currentThread().getName());
		}
	}
}
