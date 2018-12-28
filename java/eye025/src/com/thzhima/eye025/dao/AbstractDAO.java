package com.thzhima.eye025.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thzhima.eye025.bean.Abstract;

public class AbstractDAO {

	public static int insert(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static int update(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static List<Abstract>  select(String sql, Object...args) throws SQLException {
		
		ResultSetExtractor<List<Abstract>> ext = new ResultSetExtractor<List<Abstract>>() {
			
			@Override
			public List<Abstract> extract(ResultSet rst) throws SQLException {
				List<Abstract> list = new ArrayList<>();
				while(rst.next()) {
					int id = rst.getInt("id");
					String content = rst.getString("content");
					boolean publishStatus = rst.getBoolean("publish_status");
					String picture1 = rst.getString("picture1");
					String picture2 = rst.getString("picture2");
					String picture3 = rst.getString("picture3");
					Date publishDate = rst.getDate("publish_date");
					
					Abstract abs = new Abstract(id, picture1, picture2, picture3, publishStatus, publishDate);
					list.add(abs);
					
				}
				return list;
			}
		};
		
		
		return (List<Abstract>) JdbcTemplate.select(sql, ext, args);
	}
	
	public static void main(String[] args) throws SQLException {
		List<Abstract> list = select("select * from abstract", null);
		System.out.println(list);
	}
}
