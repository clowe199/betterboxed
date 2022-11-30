import java.sql.*;
import java.util.*;

public class SQLDBConnector
{
    private static final String DB_URL = "jdbc:mysql://localhost/BetterBox";
    private static final String USER = "betteruser";
    private static final String PASS = "password";
   // get users return array of userdatas

   //  public static void main(String[] args)
   //  {
   //      ArrayList<String[]> sensitiveInfo = getSensitiveInfo();

   //      for(String[] user : sensitiveInfo){
   //          System.out.println(user[0] + " - " + user[1]);
   //      }

   //      insertUser("kyle", "mypassword");
   //      sensitiveInfo = getSensitiveInfo();

   //      for(String[] user : sensitiveInfo){
   //          System.out.println(user[0] + " - " + user[1]);
   //      }
   //  }

   //  public static ArrayList<String[]> getSensitiveInfo(){
   //      ArrayList<String[]> sens = new ArrayList<String[]>();
   //      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
   //       Statement stmt = conn.createStatement();
   //        ResultSet rs = stmt.executeQuery(QUERY);) {
   //        Extract data from result set
   //       while (rs.next()) {
   //          String[] curr = new String[2];
   //          curr[0] = rs.getString("username");
   //          curr[1] = rs.getString("userPassword");
   //          sens.add(curr);
   //       }
         
   //    } catch (SQLException e) {
   //       e.printStackTrace();
   //    } 
   //    return sens;
   //  }

    public static int insertUser(String username, String password){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
         CallableStatement cstmt = conn.prepareCall("{? = call insert_user(?,?)}");
         cstmt.registerOutParameter(1, Types.INTEGER);
         cstmt.setString(2, username);
         cstmt.setString(3, password);
         cstmt.execute();
         int returnCode = cstmt.getInt(1);
         return returnCode;
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return -1;
    }
}

