package com.thzhima.advance.io.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Chat {
	
	private static void start() throws IOException {
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inReader);

		try {
			for (;;) {
				String str = reader.readLine(); // 从键盘获取内容。
				if(":exit".equals(str)) {
					break;
				}else {
					sendMsg(str); // 发送消息
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null!=reader) {
				reader.close();
			}
			if(null != inReader) {
				inReader.close();
			}
		}

	}
	
	private static void sendMsg(String msg) throws IOException {
		Socket s = new Socket();
		SocketAddress address = new InetSocketAddress("localhost", 8088);
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		
		try {
			s.connect(address);
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			
			outWriter.write(msg+"\n");
			outWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outWriter.close();
			out.close();
			s.close();
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		
		Chat.start();
		
		
		

	}
}


