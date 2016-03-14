package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.AdminItemDTO;
import util.MySQLConnector;
/**
 * 商品一覧画面に表示する情報を取得する為のDAOクラス
 * @author HARUKI NAKAGAWA
 * @version 1.0
 * @since 1.0
 */
public class AdminGoEditProductDAO {

	/**
	 * 商品リスト
	 */
	private ArrayList<AdminItemDTO> selectList = new ArrayList<>();

	/**
	 * MySQLに接続
	 */
	private Connection con;

	/**
	 * SQL文
	 */
	private String sql;

	/**
	 * 取得の結果
	 */
	boolean res;

	/**
	 * ramenデータベースのramen_itemから商品情報を取得する為のメソッド
	 * @return res 商品情報を取得できればtrue、できなければfalseを返す。
	 * @throws SQLException
	 */
	public boolean selectMySQL(){
		res = false;
		try{
			con = MySQLConnector.getConnection("ramen");
			sql = "SELECT * FROM ramen_items";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminItemDTO dto = new AdminItemDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setCategory(rs.getString("category"));
				dto.setPrice(rs.getInt("price"));
				dto.setItemStock(rs.getInt("item_stock"));
				dto.setImgPath(rs.getString("img_path"));
				selectList.add(dto);
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
	 * 商品リストを取得するクラス
	 * @return selectList 商品リスト
	 */
	public ArrayList<AdminItemDTO> getSelectList() {
		return selectList;
	}

	/**
	 * 商品リストを格納するクラス
	 * @param selectList 商品リスト
	 */
	public void setSelectList(ArrayList<AdminItemDTO> selectList) {
		this.selectList = selectList;
	}
}