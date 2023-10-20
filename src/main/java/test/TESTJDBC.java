package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TESTJDBC {
	public static void main(String[] args)throws SQLException, ClassNotFoundException{
		//データベース接続
		final String url = "jdbc:mysql://localhost/db1?characterEncoding=UTF-8";
		//DBユーザ
		final String username ="user1";
		final String password ="pass1";
		
		//接続
		Connection con=null;
		//ドライバのロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Start");
		try {
			//接続の確立
			con = DriverManager.getConnection(url,username,password);
			System.out.println("接続成功");
		}catch(SQLException e) {
			System.out.println("接続失敗");
			e.printStackTrace();
		}finally{
			con.close();//接続を閉じる
			}
			
			
			
		}
		
	}


