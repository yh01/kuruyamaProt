package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

/**
 * 商品情報をデータベースから削除する為のDAOクラス
 * @author KUDO KAZUNORI
 * @version 1.0
 * @since 1.0
 */
public class AdminDeleteItemDAO {

    /**
     * 削除件数
     */
    private int res;

    /**
     * データベース接続
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
     * 商品情報を削除する為のメソッド
     * @param itemId 商品ID
     * @return res データベースの接続に成功した場合はtrue、失敗した場合はfalseを返します。
     */
    public int delete(int itemId){
        res = 0;
        try{
            con = (Connection)MySQLConnector.getConnection("ramen");
            sql = "delete from ramen_items where item_id =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,itemId);
            res = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
}