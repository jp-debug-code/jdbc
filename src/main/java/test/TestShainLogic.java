package test;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.ShainBean;
import model.ShainLogic;

public class TestShainLogic {

	public static void main(String[] args) {
		ShainLogic shainLogic= new ShainLogic();
		try {
			ShainBean shainBean = shainLogic.getShain("000x");
			//社員Beanのテスト結果（値を取得し、表示する）
			System.out.println("社員ID：" + shainBean.getShain_id());
			System.out.println("社員名：" + shainBean.getShain_name());
			System.out.println("部署名：" + shainBean.getBu_name());
			System.out.println("入社日：" + shainBean.getEnter_date());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch (IllegalArgumentException e) {
			System.out.println("IDエラー:" + e.getMessage());//Shainlogc 41行目をcatchしている
		}
		try {
			ArrayList<ShainBean> shainList= shainLogic.getAllShain();
			for (ShainBean shain : shainList) {
				System.out.println("------------------------------------------");
				System.out.println("社員ID：" + shain.getShain_id());
				System.out.println("社員名：" + shain.getShain_name());
				System.out.println("部署名：" + shain.getBu_name());
				System.out.println("入社日：" + shain.getEnter_date());
				
			}
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
		
	

	}

}
