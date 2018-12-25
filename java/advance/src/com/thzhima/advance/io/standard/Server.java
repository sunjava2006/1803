package com.thzhima.advance.io.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static void getMsg(Socket s) throws IOException {
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		try {

			in = s.getInputStream();
			inReader = new InputStreamReader(in);
			reader = new BufferedReader(inReader);

			String msg = reader.readLine();
			System.out.println(msg);

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			reader.close();
			inReader.close();
			in.close();
			s.close();
		}

	}

	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;

		ss = new ServerSocket(8088);
        for(int i=0;i<10;i++) {
        	Socket s = ss.accept();
    		getMsg(s);
        }
        ss.close();
		

	}
}
