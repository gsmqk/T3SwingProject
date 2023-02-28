package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ExpireChart_Dao {

	private Connection conn = null;
	
	public ExpireChart_Dao() {
		conn = DBConn.getInstance();
	}
	
	public  void close() {
		try {
			if(conn != null)  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 그래프에 들어갈 데이터 
	
	public ArrayList<ExpireChart_DTO> getExpireChartList(String id) {
		ArrayList<ExpireChart_DTO> chartList = new ArrayList<ExpireChart_DTO>();
//	public Vector<Vector> getChart(String id){
//		
//		Vector<Vector> Chart = new Vector<>(); // 조회된 결과전체 대응 : rs
		
		String  sql = "";
		sql    += "SELECT     TO_CHAR(GE.DISCARD_DATE, 'MM') MONTH, "
				+ "           SUM(G.PRICE) EXPENSE_PRICE, "
				+ "           SUM(E.AMOUNT) DISCARD_PRICE "
				+ " FROM      EXPENSES E, GROCERIES G, GROCERY_EXPIRE GE "
				+ " WHERE     E.GROCERY_ID = G.GROCERY_ID "
				+ " AND       G.GROCERY_ID = GE.GROCERY_ID "
				+ " AND       EXPENSE_CATEGORY = '폐기' "
				+ " AND       DISCARD_DATE LIKE '22/%' "
				+ " AND       G.USER_ID = ? "
				+ " GROUP BY  TO_CHAR(GE.DISCARD_DATE, 'MM') "
				+ " ORDER BY  TO_CHAR(GE.DISCARD_DATE, 'MM') ASC; ";
		
		PreparedStatement pstmt = null;
		ResultSet         rs    = null; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				

				String month            = rs.getString(1);  // 1: 칼럼번호(1~)
				double expire_price     = rs.getDouble(2);  // 2
				
				// 2가지 필드를 하나로 묶기 위해서 dto객체 생성
				ExpireChart_DTO dto = new ExpireChart_DTO(month, expire_price);
			
					
					chartList.add(dto); // 전체 차트에 추가
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
			}			
		}
		
		
	return chartList;
	}
}