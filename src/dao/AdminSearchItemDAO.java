package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.AdminItemDTO;
import util.MySQLConnector;
/**
 * 商品情報を検索するDAOクラス
 * @author HARUKI NAKAGAWA
 * @version 1.0
 * @since 1.0
 */
public class AdminSearchItemDAO {

	/**
	 * trueかfalseを格納するための変数
	 */
	private boolean result;

	/**
	 * sql文を格納するための変数
	 */
	private String sql;

	/**
	 * データベース接続
	 */
	private Connection connection;

	/**
	 * SQL文を送るための準備
	 */
	private PreparedStatement ps;

	/**
	 * 結果を格納
	 */
	private ResultSet rs;

    /**
     * 商品情報リスト
     */
    private ArrayList<AdminItemDTO> selectList = new ArrayList<>();

    /**
     * 検索結果を元に、商品情報をramenデータベースのramen_itemsテーブルから取得する為のメソッド
     * @param itemName 商品名
     * @return result 商品情報の取得に成功したらtrue、失敗したらfalseを返します。
     */
    public boolean select(String itemName) {
       result = false;
     try {
    	 connection = MySQLConnector.getConnection("ramen");
         sql = "SELECT * FROM ramen_items WHERE item_Name = ?";
         ps = connection.prepareStatement(sql);
         ps.setString(1, itemName);
         rs = ps.executeQuery();
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
              result = true;
          }
          connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return result;
 }

    /**
     * 商品情報リストを取得するメソッド
     * @return selectList 商品情報リスト
     */
    public ArrayList<AdminItemDTO> getSelectList() {
        return selectList;
    }

    /**
     * 商品情報リストを格納するメソッド
     * @param selectList 商品情報リスト
     */
    public void setSelectList(ArrayList<AdminItemDTO> selectList) {
        this.selectList = selectList;
    }
}
