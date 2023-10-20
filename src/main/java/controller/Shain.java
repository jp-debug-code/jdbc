package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ShainBean;
import model.ShainLogic;

/**
 * Servlet implementation class Shain
 */
@WebServlet("/Shain")
public class Shain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String shain_id = request.getParameter("shain_id");
		System.out.println("shain_id:"+ shain_id);
		
		
		//社員ロジックの初期化
				ShainLogic shainLogic = new ShainLogic();

				//社員リストのインスタンス化
				ArrayList<ShainBean> shainList = new ArrayList<ShainBean>();

				try {
					//全社員選択の場合
					if (shain_id.equals("all")) {
						shainList = shainLogic.getAllShain();
					}else {
							ShainBean shainBean = shainLogic.getShain(shain_id);
							shainList.add(shainBean);
							}
					
					//JSPへのkeyと値をセット
					request.setAttribute("shainList", shainList);
					//エラー処理
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
		//ShainLogicの初期化
//		ShainLogic shainlogic = new ShainLogic();
//		//社員情報をリストで持つ
//		ArrayList<ShainBean> shainList =new ArrayList<ShainBean>();
//		try {
//			if(shain_id.equals("all")) {
//				//allの場合はshainlogicを使いすべての社員情報を取り出す
//				shainList= shainlogic.getAllShain();
//			};
//			//JSPへのkeyと値をセット
//			request.setAttribute("shainList", shainList);
//		}catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
		//}
		
		
	
		
		//ページ転送
		request.getRequestDispatcher("/WEB-INF/shain.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
