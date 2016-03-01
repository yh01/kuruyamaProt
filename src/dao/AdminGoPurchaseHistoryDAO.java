package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.AdminGoPurchaseHistoryDTO;
import util.MySQLConnector;

public class AdminGoPurchaseHistoryDAO {
	private ArrayList<AdminGoPurchaseHistoryDTO> historyList = new ArrayList<AdminGoPurchaseHistoryDTO>();
	public boolean selectAllHistoryData(){
		boolean res = true;
		Connection con=MySQLConnector.getConnection("ramen");
		String sql = "SELECT * FROM history";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while(rSet.next()){
				AdminGoPurchaseHistoryDTO dto = new AdminGoPurchaseHistoryDTO();
				dto.setSalesId(rSet.getInt("sales_id"));
				dto.setUserId(rSet.getInt("user_id"));
				dto.setItemName(rSet.getString("item_name"));
				dto.setNumberoOfItem(rSet.getInt("number_of_items"));
				dto.setDateTime(rSet.getString("purchase_date"));
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

	public ArrayList<AdminGoPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(ArrayList<AdminGoPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
}
