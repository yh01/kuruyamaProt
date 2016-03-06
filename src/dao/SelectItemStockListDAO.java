package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SelectItemStockListDTO;
import util.MySQLConnector;

public class SelectItemStockListDAO {


	public List<SelectItemStockListDTO> D3GraphList = new ArrayList<SelectItemStockListDTO>();
	SelectItemStockListDTO dto = new SelectItemStockListDTO();

	public boolean select(){
		boolean result = true;
		MySQLConnector dbConnection = new MySQLConnector();
		Connection con = dbConnection.getConnection("ramen");

		try{
			String sql = "SELECT item_name,item_stock from ramen_items ORDER BY item_id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();

			while(rSet.next()){
				SelectItemStockListDTO dto = new SelectItemStockListDTO();
				dto.setItemName(rSet.getString(1));
				dto.setItemStock(rSet.getInt(2));
				D3GraphList.add(dto);
			}
		}catch(SQLException e){
			result = false;
			return result;
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				result = false;
				return result;
			}
		}
		return result;
	}
	public List<SelectItemStockListDTO> getD3GraphList() {
		return D3GraphList;
	}

	public void setD3GraphList(List<SelectItemStockListDTO> d3GraphList) {
		D3GraphList = d3GraphList;
	}

	public SelectItemStockListDTO getDto() {
		return dto;
	}

	public void setDto(SelectItemStockListDTO dto) {
		this.dto = dto;
	}
}
