package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class D3DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/"; //struts2 DB名
	private static String user = "root"; //DBのユーザ名
	private static String pass = "mysql";  //DBに接続するときのパスワード
	public static Connection getConnection(String DBName){
		StringBuffer sBuffer = new StringBuffer("");
		sBuffer.append(url);
		sBuffer.append(DBName);
		url = sBuffer.toString();
		Connection con = null;
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		url = "jdbc:mysql://localhost/";
		return con;
	}
}
