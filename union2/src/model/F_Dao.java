package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import view.GroceryInfo;
import view.Login;
import view.MainTable01;

public class F_Dao {
	
	String id;
	GroceryInfo gif = null;
	
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
		
		String large = fto.getLarge_classific();
		String middle = fto.getMedium_classific();
		String small = fto.getSmall_classific();
		String place = fto.getStorage_place();
		String fname = fto.getGrocery_name();
		String quan = fto.getQuantity();
		String price = fto.getPrice();
		String unit = fto.getUnit();
		String store = fto.getStore_name(); 
		String indate = fto.getInput_date(); 
		String exdate = fto.getExpire_date(); 
		String memo = fto.getMemo();
		String uid = fto.getUser_id();
		
		System.out.println(uid);
		
		int aftcnt = insertGrosery(large, middle, small, place, fname, quan, price, store, indate, exdate, unit, memo, uid);
		return aftcnt;
	}

	private int insertGrosery(String large, String middle, String small, String place, String fname,
			String quan, String price, String store, String indate, String exdate, String unit, String memo, String uid) {
		String sql = "INSERT INTO GROCERIES "
				+ "(GROCERY_ID, GROCERY_NAME, "
				+ "LARGE_ID, "
				+ "MEDIUM_ID, "
				+ "SMALL_ID, "
				+ "STORAGE_ID, "
				+ "QUANTITY, UNIT, PRICE, "
				+ "STORE_ID, "
				+ "INPUT_DATE, EXPIRE_DATE, "
				+ "MEMO, "
				+ "USER_ID) "
				+ "VALUES "
				+ "(GROCERY_ID1.NEXTVAL, ?, "
				+ "(SELECT LARGE_ID FROM LARGE_CLASSIFIC WHERE LARGE_CLASSIFIC = ?), "
				+ "(SELECT MEDIUM_ID FROM MEDIUM_CLASSIFIC WHERE MEDIUM_CLASSIFIC = ?), "
				+ "(SELECT SMALL_ID FROM SMALL_CLASSIFIC S JOIN MEDIUM_CLASSIFIC M ON M.MEDIUM_ID = S.MEDIUM_ID WHERE SMALL_CLASSIFIC = ? AND MEDIUM_CLASSIFIC = ?), "
				+ "(SELECT STORAGE_ID FROM STORAGES WHERE STORAGE_PLACE = ?), "
				+ "?, ?, ?, "
				+ "(SELECT STORE_ID FROM STORES WHERE STORE_NAME = ?), "
				+ "?, ?, "
				+ "?, "
				+ "?)" ;
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.setString(2, large);
			pstmt.setString(3, middle);
			pstmt.setString(4, small);
			pstmt.setString(5, middle);
			pstmt.setString(6, place);
			pstmt.setString(7, quan);
			pstmt.setString(8, unit);
			pstmt.setString(9, price);
			pstmt.setString(10, store);
			pstmt.setString(11, indate);
			pstmt.setString(12, exdate);
			pstmt.setString(13, memo);
			pstmt.setString(14, uid);
			
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

	public void goInfo(String id2) {
		
		F_DTO fto = null;
		
		String sql = "SELECT G.GROCERY_NAME, L.LARGE_CLASSIFIC, M.MEDIUM_CLASSIFIC, S.SMALL_CLASSIFIC, "
				+ "       ST.STORAGE_PLACE, G.QUANTITY, G.UNIT, G.PRICE, RE.STORE_NAME, "
				+ "       TO_CHAR(G.INPUT_DATE,'YYYY-MM-DD'), "
				+ "       TO_CHAR(G.EXPIRE_DATE,'YYYY-MM-DD'), "
				+ "       TO_CHAR(TRUNC(G.EXPIRE_DATE - SYSDATE)) DUE_DATE, "
				+ "	      G.MEMO MEMO "
				+ "FROM   GROCERIES G "
				+ "JOIN  LARGE_CLASSIFIC L ON G.LARGE_ID = L.LARGE_ID "
				+ "JOIN  MEDIUM_CLASSIFIC M ON G.MEDIUM_ID = M.MEDIUM_ID "
				+ "JOIN  SMALL_CLASSIFIC S ON G.SMALL_ID = S.SMALL_ID "
				+ "JOIN  STORAGES ST ON G.STORAGE_ID = ST.STORAGE_ID "
				+ "JOIN  STORES RE ON G.STORE_ID = RE.STORE_ID "
				+ "WHERE  GROCERY_NAME = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String gname = rs.getString(1);
				String large = rs.getString(2);
				String medium = rs.getString(3);
				String small = rs.getString(4);
				String place = rs.getString(5);
				String quantity = rs.getString(6);
				String unit = rs.getString(7);
				String price = rs.getString(8);
				String store_name = rs.getString(9);
				String input_date = rs.getString(10);
				String expire_date = rs.getString(11);
				String due_date = rs.getString("DUE_DATE");
				String memo = rs.getString("MEMO");
				int f = 0;
				
				fto = new F_DTO(gname, large, medium, small, place, quantity,
						unit, price, store_name, input_date, expire_date, due_date, memo, f);
				
				gif = new GroceryInfo(fto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Vector<String> getLarge() {
		
		Vector<String> list = new Vector<String>();
		
		String sql = "SELECT DISTINCT LARGE_CLASSIFIC "
				+ "FROM LARGE_CLASSIFIC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			list.add("대분류");
			while(rs.next()) {
				String large = rs.getString("LARGE_CLASSIFIC");
				
				list.add(large);
			}
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null ) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Vector<String> getMiddle(String item) {
		
		Vector<String> mList = new Vector<String>();
		System.out.println(item);
		String sql = "SELECT DISTINCT M.MEDIUM_CLASSIFIC "
				+ "FROM MEDIUM_CLASSIFIC M "
				+ "JOIN LARGE_CLASSIFIC L "
				+ "ON   M.LARGE_ID = L.LARGE_ID "
				+ "WHERE L.LARGE_CLASSIFIC = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String middle = rs.getString(1);
				mList.add(middle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mList;
	}

	public Vector<String> getSmall(String item) {
		
		Vector<String> sList = new Vector<String>();
		System.out.println(item);
		String sql = "SELECT DISTINCT S.SMALL_CLASSIFIC "
				+ "FROM MEDIUM_CLASSIFIC M "
				+ "JOIN SMALL_CLASSIFIC S "
				+ "ON   M.MEDIUM_ID = S.MEDIUM_ID "
				+ "WHERE M.MEDIUM_CLASSIFIC = ?" ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String small = rs.getString(1);
				sList.add(small);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sList;
	}

	public Vector<String> getStore() {
		
Vector<String> list = new Vector<String>();
		
		String sql = "SELECT DISTINCT STORE_NAME "
				+ "FROM STORES";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String store = rs.getString("STORE_NAME");
				
				list.add(store);
			}
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null ) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int updateGrocery(F_DTO fto) {
		String sql = "UPDATE GROCERIES "
				+ "SET "
				+ "    LARGE_ID = "
				+ "     (SELECT LARGE_ID FROM LARGE_CLASSIFIC WHERE LARGE_CLASSIFIC = ?), "
				+ "    MEDIUM_ID = "
				+ "     (SELECT MEDIUM_ID FROM MEDIUM_CLASSIFIC WHERE MEDIUM_CLASSIFIC = ?), "
				+ "    SMALL_ID = "
				+ "     (SELECT SMALL_ID FROM SMALL_CLASSIFIC WHERE SMALL_CLASSIFIC = ?), "
				+ "    STORAGE_ID = "
				+ "     (SELECT STORAGE_ID FROM STORAGES WHERE STORAGE_PLACE = ?), "
				+ "    QUANTITY = ?, "
				+ "    UNIT = ?, "
				+ "    PRICE = ?, "
				+ "    INPUT_DATE = ?, "
				+ "    EXPIRE_DATE = ? "
				+ "WHERE GROCERY_ID = (SELECT GROCERY_ID FROM GROCERIES WHERE GROCERY_NAME = ?)";

		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fto.getLarge_classific());
			pstmt.setString(2, fto.getMedium_classific());
			pstmt.setString(3, fto.getSmall_classific());
			pstmt.setString(4, fto.getStorage_place());
			pstmt.setString(5, fto.getQuantity());
			pstmt.setString(6, fto.getUnit());
			pstmt.setString(7, fto.getPrice());
			pstmt.setString(8, fto.getInput_date());
			pstmt.setString(9, fto.getExpire_date());
			pstmt.setString(10, fto.getGrocery_name());
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(aftcnt);
		return aftcnt;
	}

	public Vector<Vector> getFilter(String large1, String medium1, String small1, String id2) {
		
		System.out.println("필터" + small1);
		System.out.println("필터" + id2);
		Vector<Vector> list = new Vector<Vector>();
		
		String sql = "SELECT LC.LARGE_CLASSIFIC, MC.MEDIUM_CLASSIFIC, ";
	    sql += "	   SC.SMALL_CLASSIFIC, SP.STORAGE_PLACE,  ";
	    sql += "       G.GROCERY_NAME, G.QUANTITY, G.UNIT, S.STORE_NAME, ";
	    sql += "       TO_CHAR(G.INPUT_DATE, 'YYYY-MM-DD') INPUT_DATE, ";
	    sql += "       TO_CHAR(G.EXPIRE_DATE, 'YYYY-MM-DD') EXPIRE_DATE, ";
	    sql += "	   TO_CHAR(TRUNC(EXPIRE_DATE - SYSDATE)) DUE_DATE ";
	    sql += " FROM  LARGE_CLASSIFIC LC, MEDIUM_CLASSIFIC MC, ";
	    sql += "       SMALL_CLASSIFIC SC, GROCERIES G, ";
	    sql += "       STORES S, STORAGES SP ";
	    sql += " WHERE LC.LARGE_ID  = G.LARGE_ID";
	    sql += " AND   MC.MEDIUM_ID = G.MEDIUM_ID";
	    sql += " AND   SC.SMALL_ID  = G.SMALL_ID";
	    sql += " AND   G.STORAGE_ID = SP.STORAGE_ID";
	    sql += " AND   G.STORE_ID   = S.STORE_ID";
	    sql += " AND   G.USER_ID = ? "
	    		+ "AND SC.SMALL_CLASSIFIC = ? ";
	   
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			pstmt.setString(2, small1);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String large = rs.getString(1);
				String medium = rs.getString(2);
				String small = rs.getString(3);
				String place = rs.getString(4);
				String fname = rs.getString(5);
				String quan = rs.getString(6);
				String unit = rs.getString(7);
				String store = rs.getString(8);
				String indate = rs.getString(9);
				String exdate = rs.getString(10);
				String duedate = rs.getString(11);
				
				Vector<String> v = new Vector<String>();
				v.add(large);
				v.add(medium);
				v.add(small);
				v.add(place);
				v.add(fname);
				v.add(quan);
				v.add(unit);
				v.add(store);
				v.add(exdate);
				v.add(exdate);
				v.add(duedate);
				
				list.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);
		return list;
	}




}
