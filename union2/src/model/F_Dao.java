package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import view.Login;

public class F_Dao {
	
	String id;
	
	private Connection conn = null;
	
	public F_Dao() {
		conn = DBConn.getInstance();
	}
	
	public F_Dao(String id) {
		this.id = id;
	}

	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 식자재 입력
	public int insertGrosery(F_DTO fto) {
		
		String major = fto.getF_major();
		String minor = fto.getF_minor();
		String place = fto.getF_place();
		String fname = fto.getF_name();
		String quan = fto.getF_Quantity();
		String unit = fto.getF_unit();
		String price = fto.getF_price();
		String store = fto.getF_store(); 
		String indate = fto.getF_inDate(); 
		String sobi = fto.getF_sobi();
		String uid = fto.getF_uid();
		System.out.println("넘기기전 값 : " + uid);
		
		int aftcnt = insertGrosery(major, minor, place, fname, quan, unit, price, store, indate, sobi, uid);
		return aftcnt;
	}

	private int insertGrosery(String major, String minor, String place, String fname, String quan, String unit,
			String price, String store, String indate, String sobi, String uid) {
		String sql = "INSERT INTO GROCERIES "
				+ "(GROCERY_ID, LARGE_CLASSIFIC, MEDIUM_CLASSIFIC, STORAGE_PLACE, GROCERY_NAME, "
				+ "QUANTITY, UNIT, PRICE, STORE_NAME, INPUT_DATE, EXPIRE_DATE, USER_ID ) "
				+ "VALUES "
				+ "(GROCERY_ID1.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" ;
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.setString(2, major);
			pstmt.setString(3, minor);
			pstmt.setString(4, place);
			pstmt.setString(5, quan);
			pstmt.setString(6, unit);
			pstmt.setString(7, price);
			pstmt.setString(8, store);
			pstmt.setString(9, indate);
			pstmt.setString(10, sobi);
			System.out.println("넣기전 값" + uid);
			pstmt.setString(11, uid);
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null)pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return aftcnt;
	}

}
