package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ExpenseChart_Dao {

	private Connection conn = null;
	
	public ExpenseChart_Dao() {
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
//	public Vector<Vector> getChart(String id){
		public Vector<Vector> getChart(String id){
		
		Vector<Vector> Chart = new Vector<>(); // 조회된 결과전체 대응 : rs
		
		String  sql = "";
		sql    += "SELECT     TO_CHAR(G.INPUT_DATE, 'MM') MONTH, "
				+ "           SUM(G.PRICE) EXPENSE_PRICE "
				+ " FROM      EXPENSES E, GROCERIES G, GROCERY_EXPIRE GE "
				+ " WHERE     E.GROCERY_ID = G.GROCERY_ID "
				+ " AND       G.GROCERY_ID = GE.GROCERY_ID "
				+ " AND       INPUT_DATE LIKE '22/%' "
				+ " AND       G.USER_ID = 'sky' "
				+ " GROUP BY  TO_CHAR(G.INPUT_DATE, 'MM') "
				+ " ORDER BY  TO_CHAR(G.INPUT_DATE, 'MM') ASC;";
		
		
		PreparedStatement pstmt = null;
		ResultSet         rs    = null; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, id);
			
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				

				String month            = rs.getString(1);  // 1: 칼럼번호(1~)
				double expense_price    = rs.getDouble(2);  // 2
				
				
				Vector v        = new Vector(); // 안쪽 Vector : 한줄 Row를 의미
					v.add(month);
					v.add(expense_price);
					
					Chart.add(v); // 전체 차트에 추가
					System.out.println(v);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("오류");
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
			}			
		}
		
		return Chart;
		
	}



}