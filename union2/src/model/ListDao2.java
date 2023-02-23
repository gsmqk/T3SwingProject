package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class ListDao2 {

private Connection  conn = null;
	
	// 생성자
	public  ListDao2() {
		conn  =  DBConn.getInstance(); 
	}
	public  void close() {
		try {
			if(conn != null)  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원 추가
	public int insertMember( String grocery_name, String storage_place, String quantity, 
			String input_date, String expire_date, String  due_date  ) {
		String            sql    = "";
		sql  += "INSERT INTO GROCERIES ";
		sql  += "  ( GROCERY_NAME,  STORAGE_PLACE, QUANTITY, INPUT_DATE, EXPIRE_DATE, DUE_DATE  )";
		sql  += " VALUES ";
		sql  += "  ( ?,       ?,      ?,        ?,   ?,      ?     )";		
		PreparedStatement pstmt  = null;
		int               aftcnt = 0;
		try {
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, grocery_name);
			pstmt.setString(2, storage_place);
			pstmt.setString(3, quantity);
			pstmt.setString(4, input_date);
			pstmt.setString(5, expire_date);
			pstmt.setString(6, due_date);
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
			}
		}
		return  aftcnt;
	}
	public int insertMember(G_DTO vo) {
		
		String   grocery_name   = vo.getGrocery_name();
		String   storage_place   = vo.getStorage_place();
		String   quantity = vo.getQuantity();
		String   input_date      = vo.getInput_date();
		String   expire_date   = vo.getExpire_date();
		String   due_date    = vo.getDue_date();
		
		int aftcnt = insertMember(grocery_name, storage_place, quantity, input_date, expire_date, due_date);
		return aftcnt;
		
	}
	
	// data 삭제
	/*public int deleteMember(String userid) {
		
		String  sql = "";
		sql += "DELETE FROM  GROCERIES";
		sql += " WHERE GROCERY_NAME = ? ";
		
		PreparedStatement  pstmt  = null ;
		int                aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			aftcnt = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)  pstmt.close();
			} catch (SQLException e) {
			}
		}
		return aftcnt;
	}*/
	
	// 회원조회
	/*public G_DTO getMember(String userid) {
		
		G_DTO  vo = null;
		
		String  sql = "";
		sql += "SELECT GROCERY_NAME,  STORAGE_PLACE, QUANTITY, INPUT_DATE, EXPIRE_DATE, DUE_DATE ";
		sql += " FROM  GROCERIES ";
		sql += " WHERE GROCERY_NAME = ? ";
		PreparedStatement pstmt  =  null;
		ResultSet         rs     =  null;
		try {
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs    =  pstmt.executeQuery();
			
			if( rs.next() ) {
				String  ouserid   = rs.getString("userid");
				String  passwd    = rs.getString("passwd");
				String  username  = rs.getString("username");
				String  job       = rs.getString("job");
				String  gender    = rs.getString("gender");
				String  intro     = rs.getString("intro");
				String  indate    = rs.getString("indate");
				
				vo   = new G_DTO(ouserid, passwd, username, job, gender, intro, indate);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null)   rs.close();
				if(pstmt != null)   pstmt.close();
			} catch (SQLException e) {		
			}
		}		
				
		return    vo;
	}*/
	
	// 데이터 수정
	public int updateMember(G_DTO vo) {
		String  sql = "";
		sql  += "UPDATE  GROCERIES ";
		sql  += " SET    GROCERY_NAME = ?, ";    // 상품명,보관장소,수량,입고일,소비기한,만기일
		sql  += "        STORAGE_PLACE      = ?, ";
		sql  += "        QUANTITY      = ?, ";
		sql  += "        INPUT_DATE   = ?, ";
		sql  += "        EXPIRE_DATE    = ?  ";
		sql  += "        DUE_DATE    = ?  ";
		sql  += " WHERE  DUE_DATE   = ?";
		
		int  aftcnt  = 0;
		PreparedStatement  pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGrocery_name() );
			pstmt.setString(2, vo.getStorage_place() );
			pstmt.setString(3, vo.getQuantity() );
			pstmt.setString(4, vo.getInput_date() );
			pstmt.setString(5, vo.getExpire_date() );
			pstmt.setString(6, vo.getDue_date() );
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null ) pstmt.close();
			} catch (SQLException e) {			
			}
		}		
		return aftcnt;
	}
	
	//GROCERY_ID, GROCERY_NAME, LARGE_CLASSIFIC, MEDIUM_CLASSIFIC, 
	//SMALL_CLASSIFIC, STORAGE_PLACE, STORE_ID, QUANTITY, 
	//UNIT, PRICE, STORE_NAME, INPUT_DATE, EXPIRE_DATE, USER_ID, DUE_DATE
	// Jtable 에 보여줄 data 목록
	public Vector<Vector> getList(){
		
		Vector<Vector> list = new Vector<Vector>(); // 조회된 결과전체 대응 : rs
		
		String  sql = "";
		sql += "SELECT LARGE_CLASSIFIC,  MEDIUM_CLASSIFIC, SMALL_CLASSIFIC, STORAGE_PLACE, GROCERY_NAME,  \r\n"
				+ "		UNIT,  STORE_ID, INPUT_DATE, EXPIRE_DATE,  \r\n"
				+ "		TO_CHAR(EXPIRE_DATE - SYSDATE) DUE_DATE \r\n"
				+ "		FROM     GROCERIES \r\n"
				+ "        ORDER BY GROCERY_NAME ASC";
		
		
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				

				String large_classific = rs.getString(1);   // 1: 칼럼번호(1~)
				String medium_classific = rs.getString(2); // 2
				String small_classific      = rs.getString(3); // 3
				String storage_place   = rs.getString(4); // 4
				String grocery_name   = rs.getString(5); // 5
				String unit   = rs.getString(6); // 6
				String store_id   = rs.getString(7); // 7
				String input_date   = rs.getString(8); // 8
				String expire_date   = rs.getString(9); // 9
				String due_date   = rs.getString(10); // 10
				
				Vector v        = new Vector(); // 안쪽 Vector : 한줄 Row를 의미
				v.add(large_classific);
				v.add(medium_classific);
				v.add(small_classific);
				v.add(storage_place);
				v.add(grocery_name);
				v.add(unit);
				v.add(store_id);
				v.add(input_date);
				v.add(expire_date);
				v.add(due_date);
				list.add(v); // 전체 목록에 추가
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
		
		
		return list;
	}
	
}






