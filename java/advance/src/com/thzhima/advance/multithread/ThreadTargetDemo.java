package com.thzhima.advance.multithread;

public class ThreadTargetDemo {
	
	public static void main(String[] args) {
		ThreadGroup gp = new ThreadGroup("gp1");
		
		Thread t = new Thread(gp, new MyRun(), "小小子线程");
		
		
		
		Thread t2 = new Thread(gp, new MyThread(), "线程2");
		t2.start();
		t.start();
		
		gp.stop();
		
	}
	
}

class MyRun implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println("----------"+ Thread.currentThread().getName());
		
	}
	
}

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println("----------"+ Thread.currentThread().getName());
		
	}
}
