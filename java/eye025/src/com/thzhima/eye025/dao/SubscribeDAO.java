package com.thzhima.eye025.dao;

import java.sql.SQLException;
import java.util.Date;

import com.thzhima.eye025.util.Util;

public class SubscribeDAO {

	public static int add(String name, String connect, String email, String gender, int age, String item, Date date, String description) throws SQLException {
		int count = -1;
		String sql = "insert into subscribe (name, connect, email, gender, age, item, date, description)"
				+ " values (?,?,?,?,?,?,?,?)";
		JdbcTemplate.update(sql,name, connect, email, gender, age, item, date, description);
		
		return count;
	}
	
	public static void main(String[] args) throws SQLException {
		add("王小光", "13012345678", "wxg@qq.com", "男", 33, "双眼皮", Util.parseDate("2019-5-5"), "好看。..");
	}
}
