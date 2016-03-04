package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.D3SelectListDTO;
import util.D3DBConnector;

public class D3SelectListDAO {


	public List<D3SelectListDTO> D3GraphList = new ArrayList<D3SelectListDTO>();
	D3SelectListDTO dto = new D3SelectListDTO();

	public boolean select(){
		boolean result = true;
		D3DBConnector dbConnection = new D3DBConnector();
		Connection con = dbConnection.getConnection("d3SelectListTest");

		try{
			String sql = "SELECT itemName,salesAmount from d3select ORDER BY id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();

			while(rSet.next()){
				D3SelectListDTO dto = new D3SelectListDTO();
				dto.setItemName(rSet.getString(1));
				dto.setSalesAmount(rSet.getInt(2));
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
	public List<D3SelectListDTO> getD3GraphList() {
		return D3GraphList;
	}

	public void setD3GraphList(List<D3SelectListDTO> d3GraphList) {
		D3GraphList = d3GraphList;
	}

	public D3SelectListDTO getDto() {
		return dto;
	}

	public void setDto(D3SelectListDTO dto) {
		this.dto = dto;
	}
}
