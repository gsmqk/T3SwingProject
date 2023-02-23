package T3Project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOCIConn {

   private static String driver ="oracle.jdbc.OracleDriver";
   //private static String dburl = "jdbc:oracle:thin:@tcps://adb.ap-chuncheon-1.oraclecloud.com/g2c3131010ac63f_lmdatabase_high.adb.oraclecloud.com";
 //  private static String dburl = "jdbc:oracle:thin:@g2c3131010ac63f_lmdatabase_high?TNS_ADMIN=./src/Wallet_LMDATABASE/";
  // 나의 주소 
   private static String dburl = "jdbc:oracle:thin:@team3_medium?TNS_ADMIN=D:/Wallet/Wallet_team3";
   private static String dbuid = "admin";
   private static String dbpwd = "Swingproject1234";
   
 //  private static String driver ="oracle.jdbc.OracleDriver";
 //  private static String dburl = "jdbc:oracle:thin:@tcps://adb.ap-chuncheon-1.oraclecloud.com/geac8a12cf53d53_project01_high.adb.oraclecloud.com";
 //  private static String dbuid = "admin";
 //  private static String dbpwd = "Qw1234567890";
   
   
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      Class.forName(driver);
      Connection        conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
      System.out.println("연결됨");
      
      String            sql   = " SELECT GROCERY_NAME FROM GROCERIES ";
      
      
      PreparedStatement stmt = conn.prepareStatement(sql)  ;
      ResultSet  rs    = stmt.executeQuery();
      

      while(rs.next()) {
         String pName = rs.getString("GROCERY_NAME");
        
         String  fmt   = "%s";
         String  msg   =  String.format(fmt, pName);
         System.out.println(msg);
            
      }

      rs.close();
      stmt.close();
      conn.close();
   }

}
 