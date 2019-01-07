package com.thzhima.eye025.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.thzhima.eye025.bean.Abstract;
import com.thzhima.eye025.dao.AbstractDAO;
import com.thzhima.eye025.dao.JdbcTemplate;
import com.thzhima.eye025.dao.ResultSetExtractor;

public class AbstractService {

	public static boolean publish(String content, boolean publishStatus, String... pictures) {
		boolean ok = true;

		try {
			if (publishStatus) { // 如果当前发布的文章是要发布出去的。其它的文章要取消发布状态。
				removeAllPublishStatus();
			}
			String sql = "insert into abstract(content, publish_status) values (?,?)";
			AbstractDAO.insert(sql, content, publishStatus);
			
			if(null != pictures) {
				for(int i=0;i<pictures.length;i++) {
					String upsql = "update abstract set picture"+(i+1)+"=? where content=? and publish_status=?";
					AbstractDAO.update(upsql, pictures[i], content,publishStatus);
				}
			}
			
		} catch (SQLException e) {
			ok = false;
			e.printStackTrace();
		}
		return ok;
	}

	public static boolean removeAllPublishStatus() {
		boolean ok = true;
		String sql = "update abstract set publish_status=0";
		try {
			int count = AbstractDAO.update(sql, null);
			if (count < 0) {
				ok = false;
			}
		} catch (SQLException e) {
			ok = false;
			e.printStackTrace();
		}
		return ok;
	}
	
	public static int setPublishStatus(int id) throws SQLException {
		removeAllPublishStatus();
		String sql = "update abstract set publish_status=1 where id=?";
		return AbstractDAO.update(sql, id);
	}
	
	public static List<Abstract> listAll() throws SQLException{
		String sql = "select * from abstract";
		return AbstractDAO.select(sql, null);
	}
	
	public static int delByID(int id) throws SQLException {
		String sql = "delete from abstract where id=?";
		return AbstractDAO.update(sql, id);
	}
	
	public static Abstract getAbstract() throws SQLException {
		String sql = "select * from abstract where publish_status=1";
		ResultSetExtractor<Abstract> ext = new ResultSetExtractor<Abstract>() {
			
			@Override
			public Abstract extract(ResultSet rst) throws SQLException {
				if(rst.next()) {
					int id = rst.getInt("id");
					String picture1 = rst.getString("picture1");
					String picture2 = rst.getString("picture2");
					String picture3 = rst.getString("picture3");
					String content = rst.getString("content");
					Date publishDate = rst.getDate("publish_date");
					boolean publishStatus = rst.getBoolean("publish_status");
					
					return new Abstract(id, picture1, picture2, picture3, publishStatus, publishDate, content);
					
				}
				return null;
			}
		};
		
		return JdbcTemplate.select(sql, ext);
	}
	
}
