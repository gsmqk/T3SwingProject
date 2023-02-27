package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import view.ExitCf;
import view.MainTable01;

public class U_Dao {
	
	private Connection conn = null;
	
	public U_Dao() {
		conn = DBConn.getInstance();
	}
	
	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	  public Vector<Vector> getMemberList() {
	      Vector<Vector> list = new Vector<Vector>();
	      
	      String sql = "";
	      sql += "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS ";
	      sql += " FROM USERS ";
	      
	      PreparedStatement pstmt = null;
	      ResultSet         rs    = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         rs    = pstmt.executeQuery();
	          while( rs.next() ) { // --------------------- 와일문 안에 백터만들기
	             String user_id       = rs.getString("USER_ID");
	             String user_name     = rs.getString("USER_NAME");
	             String user_password = rs.getString("USER_PASSWORD");
	             String user_email    = rs.getString("USER_EMAIL");
	             String user_grade    = rs.getString("USER_GRADE");
	             String user_status   = rs.getString("USER_STATUS");
	             
	             Vector v = new Vector();
	             v.add(user_id);
	             v.add(user_name);
	             v.add(user_password);
	             v.add(user_email);
	             v.add(user_grade);
	             v.add(user_status);
	             
	             list.add(v);
	          }
	      } catch (SQLException e) {
	         System.out.println("삐빅-에러입니다");
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs    != null )rs.close();
	            if(pstmt != null )pstmt.close();
	         } catch (SQLException e) {
	            
	         }
	      }
	      
	      return list;
	   } 

	
	// 회원가입에 정보주기
	public int insertUser(U_DTO uto) {
		
		String userid = uto.getU_id();
		String passwd = uto.getU_password();
		String username = uto.getU_name();
		String email = uto.getU_email();
		
		int aftcnt = insertUser(userid, passwd, username, email);
		return aftcnt;
	}
	// 회원가입
	private int insertUser(String userid, String username, String passwd, String email) {
		String sql = "INSERT INTO USERS "
				+ "(USER_ID, USER_PASSWORD, USER_NAME, USER_EMAIL) "
				+ "VALUES "
				+ "(?, ?, ?, ?) ";
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			pstmt.setString(3, username);
			pstmt.setString(4, email);
			
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
		return aftcnt;
	}

	public String checkExist(String id) {
		String sql = "SELECT USER_ID "
				+ "FROM USERS "
				+ "WHERE USER_ID = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String msg = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(id.equals(rs.getString("USER_ID")))
					msg = "이미 등록된 아이디입니다.";
			} else
				msg = "사용할 수 있는 아이디입니다.";
			System.out.println(msg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	// 로그인 확인
	public boolean login(String id, String pw) {
		String sql = "SELECT USER_PASSWORD, USER_GRADE "
				+ "FROM USERS "
				+ "WHERE USER_ID = ? "
				+ "AND   USER_PASSWORD = ? ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pwd = rs.getString("USER_PASSWORD");
				System.out.println("password:" + pwd);
				if (pw.equals(pwd)) {
					String grade = rs.getString("USER_GRADE");
					switch (grade) {
					case "0" : JOptionPane.showMessageDialog(null, "탈퇴한회원의 정보입니다. 다시 가입해주세요.");
						flag = false;
						break;
						default : JOptionPane.showMessageDialog(null, "로그인되었습니다.");
						flag = true; 
							break;
					};
				} 
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 정보입니다. 다시 확인해주세요.");
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	//아이디찾기
	public void findId(String email) {
		String sql = "SELECT USER_ID, USER_EMAIL "
				+ "FROM USERS "
				+ "WHERE USER_EMAIL = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				String id = rs.getString("USER_ID");
				if(email.equals(rs.getString("USER_EMAIL")))
					JOptionPane.showMessageDialog(null, "당신의 아이디는 " + id + "입니다."
							);
			} else {
				JOptionPane.showMessageDialog(null, "이메일 정보가 없습니다.", "실패", 
						JOptionPane.OK_OPTION);
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
		
	}

	//비번찾기
	public void findPw(String id, String email) {
		String sql = "SELECT USER_ID, USER_EMAIL, USER_PASSWORD "
				+ "FROM USERS "
				+ "WHERE USER_ID = ? "
				+ "AND USER_EMAIL = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id1 = rs.getString("USER_ID");
				String email1 = rs.getString("USER_EMAIL");
				String pw = rs.getString("USER_PASSWORD");
				if(id.equals(id1) && email.equals(email1)) {
					JOptionPane.showMessageDialog(null, "당신의 비밀번호는 " + pw + "입니다."
							);
				}
			} else {
				JOptionPane.showMessageDialog(null, "정보를 다시 확인해주세요", "비밀번호 찾기",
						JOptionPane.OK_OPTION);
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
		
	}

	//?????????????????????????????????????이거먼가용
	public void eXit(String id, String pw) {
		String sql = "SELECT USER_ID, USER_PASSWORD "
				+ "FROM USERS "
				+ "WHERE USER_PASSWORD = ? "
				+ "AND   USER_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw1 = rs.getString("USER_PASSWORD");
				if(pw.equals(pw1)) {
					ExitCf ecf = new ExitCf(id); 
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요", "탈퇴확인", 
							JOptionPane.OK_OPTION);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public int removeUser(String id) {
		String sql = "UPDATE USERS "
				+ "SET USER_GRADE = 0, "
				+ "    USER_STATUS = '전회원' "
				+ "WHERE USER_ID = ?";
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
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
		return aftcnt;
	}

	public boolean checkPw(String id, String pw) {
		String sql = "SELECT USER_PASSWORD "
				+ "FROM USERS "
				+ "WHERE USER_ID = ?"
				+ "AND USER_PASSWORD = ?";
		
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			else {
				flag = false;
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
		System.out.println(flag);
		return flag;
	}

	public int updateUser(U_DTO dto) {
		String sql = "UPDATE USERS "
				+ "SET USER_PASSWORD = ?, "
				+ "    USER_NAME = ?, "
				+ "    USER_EMAIL = ? "
				+ "WHERE USER_ID = ? ";
		
		int aftcnt = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getU_password());
			pstmt.setString(2, dto.getU_name());
			pstmt.setString(3, dto.getU_email());
			pstmt.setString(4, dto.getU_id());
			
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
		
		return aftcnt;
	}

	public Vector<Vector> getUserList(String id) {
		
		Vector<Vector> list = new Vector<>();
		
		String sql = "SELECT G.GROCERY_NAME, ST.STORAGE_PLACE, G.QUANTITY, G.UNIT, "
				+ "TO_CHAR(G.INPUT_DATE, 'YYYY-MM-DD') INPUT_DATE, " 
				+ "TO_CHAR(G.EXPIRE_DATE, 'YYYY-MM-DD') EXPIRE_DATE, " 
				+ "TO_CHAR(TRUNC(G.EXPIRE_DATE - SYSDATE)) DUE_DATE "
				+ "FROM   GROCERIES G "
				+ "JOIN   STORAGES ST "
				+ "ON     G.STORAGE_ID = ST.STORAGE_ID "
				+ "WHERE  G.USER_ID = ? "
				+ "ORDER BY DUE_DATE ASC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs    = pstmt.executeQuery();
			
			while (rs.next()) {
				String grocery_name  = rs.getString(1);
				String storage_place = rs.getString(2);
				String quantity      = rs.getString(3);
				String unit          = rs.getString(4);
				Date   input_date    = rs.getDate  (5);
				Date   expire_date   = rs.getDate  (6);
				String due_date      = rs.getString(7);
				
				Vector v = new Vector();
				int dDate = Integer.parseInt(due_date);
				if (dDate>=0 && dDate <= 7) {
					v.add(grocery_name);
					v.add(storage_place);
					v.add(quantity);
					v.add(unit);
					v.add(input_date);
					v.add(expire_date);
					v.add(dDate);
					list.add(v);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	public boolean adminLogin(String pw) {
		String sql = "SELECT USER_ID, USER_PASSWORD "
				+ "FROM USERS "
				+ "WHERE USER_ID = ? "
				+ "AND USER_PASSWORD = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "admin");
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	   // 어드민창에서 회원조회! 
	   public U_DTO getMember(String u_id) {
	      U_DTO dto = null;
	      
	      String sql = "";
	      sql += "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_GRADE, USER_STATUS ";
	      sql += " FROM USERS ";
	      sql += " WHERE USER_ID = ? ";
	      
	      PreparedStatement pstmt = null;
	      ResultSet         rs    = null;
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, u_id);
	      
	         rs    = pstmt.executeQuery();
	         
	         if(rs.next()) {
	             String id            = rs.getString(1);
	             String user_name     = rs.getString("USER_NAME");
	             String user_password = rs.getString("USER_PASSWORD");
	             String user_email    = rs.getString("USER_EMAIL");
	             String user_grade    = rs.getString("USER_GRADE");
	             String user_status   = rs.getString("USER_STATUS");
	             
	             dto = new U_DTO(u_id, user_name, user_password, user_email, user_grade, user_status);
	             System.out.println("트라이는함!!!");
	         }
	      } catch (SQLException e) {
	         System.out.println("안ㅁㄱ고곰곰곡몸곡목모목");
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs    != null) rs.close();
	            if(pstmt != null) pstmt.close();
	      } catch (SQLException e) {
	      
	      }
	      
	      }
	      return dto;
	   }


	   // 로그인
	   
	   
	   


	//  민경 회원정보수정!!
	public int update(U_DTO dto) {
		String sql = "";
		sql += "UPDATE USERS";
		sql += " SET USER_NAME = ?, ";
		sql += "     USER_PASSWORD = ?, ";
		sql += "     USER_EMAIL = ?, ";
		sql += "     USER_STATUS = ?, ";
		sql += "     USER_GRADE = ? ";
		sql += " WHERE USER_ID = ? ";
		
		int aftcnt = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getU_name());
			pstmt.setString(2, dto.getU_password());
			pstmt.setString(3, dto.getU_email());
			pstmt.setString(4, dto.getU_grade());
			pstmt.setString(5, dto.getU_status());
			pstmt.setString(6, dto.getU_id());
			
			System.out.println("update" + dto);
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null ) pstmt.close();
			} catch (SQLException e) {
				
			}
		}
		return aftcnt;
	}



	


	// 로그인
	
	
	}
















