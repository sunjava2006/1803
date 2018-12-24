package com.thzhima.advance.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTools {
	
	public static void write(byte[] data, String fileName) throws IOException {
		
		FileOutputStream out = null;
		try {
			File f = new File(fileName);
			if(! f.exists()) {
				
				File dir = f.getParentFile();
				if(! dir.exists()) {
					System.out.println("================创建目标文件的父目录================");
					dir.mkdirs();
				}
				
				f.createNewFile();
				System.out.println("------------------创建目标文件----------------");
			}
			out = new FileOutputStream(fileName, true);
			out.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();
			}
		}
		
	}
	
	public static byte[] read(String fileName) throws IOException {
		byte[] buffer  = null;
		File f = new File(fileName);
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(f);
			buffer = new byte[in.available()];
			in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(null != in) {
				in.close();
			}
		}
		return buffer;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		String fileName = "/home/wangrui/tmp/a.txt";
//		byte[] data = "hello World.你好java.".getBytes();
//		write(data, "/home/wangrui/tmp/a.txt");
		
		byte[] data = read(fileName);
		String str = new String(data);
		System.out.println(str);
	}
}
