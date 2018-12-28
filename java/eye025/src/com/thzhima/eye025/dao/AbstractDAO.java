package com.thzhima.eye025.dao;

import java.sql.SQLException;

public class AbstractDAO {

	public static int insert(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static int update(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
}
