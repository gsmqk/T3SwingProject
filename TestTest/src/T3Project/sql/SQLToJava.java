package T3Project.sql;

import java.sql.*;

public class SQLToJava {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    Class.forName("oracle.jdbc.driver.OracleDriver");

    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "study", "1234");
    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT D.DEPARTMENT_NAME, TO_CHAR( AVG( E.SALARY ), '$999,999.00' )" +
            "FROM DEPARTMENTS D, EMPLOYEES E " +
            "WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID " +
            "GROUP BY D.DEPARTMENT_ID, D.DEPARTMENT_NAME " +
            "ORDER BY D.DEPARTMENT_ID");

    while (rs.next()) {
      System.out.println(rs.getString("DEPARTMENT_NAME") + " " + rs.getString(2));
    }

    rs.close();
    stmt.close();
    con.close();
  }
}
