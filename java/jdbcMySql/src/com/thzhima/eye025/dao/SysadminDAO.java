package com.thzhima.eye025.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thzhima.eye025.bean.Sysadmin;

public class SysadminDAO {

	public static  Sysadmin login(String adminName, String password) throws Exception  {
	
		Sysadmin s = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		
		String sql = "select * from sys_admin where admin_name=? and password=md5(?)";
		
		System.out.println(sql);
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql);   // 使用预编译语句对象。 改变以给语句中变量的赋值方式。
			stm.setString(1, adminName);   // 先预编译语句，再给变量赋值。
			stm.setString(2, password);
			rst = stm.executeQuery();
			
			if(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				int superAdmin = rst.getInt("super_admin");
				
				s = new Sysadmin(id, name, adminName, password, superAdmin);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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

		return s;
	}
	

	public static int addUser(String name, String adminName, String password, boolean isSuperAdmin) throws SQLException {
		int count = -1;
		String sql = "insert into sys_admin(name, admin_name, password, super_admin) values (?,?,md5(?),?) ";
			
		
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, adminName);
			stm.setString(3, password);
			stm.setInt(4, isSuperAdmin?1:0);
			
			count = stm.executeUpdate(); // 增、删、改操作，都是调用executeUpdate方法。返回int值，表示该语句影响的行数。
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			if(null != conn) {
				conn.rollback();
			}
			
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		return count;
	}
	
	public static int updateUserWithID(String name, String adminName, String password, boolean isSuperAdmin, int id) throws SQLException {
		int count = -1;
		String sql = "update sys_admin set name='"+name+"', admin_name='"+adminName
				+"', password=md5('"+password+"'), super_admin="+(isSuperAdmin?1:0)+" where id=" + id;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return count;
	}
	
	public static int deleteWithID(int id) throws SQLException {
		int count = -1;
		String sql = "delete from sys_admin where id="+id;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return count;
	}
	
	
	
	public static void main(String[] args) throws Exception {
//		Sysadmin a = SysadminDAO.login("LiXin", "123456");  // 语句注入，侵入系统。语句注入的目的是，改变原来语句的意思。
//		System.out.println(a);
	   
		int count = SysadminDAO.addUser("张亮44", "ZhangLiang", "123456", true);
		System.out.println(count);
		

	
				
	}
	
	
}
