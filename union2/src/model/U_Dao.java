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
		String sql = "SELECT USER_PASSWORD "
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
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
					flag = true;
				} 
			} else {
				JOptionPane.showMessageDialog(null, "틀린 정보를 입력하셨습니다.");
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
					JOptionPane.showMessageDialog(null, "당신의 아이디는 " + id + "입니다.", "아이디찾기",
							JOptionPane.OK_OPTION);
			} else {
				JOptionPane.showMessageDialog(null, "이메일 정보가 없습니다.");
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
					JOptionPane.showMessageDialog(null, "당신의 비밀번호는 " + pw + "입니다.",
							"비밀번호 찾기", JOptionPane.OK_OPTION);
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

	public void eXit(String pw, String cfpw) {
		String sql = "SELECT USER_PASSWORD "
				+ "FROM USERS "
				+ "WHERE USER_PASSWORD = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw1 = rs.getString("USER_PASSWORD");
				if(pw.equals(pw1)) {
					ExitCf ecf = new ExitCf(); 
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
		String sql = "DELETE FROM USERS "
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

	public Vector<Vector> getUserList() {

		Vector<Vector> list = new Vector<>();
		
		String sql = "SELECT GROCERY_NAME, STORAGE_PLACE, QUANTITY, UNIT, INPUT_DATE, EXPIRE_DATE, "
				+ "TO_CHAR(TRUNC(EXPIRE_DATE - SYSDATE)) DUEDATE "
				+ "FROM GROCERIES ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String grocery_name = rs.getString("GROCERY_NAME");
				String storage_place = rs.getString("STORAGE_PLACE");
				String quantity = rs.getString("QUANTITY");
				String unit = rs.getString("UNIT");
				String input_date = rs.getString("INPUT_DATE");
				String expire_date = rs.getString("EXPIRE_DATE");
				String duedate = rs.getString("DUEDATE");
				
				Vector v = new Vector();
				v.add(grocery_name);
				v.add(storage_place);
				v.add(quantity);
				v.add(unit);
				v.add(input_date);
				v.add(expire_date);
				v.add(duedate);
				
				list.add(v);
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


	// 로그인
	
	
}
