package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;
/**
 * 商品情報をデータベースに追加する為のDAOクラス
 * @author HARUKI NAKAGAWA
 * @version 1.0
 * @since 1.0
 */
public class AdminAddItemDAO {

    /**
     * MySQLに接続
     */
    private Connection con;

    /**
     * SQL文
     */
    private String sql;

    /**
     * SQL分を送るための準備
     */
    private PreparedStatement ps;

    /**
     * データベースから取得した結果
     */
    private int count;

    /**
     * ramenデータベースのramen_item商品情報を追加する為のメソッド
     * @param itemName 商品名
     * @param explanation 商品詳細
     * @param price 価格
     * @param category カテゴリー
     * @param itemStock 商品在庫
     * @param imgPath 画像パス
     * @return count 処理が成功したら1、失敗なら0を返す。
     * @throws SQLException データベース、アクセスエラーに関する例外
     */
    public int addItem(String itemName,String explanation,String category,int price,int itemStock,String imgPath) throws SQLException{
        count = 0;
        try{
            con = (Connection)MySQLConnector.getConnection("ramen");
            sql = "INSERT INTO ramen_items"
                    + "(item_name,explanation,category,price,item_stock,img_path)"
                    + "VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,itemName);
            ps.setString(2,explanation);
            ps.setString(3,category);
            ps.setInt(4,price);
            ps.setInt(5,itemStock);
            ps.setString(6,imgPath);
            count = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            con.close();
        }
        return count;
    }
}