package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SelectItemStockListDTO;
import util.MySQLConnector;

/**
 * 商品編集画面の在庫数グラフを表示する為に必要な、商品名と在庫数をramenデータベースのramen_itemテーブルから取得するクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 *
 */
public class SelectItemStockListDAO {

	/**
	 * 商品名と在庫数を格納するリスト
	 */
	public List<SelectItemStockListDTO> D3GraphList = new ArrayList<SelectItemStockListDTO>();


	/**
	 * 商品名と在庫数を取得、格納するクラスのインスタンス
	 */
	SelectItemStockListDTO dto = new SelectItemStockListDTO();

	/**
	 *	データベースに接続し商品名と在庫数をramenデータベースのramen_itemテーブルから取得するメソッド
	 * @return result 取得できたらtrue、できなかったらfalseを返します。
	 */
	public boolean select(){
		boolean result = true;
		MySQLConnector dbConnection = new MySQLConnector();
		Connection con = dbConnection.getConnection("ramen");

		try{
			String sql = "SELECT item_name,item_stock,explanation from ramen_items ORDER BY item_id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();

			while(rSet.next()){
				SelectItemStockListDTO dto = new SelectItemStockListDTO();
				dto.setItemName(rSet.getString(1));
				dto.setItemStock(rSet.getInt(2));
				dto.setExplanation(rSet.getString(3));
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

	/**
	 * 商品名と在庫数を取得するメソッド
	 * @return D3GraphList 商品名と在庫数を格納するリスト
	 */
	public List<SelectItemStockListDTO> getD3GraphList() {
		return D3GraphList;
	}

	/**
	 * 商品名と在庫数を格納するメソッド
	 * @param d3GraphList 商品名と在庫数を格納するリスト
	 */
	public void setD3GraphList(List<SelectItemStockListDTO> d3GraphList) {
		D3GraphList = d3GraphList;
	}

	/**
	 * 商品名と在庫数を取得、格納するクラスのインスタンスを取得するメソッド
	 * @return dto 商品名と在庫数を取得、格納するクラスのインスタンス
	 */
	public SelectItemStockListDTO getDto() {
		return dto;
	}

	/**
	 * 商品名と在庫数を取得、格納するクラスのインスタンスを格納するメソッド
	 * @param dto 商品名と在庫数を取得、格納するクラスのインスタンス
	 */
	public void setDto(SelectItemStockListDTO dto) {
		this.dto = dto;
	}
}
