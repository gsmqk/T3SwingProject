package T3Project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String dburl  = "jdbc:oracle:thin:@team3_medium?TNS_ADMIN=D:/Wallet/Wallet_team3";
	private static String dbuid  = "admin";
	private static String dbpwd  = "Swingproject1234";
	
	private static Connection conn = null;
	
	private DBConn() {};
	
	public static Connection getInstance() {
		if (conn != null) {
			return conn;
		}
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}