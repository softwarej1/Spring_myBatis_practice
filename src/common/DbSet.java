package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSet {
	static Connection conn;
	public static Connection getConnection(){
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String vUser = "hr";
		String vPassWord = "hr";
		try {
			conn =  DriverManager.getConnection(url, vUser, vPassWord);
			System.out.println("2단계 : DB연동 성공!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
}
