package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	private int insertUser(String userid, String passwd, String username, String email) {
		String sql = "INSERT INTO USERS "
				+ "(USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) "
				+ "VALUES "
				+ "(?, ?, ?, ?) ";
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, passwd);
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
	public void login(String id, String pw) {
		String sql = "SELECT USER_PASSWORD "
				+ "FROM USERS "
				+ "WHERE USER_ID = ? "
				+ "AND   USER_PASSWORD = ? ";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pwd = rs.getString("USER_PASSWORD");
				System.out.println("password:" + pwd);
				if (pw.equals(pwd)) {
					JOptionPane.showMessageDialog(null, "맞습니다");
				} 
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호가다릅니다");				
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


	// 로그인
	
	
}
