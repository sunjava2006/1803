package com.thzhima.eye025.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String userName = "eye025";
	private static final String password = "123456";
	private static final String url = "jdbc:mariadb://localhost:3306/eye025";
	private static final boolean LOAD_DRIVER ;
	
	static {
		boolean ok = true;
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // 注册驱动，加载类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			ok = false;
		}	
		finally {
			LOAD_DRIVER = ok;
		}
	}
    
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		if(LOAD_DRIVER) {
			conn = DriverManager.getConnection(url, userName, password);
		}else {
			throw new ClassNotFoundException("mariadb 驱动加载异常。");
		}
		return conn;
	}
	
	private ConnectionUtil() {
		
	}
}
