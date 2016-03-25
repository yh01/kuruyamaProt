package com.internousdevwork.kuruyama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevwork.kuruyama.dto.LoginOauthDTO;
import com.internousdevwork.kuruyama.util.MySQLConnector;

/**
 * Oauthでログインに必要な情報を取得する為のDAOクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class LoginOauthDAO{

	/**
	 * 結果を格納するDTOクラス
	 */
	private LoginOauthDTO dto = new LoginOauthDTO();
	
    /**
     * データベースに接続するためのインターフェース
     */
    private Connection con;

    /**
    * SQL文
    */
    private String sql;

    /**
    * SQL文を実行するためのインターフェース
    */
    private PreparedStatement ps;

    /**
    * 結果を格納するインターフェース
    */
    private ResultSet rs;

	/**
	 * <p>データベース(openconnect)に接続し、取得した値(oauthId,oauthName)がテーブル(user)に
	 * 登録されているか判定するためのメソッド</p>
	 * @param oauthId OAuthサービス元のユニークID
	 * @param oauthName OAuthサービス元のユーザー名
	 * @return true/false <p>登録されていればtrueを返し、ユーザーIDを取得しDTOに格納します。
	 *         登録されていなければfalseを返します。</p>
	 */
	public boolean select(String oauthId, String oauthName){
		con = MySQLConnector.getConnection("openconnect");
		try{
			sql = "SELECT id FROM user WHERE oauth_id=? AND oauth_name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,oauthId);
			ps.setString(2,oauthName);

			rs = ps.executeQuery();
			if(rs.next()){
				dto.setId(rs.getInt("id"));
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * データベース(openconnect)に接続し、テーブル(user)にユーザー情報をインサートできるか確認する為のメソッド
	 * @param oauthId OAuthサービス元のユニークID
	 * @param userName OAuthサービス元のユーザー名
	 * @param oauthName OAuthサービス元の名前
	 * @param email OAuthのサービス元で登録しているメールアドレス
	 * @return true/false <p>インサート成功時にtrueを、失敗時にfalse返します。</p>
	 */
		public boolean insert(String userName, String email, String oauthId, String oauthName ) {
			con = MySQLConnector.getConnection("openconnect");
			sql = "INSERT INTO user(user_name, email, oauth_id, oauth_name) values (?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, email);
				ps.setString(3, oauthId);
				ps.setString(4, oauthName);

				int insertCount = ps.executeUpdate();
				if (insertCount > 0) {
					return true;
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
			return false;
		}

	/**
	 * 結果を格納するDTOクラスを取得するメソッド
	 * @return DTO
	 */
	public LoginOauthDTO getLoginOauthDTO() {
		return dto;
	}
}