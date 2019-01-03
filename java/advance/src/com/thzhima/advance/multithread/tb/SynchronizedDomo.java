package com.thzhima.advance.multithread.tb;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedDomo {

	List<Integer> list = new ArrayList<>();
	
	public synchronized void add(int i) {
		list.add(i);
	}
	
	public  void minus() {
		if(list.size()>0) {
			int index = list.size()-1;
			list.remove(index);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		SynchronizedDomo demo = new SynchronizedDomo();
		
		Runnable r = new Runnable() {
			public void run() {
				for(int i=0;i<2000;i++) {
					demo.add(i);
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			public void run() {
				for(int i=0;i<2000;i++) {
					demo.minus();
				}
			}
		};
		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r2);
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(demo.list.size());
	}
	
}
