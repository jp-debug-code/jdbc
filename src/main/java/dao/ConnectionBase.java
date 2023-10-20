package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		final String url = "jdbc:mysql://localhost:3306/db1?characterEncoding=UTF-8";
		//DBユーザ
		final String username = "user1";
		final String password = "pass1";
		//接続
		Connection con = null;
		//ドライバのロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Start");
		con = DriverManager.getConnection(url, username, password);
		return con;

	}

}
