import java.sql.*;
import java.util.*;

import Models.Comment;


public class SQLDBConnector
{
    private static final String DB_URL = "jdbc:mysql://localhost/BetterBox";
    private static final String USER = "betteruser";
    private static final String PASS = "password";

    public static void main(String[] args)
    {
        insertComment(0, 0, USER, 0, 0, DB_URL, 0, 0);
        ArrayList<String[]> sensitiveInfo = getComment("kyle");
        // insertUser("kyle", "mypassword");
        //insertWatchedLater("kyle", 123456);

       //insertUser("kyle", "mypassword");
        // insertWatchedLater("kyle", 175854);
        // insertWatchedLater("kyle", 47852);
        // insertWatchedLater("kyle", 378527);
        // insertWatchedLater("kyle", 12345);
        //ArrayList<String[]> sensitiveInfo = getWatchLater("kyle");

        for(String[] movie : sensitiveInfo){
            System.out.println(movie[0]);
        }
    }

    // public static ArrayList<String[]> getSensitiveInfo(){
    //     ArrayList<String[]> sens = new ArrayList<String[]>();
    //     try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    //      Statement stmt = conn.createStatement();

    //       ResultSet rs = stmt.executeQuery(QUERY);) {
    //       //Extract data from result set
    //      while (rs.next()) {
    //         String[] curr = new String[2];
    //         curr[0] = rs.getString("username");
    //         curr[1] = rs.getString("userPassword");
    //         sens.add(curr);
    //      }
         
    //   } catch (SQLException e) {
    //      e.printStackTrace();
    //   } 
    //   return sens;
    // }

    //this method does not work yet
    public static String encryption(char[] pass)
    {
        for(int i = 0; i < pass.length;i++)
        {
            
        }
        String password = " ";
        return password;
    }

    public static void getComment(String user)
    {
        
        ArrayList<String[]> sens = new ArrayList<String[]>();
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
    
              ResultSet rs = stmt.executeQuery(QUERY);)
              {

              }
    }
    
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

    public static int insertWatchedLater(String username, int movieID)
    {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_watch_later(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, username);
            cstmt.setInt(3, movieID);
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            return returnCode;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    }
    
    public static ArrayList<String[]> getWatchLater(String user)
    {
        final String QUERY = "SELECT movieid from watchlater where username = '" + user +"'";
        ArrayList<String[]> movies = new ArrayList<String[]>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt =  conn.createStatement();
        ResultSet rs  = stmt.executeQuery(QUERY);)
        {
            
            while(rs.next())
            {
                System.out.println(rs.getString("movieid"));
                String[] curr = new String[1];
                curr[0] = rs.getString("movieid");
                movies.add(curr);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return movies;
    }

    public static int insertWatched(String username, int movieID)
    {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_watched(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, username);
            cstmt.setInt(3, movieID);
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            return returnCode;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    }

    public static ArrayList<String[]> getWatched(String user)
    {
        final String QUERY = "SELECT movieid from watchedmovies where username = '" + user +"'";
        ArrayList<String[]> movies = new ArrayList<String[]>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt =  conn.createStatement();
        ResultSet rs  = stmt.executeQuery(QUERY);)
        {
            
            while(rs.next())
            {
                System.out.println(rs.getString("movieid"));
                String[] curr = new String[1];
                curr[0] = rs.getString("movieid");
                movies.add(curr);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return movies;
    }

    public static int insertSaved(String username, int movieID, String collectionID)
    {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_saved(?,?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, username);
            cstmt.setInt(3, movieID);
            cstmt.setString(4, collectionID);
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            return returnCode;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    }

    public static ArrayList<String[]> getSavedMovies(String user, String collectionID)
    {
        final String QUERY = "SELECT movieid from savedmovies where username = '" + user +"' " + "AND collectionid = '" + collectionID +"'";
        ArrayList<String[]> movies = new ArrayList<String[]>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt =  conn.createStatement();
        ResultSet rs  = stmt.executeQuery(QUERY);)
        {
            
            while(rs.next())
            {
                String[] curr = new String[1];
                curr[0] = rs.getString("movieid");
                movies.add(curr);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return movies;
    }
    
    //This method does not work
    public static int insertComment(Comment c)
    {   
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_comment(?,?,?,?,?,?,?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setInt(2, c.getRatingId());
            cstmt.setInt(3, c.getRating());
            cstmt.setString(4, c.getUserName());
            cstmt.setInt(5, c.getMovieId());
            cstmt.setInt(6, c.getParentId());
            cstmt.setString(7, c.getContent());
            cstmt.setInt(8, c.getNumLikes());
            cstmt.setInt(9, c.getNumDislikes());
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            return returnCode;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    } 
  
    public static int insertLikedComment(Comment c)
    {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_likedcomment(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, c.getUserName());
            cstmt.setInt(3, c.getReviewId());
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            return returnCode;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    } 
}


