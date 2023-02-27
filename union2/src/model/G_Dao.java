package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class G_Dao {

	private Connection conn = null;
	
	public G_Dao() {
		conn = DBConn.getInstance();
	}
	
	public void close() {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Vector> getGrocerylist() {
		Vector<Vector> glist = new Vector<Vector>();
		
		String sql = "";
		sql += "SELECT L.LARGE_ID LARGE_ID, L.LARGE_CLASSIFIC LARGE_CLASSIFIC, ";
		sql	+= " M.MEDIUM_ID MEDIUM_ID , M.MEDIUM_CLASSIFIC MEDIUM_CLASSIFIC,";
		sql += " S.SMALL_ID SMALL_ID, S.SMALL_CLASSIFIC SMALL_CLASSIFIC";		
		sql += "    FROM LARGE_CLASSIFIC L JOIN MEDIUM_CLASSIFIC M ON L.LARGE_ID = M.LARGE_ID ";
		sql += "    JOIN SMALL_CLASSIFIC S ON M.MEDIUM_ID = S.MEDIUM_ID "; 
		
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;  
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String large_id         = rs.getString("LARGE_ID");
				String large_classific  = rs.getString("LARGE_CLASSIFIC");
				String medium_id        = rs.getString("MEDIUM_ID");
				String medium_classific = rs.getString("MEDIUM_CLASSIFIC");
				String small_id         = rs.getString("SMALL_ID");
				String small_classific  = rs.getString("SMALL_CLASSIFIC");
				
				Vector v = new Vector();
				v.add(large_id);
				v.add(large_classific);
				v.add(medium_id);
				v.add(medium_classific);
				v.add(small_id);
				v.add(small_classific);
				
				glist.add(v);
			}
		} catch (SQLException e) {
			System.out.println("grocery_error");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				
			}
		}
		
		return glist;
	}



	public int insertGrocery( String search) {
		String       sql = "INSERT INTO LARGE_CLASSIFIC ( LARGE_ID, LARGE_CLASSIFIC )\r\n"
				+ " VALUES ( (SELECT NVL(MAX(LARGE_ID)+1,0) FROM LARGE_CLASSIFIC ), ? ) ";
		
		PreparedStatement pstmt = null;
		int               aftcnt = 0;
		try {
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			
			aftcnt = pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "추가에 성공하였습니다");
		} catch (SQLException e) {
			System.out.println("insertGrocery 시도");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "추가에 실패하였습니다");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				
			}
		}
		
		return aftcnt;
	}



	

	
	
	
	
	
	
	
	
}
