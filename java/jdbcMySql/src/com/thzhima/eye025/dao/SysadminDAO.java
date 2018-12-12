package com.thzhima.eye025.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SysadminDAO {

	public Map<String, Object> login(String adminName, String password) throws SQLException  {
		Map<String, Object> map = null;
		Driver driver  = new org.mariadb.jdbc.Driver();
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		String url = "jdbc:mariadb://localhost:3306/eye025";
		String user = "eye025";
		String pwd = "123456";
		String sql = "select * from sys_admin where admin_name='" + adminName + "' and password=md5('" + password + "')";
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			
			if(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				int superAdmin = rst.getInt("super_admin");
				
				map = new HashMap<>();
				map.put("id", id);
				map.put("name", name);
				map.put("admin_name", adminName);
				map.put("password", password);
				map.put("super_admin", superAdmin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}

		return map;
	}
	

	
	public int divide(int a , int b)throws Exception {
		if(0 == b) {
			throw new Exception("参数b,不能为0.");
		}else {
			return a/b;
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		SysadminDAO dao = new SysadminDAO();
		Map m = dao.login("ying","123456");
		System.out.println(m);
		
				
	}
	
	
}
