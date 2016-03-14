package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

/**
 * 管理者ログインする為のDAOクラス
 * @author TAKESHI BANSHOU
 * @version 1.0
 * @since 1.0
 */
public class AdminLoginDAO {

	/**
	 * true/falseのいずれかを格納する変数
	 */
	private boolean res;

	/**
	 * データベース接続
	 */
	private Connection con;

	/**
	 * sql文
	 */
	private String sql;

	/**
	 * sql文を送るための準備
	 */
	private PreparedStatement ps;

	/**
	 * 結果を格納する変数
	 */
	private ResultSet rs;

    /**
     * 受け取った値でopenconnectDB内adminテーブルを検索し、検索結果が有るかどうかを判別するメソッド
     * @param adminId 管理者ID
     * @param password パスワード
     * @return res 検索結果を返します。
     */
    public boolean check(String adminId, String password){
        res = false;
        try{
            con = MySQLConnector.getConnection("openconnect");
            sql = "SELECT * FROM admin WHERE admin_id = ? AND password= ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,adminId);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                res = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
}