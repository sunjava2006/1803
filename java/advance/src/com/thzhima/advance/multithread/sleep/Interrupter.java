package com.thzhima.advance.multithread.sleep;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Interrupter extends JFrame {

	public Interrupter() {
		
		this.setTitle("线程打断示例");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JPanel panel = new JPanel(null);
		// panel.setBackground(Color.blue);
		this.setContentPane(panel);

		// 开始按钮
		JButton btnStart = new JButton("开始");
		btnStart.setSize(70, 30);
		btnStart.setLocation(10, 10);
		panel.add(btnStart);

		// 取消按钮
		JButton btnCancel = new JButton("取消");
		btnCancel.setSize(70, 30);
		btnCancel.setLocation(100, 10);
		panel.add(btnCancel);

		// 进度条
		JProgressBar bar = new JProgressBar(0, Integer.MAX_VALUE);
		bar.setSize(700, 30);
		bar.setLocation(30, 200);
		panel.add(bar);
		bar.setValue(0);

		Thread t = new Thread() {
			public void run() {
//				try {
					for (int i = 1; i <= Integer.MAX_VALUE; i++) {
						bar.setValue(i);
//						if(Thread.interrupted()) {
//							System.out.println("-------设置了中断标识-------");
//							System.out.println("再次用静态方法判断："+Thread.interrupted());
//							break;
//						}
						if(this.isInterrupted()) {
							System.out.println("-------设置了中断标识-------");
							System.out.println("用实例方法判断："+this.isInterrupted());
							break;
						}
						//Thread.sleep(300);
					}
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
			}
		};

		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.start();
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();

			}
		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		Interrupter i = new Interrupter();
	}
}
