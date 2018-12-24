package com.thzhima.advance.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileTools {
	public static void write(String data, String fileName, String charset) throws IOException {
		FileOutputStream fout = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter writer = null;
		
		try {
			fout = new FileOutputStream(fileName); // 字节
			outWriter  = new OutputStreamWriter(fout, charset); // 桥接流，指明字符集
			writer = new BufferedWriter(outWriter); // 字符
			
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				writer.close();
			}
			if(null != outWriter) {
				outWriter.close();
			}
			if(null != fout) {
				fout.close();
			}
		}
		
	}
	
	public static String readTxt(String fileName, String charset) throws IOException {
		String data = "";
		FileInputStream fin = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		
		try {
			fin = new FileInputStream(fileName);
			inReader = new InputStreamReader(fin, charset);
			reader = new BufferedReader(inReader);
			String s = null;
			while(null != (s = reader.readLine())) {
				data += s;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != reader) {
				reader.close();
			}
			if(null != inReader) {
				inReader.close();
			}
			if(null != fin) {
				fin.close();
			}
		}
		
		return data;
	}
	
	
	public static void write(String data, String fileName) throws IOException {
		FileWriter writer = null;
		File f = new File(fileName);
		File p = f.getParentFile();
		if(! p.exists()) {
			p.mkdirs();
		}

		try {
			writer = new FileWriter(f);
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				writer.close();
			}
		}
	}
	
	public static String readTxt(String name) throws IOException {
		String data = "";
		FileReader reader = null;
		
		try {
			reader = new FileReader(name);
			char[] buffer = new char[13];
			int count = -1;
			while(-1 !=(count=reader.read(buffer))) {
				String s = new String(buffer, 0, count);
				data += s;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != reader) {
				reader.close();
			}
		}
		
		
		return data;
	}
	
	
	
	
	
	//==========================================================================
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
	
	public static void copy(String source, String target) throws IOException {
		byte[] buffer = new byte[1048576];  // 创建一个1M 的缓冲区。
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(source); // 文件输入流
			File f = new File(target);   // 创建目标文件对象，目的，是测试是否需要为目标文件，建立父目录。
			File p = f.getParentFile();
			if(!p.exists()) {
				p.mkdirs();
			}
			out = new FileOutputStream(f);
			int count = -1;
			while(-1 != (count=in.read(buffer))) { // 一直读源文件，直到文件结束。读出的内容放入缓冲区。
				out.write(buffer, 0, count); // 将缓冲区的内容，写入目标文件。
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();
			}
			if(null != in) {
				in.close();
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
//		String fileName = "/home/wangrui/tmp/a.txt";
////		byte[] data = "hello World.你好java.".getBytes();
////		write(data, "/home/wangrui/tmp/a.txt");
//		
//		byte[] data = read(fileName);
//		String str = new String(data);
//		System.out.println(str);
//		copy("/home/wangrui/图片/1.png", "/home/wangrui/图片/png/2.png");
		
		
		write("大家好，这里是java学习课堂。欢迎大家来学习Java Web 应用程序开发课程。", "/home/wangrui/tmp/aa.txt",  "gbk");
		String s = readTxt("/home/wangrui/tmp/aa.txt", "gbk");
		System.out.println(s);
	}
}
