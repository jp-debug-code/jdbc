package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ShainBean;
import dao.ShainDAO;


	//1社員取得メソッド
public class ShainLogic {
    
//1社員取得メソッド
public ShainBean getShain(String shain_id) throws SQLException, ClassNotFoundException {

//社員IDのチェック(数字以外がないか)
boolean isNumeric = shain_id.matches("[+-]?\\d*(\\.\\d+)?");
if (!isNumeric) {
	throw new IllegalArgumentException("数字以外が入っています");
}
try (Connection con = ShainDAO.getConnection();) {

	//社員DAOの初期化
	ShainDAO shainDao = new ShainDAO();
	//データベースに接続して、社員報を取得
	return shainDao.getShain(con, shain_id);
}
}

//全社員取得メソッド
public ArrayList<ShainBean> getAllShain() throws SQLException, ClassNotFoundException {
try (Connection con = ShainDAO.getConnection();) {
	//社員DAOの初期化
	ShainDAO shainDao = new ShainDAO();
	//データベースに接続して、全社員の一覧情報を取得
	return shainDao.getAllShain(con);
}
}
};
  
