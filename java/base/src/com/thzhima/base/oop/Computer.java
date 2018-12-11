package com.thzhima.base.oop;

public class Computer {
	String CPU;
	String brand;
	float speed;
	int memorySize;
	int hdSize;
	
	public Computer(String brand, String CPU, float speed, int memory, int hd) {
		this.brand = brand;
		this.speed = speed;
		this.memorySize = memory;
		this.hdSize = hd;
	}

	public Computer() {
		
	}
	
	public void playMusic(String music) {
		System.out.println("play music: "+ music);
	}
		
	public void playMusic(int times, String music)  {
		for(int i=0;i<times; i++)
		System.out.println("play music: "+ music);
	}
	
//	public void playMusic(int times2, String music)  {
//		for(int i=0;i<times2; i++)
//		System.out.println("play music: "+ music);
//	}

	public void playMusic(String music, int times) {
		for(int i=0;i<times; i++)
		System.out.println("play music: "+ music);
	}
	
	public void editText(String txt) {
		System.out.println("edit text "+ txt  +"now");
	}
	
	public static void main(String[] args) {
		Computer c = new Computer("Lenovo", "Intel", 2.2F, 16, 1000);
		
		c.playMusic("我的祖国");
		c.editText("java 教程");
	}
}
