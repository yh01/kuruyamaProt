package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.AdminUserDTO;
import util.MySQLConnector;

/**
 * ユーザー一覧を取得するDAOクラス
 * @author KAZUHIRO YOSHIHARA
 * @since 1.0
 * @version 1.0
 */
public class AdminGoEditUserDAO {
    /**
     * ユーザー一覧を格納するリスト
     */
    private ArrayList<AdminUserDTO> userList = new ArrayList<>();

    /**
     * true/falseいずれかを格納する変数
     */
    private boolean result;

    /**
     * データベース接続
     */
    private Connection con;

    /**
     * sql文
     */
    private String sql;

    /**
     * SQL文を送るための準備
     */
    private PreparedStatement ps;

    /**
     * 結果を格納
     */
    private ResultSet rs;

    /**
     * openconnectデータベースに接続しuserテーブルからユーザー一覧を取得するメソッド
     * @return true/false 検索結果が1件以上ならtrue、0件またはデータベースに接続できなかったらfalseを返します。
     */
    public boolean selectAllUserData() {
        result = false;
        try {
            con = MySQLConnector.getConnection("openconnect");
            sql = "SELECT id, password, user_name, email,address, cell_number FROM user";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AdminUserDTO dto = new AdminUserDTO();
                dto.setId(rs.getInt("id"));
                dto.setPassword(rs.getString("password"));
                dto.setUserName(rs.getString("user_name"));
                dto.setMailAddress(rs.getString("email"));
                dto.setAddress(rs.getString("address"));
                dto.setCellNumber(rs.getString("cell_number"));
                userList.add(dto);
                result = true;
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
        return result;
    }

    /**
     * ユーザーリストを取得する為のメソッド
     * @return userList ユーザーリスト
     */
    public ArrayList<AdminUserDTO> getUserList() {
        return this.userList;
    }

    /**
     * ユーザーリストを格納する為のメソッド
     * @param userList ユーザーリスト
     */
    public void setUsertList(ArrayList<AdminUserDTO> userList) {
        this.userList = userList;
    }
}