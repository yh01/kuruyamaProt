package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.MySQLConnector;

/**
 * ユーザーを削除するDAOクラス
 * @author KAZUHIRO YOSHIHARA
 * @since 1.0
 * @version 1.0
 */
public class AdminDeleteUserDAO {

    /**
     * MySQLに接続
     */
    private Connection con;

    /**
     * SQL文
     */
    private String sql;

    /**
     * アップデート回数を格納する変数
     */
    private int count;

    /**
     * SQL文の実行
     */
    private java.sql.Statement stm;
    /**
     * openconnectデータベースに接続しuserテーブルからIDの一致したユーザーを削除するメソッド
     * @param id 削除するユーザーのID
     * @return count 削除に成功した回数を返します。
     */
    public int delete(int id){
        try{
            con = (Connection)MySQLConnector.getConnection("openconnect");
            stm = con.createStatement();
            sql = "delete from user where id = '"+id+"'";
            count =stm.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
}
