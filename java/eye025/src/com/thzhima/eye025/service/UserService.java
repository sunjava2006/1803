package com.thzhima.eye025.service;

import java.sql.SQLException;
import java.util.Map;

import com.thzhima.eye025.bean.Sysadmin;
import com.thzhima.eye025.dao.SysadminDAO;

public class UserService {

	public static boolean updateUserInfo(String name, String adminName, String pwd,boolean isSuperAdmin,int id) {
		boolean ok = true;
		String sql = "update sys_admin set name=?, admin_name=?, password=md5(?), super_admin=? where id=?";
		try {
			int count = SysadminDAO.update(sql, name, adminName, pwd, isSuperAdmin, id);
			if(count != 1) {
				ok = false;
			}
		} catch (SQLException e) {
			ok = false;
			e.printStackTrace();
		}
		return ok;
	}
	
	public static Sysadmin login(String adminName, String pwd) throws SQLException {
		Sysadmin u = null;
		
		String sql = "select * from sys_admin where admin_name=? and password=md5(?)";
		
		Map<String, Object> m = SysadminDAO.selectOne(sql, new Object[] {adminName, pwd});
		
		if(null != m) {
			int id = (int) m.get("id");
			String name = (String) m.get("name");
			boolean superAdmin = ((int)(m.get("super_admin"))==1?true : false);
			u = new Sysadmin(id, name, pwd, adminName, superAdmin);
		}
		
		return u;
	}
	
	public static void main(String[] args) throws SQLException {
//		System.out.println(updateUserInfo("张不亮", "BL", "123456", false, 8));
		
		System.out.println(login("BL", "123456"));
	}
}
