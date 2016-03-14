package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.AdminUserDTO;
import util.MySQLConnector;

/**
 * ユーザーの検索を行うDAOクラス
 * @author KAZUHIRO YOSHIHARA
 * @since 1.0
 * @version 1.0
 */
public class AdminSearchUserDAO {

	/**
	 * MySQLに接続
	 */
	private Connection con;

	/**
	 * MySQLから取得した結果を格納
	 */
	private ResultSet rs;

	/**
	 * SQL文を送るための準備
	 */
	private PreparedStatement ps;

	/**
	 * SQL文
	 */
	private String sql;

	/**
	 * openconnectデータベースに接続しuserテーブル内と同じ名前を検索し、取得するメソッド
	 * @param name ユーザーの名前
	 * @return userList 格納したユーザーのリストを返します。
	 */
	public ArrayList<AdminUserDTO> searchUser(String name){
		ArrayList<AdminUserDTO> userList = new ArrayList<>();
		try{
			con = MySQLConnector.getConnection("openconnect");
			sql = "SELECT id, password, user_name, email, address, cell_number FROM user WHERE user_name LIKE '%?%'";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
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
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
}