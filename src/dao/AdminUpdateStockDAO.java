package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

/**
 * 商品をデータベースに追加するDAOクラス
 * @author KAZUNORI KUDO
 * @version 1.0
 * @since 1.0
 **/
public class AdminUpdateStockDAO {

    /**
     * データベースへの接続
     */
    private Connection con;

    /**
     * SQL文
     */
    private String sql;

    /**
     * SQL文を送るための準備
     */
     private PreparedStatement ps;

    /**
     * 更新件数
     */
    private int count;

    /**
     * 商品をデータベースに追加するクラス
     * @param itemId 商品ID
     * @param itemStock 商品在庫
     * @return count 追加した商品の数を返します。
     */
    public int update(int upItemId, int upItemStock){
        try{
            con = (Connection)MySQLConnector.getConnection("ramen");
            sql = "update ramen_items set item_stock = ? where item_id = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, upItemId);
            ps.setInt(2, upItemStock);
            count = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
}