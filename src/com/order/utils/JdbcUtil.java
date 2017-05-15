package com.order.utils;
/*
 * 数据库连接实现类
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/order"; 
	private static String user = "root";    //数据库用户名
	private static String password = "123456";  //数据库密码
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		//加载驱动
		Class.forName(driver);
		//建立连接
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stm!=null){
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


