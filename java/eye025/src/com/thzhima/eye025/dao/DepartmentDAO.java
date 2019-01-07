package com.thzhima.eye025.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO {
	public static void add() throws IOException {
		String sql = "insert into department(name, picture, content) values(?,?,?)";
		InputStream a = null;
		
		try {
			a = new FileInputStream("/home/wangrui/下载/1.jpg");
			JdbcTemplate.update(sql, "K1", a, "介绍");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			a.close();
		}
	}

	public static void main(String[] args) throws IOException, SQLException {
		String sql = "select * from department where id =?";
		ResultSetExtractor ext = new ResultSetExtractor<String>() {

			@Override
			public String extract(ResultSet rst) throws SQLException {
				
				while(rst.next()) {
					try {
						int id = rst.getInt(1);
						byte[] picture = rst.getBytes("picture");
						FileOutputStream out = new FileOutputStream("/home/wangrui/out.jpg");
						out.write(picture);
						
						out.flush();
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					} 
					
				}
				
				return null;
			}
		};
		
		JdbcTemplate.select(sql, ext, 7);
	}
}
