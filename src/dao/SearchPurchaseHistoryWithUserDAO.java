package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.AdminPurchaseHistoryDTO;
import util.MySQLConnector;

/**
 * 検索したユーザーIDをもとに、関連する購入履歴を取得するクラス
 * @author Yuki Hoshino
 * @since 1.0
 * @version 1.0
 */
public class SearchPurchaseHistoryWithUserDAO {

	/**
	 * 購入履歴一覧を格納するリスト
	 */
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();

	/**
	 * データベースに接続し、検索したユーザーIDをもとにramenデータベースのhistoryテーブルから関連する購入履歴一覧を取得するメソッド
	 * @param userId 検索したユーザーID
	 * @return res 取得できたらtrue、できなかったらfalseを返します。
	 */
	public boolean selectUserId(int userId){
		boolean res = true;
		Connection con=MySQLConnector.getConnection("ramen");
		String sql = "SELECT * FROM history WHERE user_id = '"+userId+"'";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while(rSet.next()){
				AdminPurchaseHistoryDTO dto = new AdminPurchaseHistoryDTO();
				dto.setSalesId(rSet.getInt("sales_id"));
				dto.setUserId(rSet.getInt("user_id"));
				dto.setItemName(rSet.getString("item_name"));
				dto.setNumberOfItem(rSet.getInt("number_of_items"));
				dto.setDateTime(rSet.getString("purchase_date"));
				dto.setPostalCode(rSet.getString("postal_code"));
				dto.setAddress(rSet.getString("addless"));
				historyList.add(dto);
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * 購入履歴一覧を取得するメソッド
	 * @return 購入履歴一覧のリスト
	 */
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}

	/**
	 * 購入履歴を格納するメソッド 購入履歴一覧のリスト
	 * @param historyList
	 */
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
}
