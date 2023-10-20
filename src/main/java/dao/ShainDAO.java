package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ShainBean;
//ConnectionBaseを継承
public class ShainDAO extends ConnectionBase {
	/**
	* 社員IDから社員Beanを取得
	* @param con, shain_id
	* @return int ShainBean
	* @throws SQLException
	*/
	public ShainBean getShain(Connection con, String shain_id) throws SQLException {
		//社員Beanの初期化
		ShainBean shainBean = new ShainBean();

		//社員IDで取得するSQL
		final String sql = "select shain.id, shain.name, bu.name, shain.enter_date "
				+ "from shain_master shain, bu_master bu where shain.bu_id = bu.bu_id and shain.id=?";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, shain_id);

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
					String shain_name = rs.getString("shain.name");
					String bu_name = rs.getString("bu.name");
					String enter_date = rs.getString("shain.enter_date");

					//取得した値を社員Beanにセット
					shainBean.setShain_id(shain_id);
					shainBean.setShain_name(shain_name);
					shainBean.setBu_name(bu_name);
					shainBean.setEnter_date(enter_date);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return shainBean;
	}
    
/**
* 全社員を取得
* @param con
* @return shainList
* @throws SQLException
*/
public ArrayList<ShainBean> getAllShain(Connection con) throws SQLException {
	//ArrayListの初期化
	ArrayList<ShainBean> shainList = new ArrayList<ShainBean>();

	//社員IDで取得するSQL
	final String sql = "select shain.id, shain.name, bu.name, shain.enter_date "
			+ "from shain_master shain, bu_master bu where shain.bu_id = bu.bu_id";

	//SQL実行の準備
	try (PreparedStatement stmt = con.prepareStatement(sql);) {

		//SQL実行
		try (ResultSet rs = stmt.executeQuery();) {

			//取得した行数を繰り返す
			while (rs.next()) {

				//社員Beanの初期化
				ShainBean shainBean = new ShainBean();

				//値を取得
				String shain_id = rs.getString("shain.id");
				String shain_name = rs.getString("shain.name");
				String bu_name = rs.getString("bu.name");
				String enter_date = rs.getString("shain.enter_date");

				//取得した値を社員Beanにセット
				shainBean.setShain_id(shain_id);
				shainBean.setShain_name(shain_name);
				shainBean.setBu_name(bu_name);
				shainBean.setEnter_date(enter_date);

				//リストに社員Beanの追加
				shainList.add(shainBean);

			}

		}
	} catch (SQLException e) {
		System.out.println("SQLException: " + e.getMessage());
		System.out.println("SQLState: " + e.getSQLState());
		System.out.println("VendorError: " + e.getErrorCode());
		e.printStackTrace();
		throw e;
	}

	return shainList;
}
}
	
//	public ShainBean getShain(Connection con, String shain_id) throws SQLException {
//		//社員Beanの初期化
//		ShainBean shainBean = new ShainBean();
//
//		//社員IDで取得するSQL
//		final String sql = "select shain.id, shain.name, bu.name, shain.enter_date "
//				+ "from shain_master shain, bu_master bu where shain.bu_id = bu.bu_id and shain.id=?";
//
//		//SQL実行の準備
//		try (PreparedStatement stmt = con.prepareStatement(sql);) {
//			stmt.setString(1, shain_id);
//
//			//SQL実行
//			try (ResultSet rs = stmt.executeQuery();) {
//
//				//SQLで検索でいると、if文の中に入る
//				if (rs.next()) {
//
//					//一行目の値を取得
//					String shain_name = rs.getString("shain.name");
//					String bu_name = rs.getString("bu.name");
//					String enter_date = rs.getString("shain.enter_date");
//
//					//取得した値を社員Beanにセット
//					shainBean.setShain_id(shain_id);
//					shainBean.setShain_name(shain_name);
//					shainBean.setBu_name(bu_name);
//					shainBean.setEnter_date(enter_date);
//
//				}
//
//			}
//		} catch (SQLException e) {
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//			System.out.println("VendorError: " + e.getErrorCode());
//			e.printStackTrace();
//			throw e;
//		}
//
//		return shainBean;
//	}
//
//public  ArrayList<ShainBean> getAllShain(Connection con)throws SQLException{
//	ArrayList<ShainBean> shainlist = new ArrayList<ShainBean>();
//	
//	final String sql="select shain.id, shain.name, bu.name, shain.enter_date "				
//			+ "from shain_master shain, bu_master bu where shain.bu_id = bu.bu_id";
//	//final String sql = "select shain.id, shain.name, bu.name, shain.enter_date "
//		//	+ "from shain_master shain, bu_master bu where shain.bu_id = bu.bu_id";
//	try(PreparedStatement stmt =con.prepareStatement(sql);){
//		try(ResultSet rs= stmt.executeQuery();){
//			
//		
//		//取得した行数を繰り返す
//			while (rs.next()) {
//				//値の取得
//				ShainBean shainBean= new ShainBean();
//				String shain_id=rs.getString("shain.id");
//				String shain_name=rs.getString("shain.name");
//				String bu_name=rs.getString("bu.name");
//				String enter_date=rs.getString("shain.enter_date");
//				
//				//取得した値を社員Beanにセット
//				shainBean.setBu_name(bu_name);
//				shainBean.setEnter_date(enter_date);
//				shainBean.setShain_id(shain_id);
//				shainBean.setShain_name(shain_name);
//				//リストに社員Beanを追加
//				shainlist.add(shainBean);
//				
//				
//				
//			}
//		}catch (SQLException e) {
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//			System.out.println("VendorError: " + e.getErrorCode());
//			e.printStackTrace();
//			throw e;
//		}
//		return shainlist;
//	
//}
//}
//
//
//}
