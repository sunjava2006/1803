package com.thzhima.eye025.dao;

import java.sql.SQLException;
import java.util.Map;

public class SysadminDAO {

	public static int update(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static Map<String, Object> selectOne(String sql, Object[] args) throws SQLException {
		return JdbcTemplate.selectOne(sql, args);
	}
}
