package comtroller;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private Connection conn = null;
    
    public UserDao() {
    	conn = DBConn.getInstance();
    	
    }
	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public int insertMember()
}
 