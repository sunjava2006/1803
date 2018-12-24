package com.thzhima.advance.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 8080);
		
		OutputStream out = client.getOutputStream(); // 输出流对象
		
		byte[] b = null;
		String msg = "GET /?name=wang HTTP/1.1\n" + 
				"Host: localhost:8088\n" + 
				"Connection: keep-alive\n" + 
				"Cache-Control: max-age=0\n" + 
				"Upgrade-Insecure-Requests: 1\n" + 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\n" + 
				"Accept-Encoding: gzip, deflate, br\n" + 
				"Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\r\n\r\n";
		
		b = msg.getBytes();
		out.write(b);
		
		InputStream in = client.getInputStream();
		
		byte[] buffer = new byte[1024*1024*1024];
		int length = in.read(buffer);
		
		String resMsg = new String(buffer, 0, length, "utf-8");
		
		System.out.println(resMsg);
		
		
		//==============================================
		in.close();
		out.close();
		client.close();
	}
}
