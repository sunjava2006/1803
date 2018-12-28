package com.thzhima.eye025.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库模板类
 * @description 数据库操作的模板类，提供公共的数据库JDBC操作功能。
 * 最大化将用户公共相同的代码抽取出来，在这里实现。
 * 用户在访问数据库时，只要写必须的部分就可以了。
 * @author wangrui
 * @version 1.0
 */
public class JdbcTemplate {

	private static final String name = "eye025"; // 数据类用户名
	private static final String password = "123456"; // 数据库用户密码
	private static final String url = "jdbc:mariadb://localhost:3306/eye025"; // 连接数据库的URL
	private static final boolean load;
	
	static {
		boolean ok = true;
		try {
			Class.forName("org.mariadb.jdbc.Driver");  // 注册驱动
		} catch (ClassNotFoundException e) {
			ok = false;
			e.printStackTrace();
		} finally {
			load = ok;
		}
	}
	
	private static Connection getConn() throws SQLException {
		Connection conn = null;
		if(load) {
			conn = DriverManager.getConnection(url, name, password); // 	获取连接对象。
		}
		return conn;
	}
	
	
	public static int update(String sql) throws SQLException {
		int count = -1;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = getConn();
			stm = conn.createStatement();
			count = stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw e;
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
	
	public static int update(String sql, Object...args) throws SQLException {
		int count = -1;
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = getConn();
			conn.setAutoCommit(false); // 关闭自动提交事务
			stm = conn.prepareStatement(sql);
			if(args != null) {
				for(int i=0; i<args.length; i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			count = stm.executeUpdate();
			conn.commit(); // 提交事务
		} catch (SQLException e) {
			conn.rollback(); //  回滚事务。
			throw e;
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true); // 恢复默认值。
				conn.close();
			}
		}
		
		return count;
	}
	
	
	public static Map<String, Object> selectOne(String sql, Object...args) throws SQLException{
		Map<String, Object> m = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		
		try {
			conn = getConn();
			stm = conn.prepareStatement(sql);
			if(null != args) {
				for(int i=0; i<args.length; i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			rst = stm.executeQuery(); // 查询
			ResultSetMetaData metaData = rst.getMetaData(); // 取得元数据对象。
			int clCnt = metaData.getColumnCount(); // 从元数据中获取，查询了多少个列。
			
			if(rst.next()) {
				m = new HashMap<>();
				for(int i=1; i<=clCnt; i++) {
					Object val = rst.getObject(i); // 取i列的值
					String colName = metaData.getColumnLabel(i); // 从元数据中取i列的列名。
					
					m.put(colName, val); // 将列名和对应的值，存入map中。
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rst!= null) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return m;
	}
}
