package com.thzhima.advance.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

	public static void main(String[] args) throws IOException {
		
		System.out.println((int)'\n');
		System.out.println((int)'\r');
		ServerSocket ss = new ServerSocket(8088);
		//SocketAddress address = 
		
		Socket socket = ss.accept(); // Socket 对象表示的一个TCP连接.
		InputStream in = socket.getInputStream();
		
		int val = -1;
		String req = "";
		while( (val = in.read()) != -1) {
			req+=((char)val);
			
			if(req.length()>4) {
				String end = req.substring(req.length()-4);
				
				if("\r\n\r\n".equals(end) ){
					
					break;
				}
			}
			
		}
		System.out.println(req);
		
		//----------------------------------------------------
		OutputStream out = socket.getOutputStream();
		byte[] b = null;
		b = ("HTTP/1.1 200 \n" + 
				"Content-Type: text/html;charset=UTF-8\n" + 
				"Transfer-Encoding: chunked\n" + 
				"Date: Fri, 21 Dec 2018 06:18:57 GMT\n" + 
				"\n" + 
				"2000\r\n<h1>Hello</h1>\r\n0\r\n\r\n").getBytes();
		out.write(b);
		
		
		
		// 资源释放
		out.flush();
		out.close();
		in.close();
		socket.close();
		ss.close();
		System.out.println("========over======");
		
	}
}
