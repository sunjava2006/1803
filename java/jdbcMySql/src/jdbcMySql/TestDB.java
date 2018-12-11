package jdbcMySql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		Connection conn = null; // 数据库连接的接口。
		ResultSet rst = null;
		Statement stm = null;
		
		try {
			// 1、安装MariaDB JDBC驱动
			Driver driver = new org.mariadb.jdbc.Driver(); // 子类为Driver接口，提供了实现。运行时多态。
			DriverManager.registerDriver(driver); // 注册驱动

			// 2、获取数据库连接
			
			String url = "jdbc:mariadb://127.0.0.1:3306/eye025";
			String user = "eye025";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password); // 获取连接对象。该对象是访问数据库的核心。

			// 3、获取语句对象，向数据库发送SQL语句
			
			stm = conn.createStatement(); // 连接对象，创建语句对象。
			String sql = "select * from t_users";

			
			rst = stm.executeQuery(sql); // 执行查询语句，语句对象将SQL语句，发送给数据库以执行。返回查询的结果集对象。

			// 4、处理（查询）返回的结果。结果集对象，是一个基于连接的对象。其中存储的查询结果的游标（指针）
			while (rst.next()) {
				int id = rst.getInt(1);
				String userName = rst.getString(2);
				String pwd = rst.getString(3);
				Date birthday = rst.getDate(4);

				System.out.println("id:" + id + ", user_name:" + userName + ", pwd:" + pwd + ", birthday:" + birthday);
			}
		} catch (Exception e) {
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

	}
}
