package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ShainBean;
import dao.ShainDAO;

public class TestShainDAO {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try(Connection con = ShainDAO.getConnection();){
			//DAO 初期化
			ShainDAO shainDAO=new ShainDAO();
			String shain_id="0001";
			
			
			ShainBean shainBean=shainDAO.getShain(con,shain_id);
			System.out.println("社員ID：" + shainBean.getShain_id());
			System.out.println("社員名：" + shainBean.getShain_name());
			System.out.println("部署名：" + shainBean.getBu_name());
			System.out.println("入社日：" + shainBean.getEnter_date());
			
			
			
			
			
			
			
			ArrayList<ShainBean> shainList = new ArrayList<ShainBean>();
			
			shainList=shainDAO.getAllShain(con);
			
			for(ShainBean shain: shainList) {
				System.out.println("------------------------------------------");
				System.out.println("社員ID：" + shain.getShain_id());
				System.out.println("社員名：" + shain.getShain_name());
				System.out.println("部署名：" + shain.getBu_name());
				System.out.println("入社日：" + shain.getEnter_date());
			}
			
		}catch(SQLException |  ClassNotFoundException e) {
		e.printStackTrace();
		}catch(IllegalArgumentException e) {// IllegalArgumentException→パラメータ値が不適切
			System.out.println("IDエラー"  + e.getMessage());
			
		}
		
		
		}
	

	}


