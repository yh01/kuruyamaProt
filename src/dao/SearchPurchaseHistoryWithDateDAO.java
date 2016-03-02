package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.AdminPurchaseHistoryDTO;
import util.MySQLConnector;

public class SearchPurchaseHistoryWithDateDAO {
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();
	public boolean selectSearchedDate(String purchaseDate){
		boolean res = true;
		Connection con=MySQLConnector.getConnection("ramen");
		String sql = "SELECT * FROM history WHERE (DATE_FORMAT(purchase_date, '%Y%m%d') = '"+purchaseDate+"') ";
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
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
}
