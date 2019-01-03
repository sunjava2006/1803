package com.thzhima.advance.multithread.wn;

import java.util.ArrayList;
import java.util.List;

import com.thzhima.advance.multithread.work.Ticket;

public class Product {

	static int count = 0;
	
	public static void main(String[] args) {
		
		List<Ticket> list = new ArrayList<>();
		
		Thread t = new Thread() {
			public void run() {
				try {
					while(true) {
						synchronized (list) {
							while(list.size()<10) {
								count+=1;
								System.out.println("生产：" + count);
								Ticket t = new Ticket(count);
								list.add(t);
								Thread.sleep(1000);
							}
							list.notifyAll();
							list.wait();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					while(true) {
						synchronized (list) {
							while(list.size()>0) {
								int idx = list.size()-1;
								Ticket t = list.get(idx);
								list.remove(idx);
								System.out.println("取出了:" + t.id);
								Thread.sleep(1000);
							}
							list.notify();
							list.wait();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
		t2.start();
	}
}
