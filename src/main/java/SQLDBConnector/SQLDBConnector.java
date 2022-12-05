package SQLDBConnector;
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
        // int foo = checkUser("kyle");
        // System.out.println(foo);
        //getComment("test");
        ArrayList<String[]> sensitiveInfo = getUserCollections("testkyle");
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


    public static Comment getComment(String commentid)
    {
        Comment curr;
        Comment finalc;
        String query = "SELECT * FROM comment WHERE reviewid = '" + commentid + "'"; 
        ArrayList<Comment> sens = new ArrayList<Comment>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt =  conn.createStatement();
        ResultSet rs  = stmt.executeQuery(query);)
        {
        
            curr = new Comment.CommentBuilder()
        .commentId(rs.getString(1)) 
        .rating(rs.getInt(2)) 
        .movieId(rs.getInt(4)) 
        .userName(rs.getString(3))  
        .parentId(rs.getString(5))
        .content(rs.getString(6))
        .numLikes(rs.getInt(7))
        .numDislikes(rs.getInt(8))
        .build();
        sens.add(curr);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finalc = sens.get(0);
        return  finalc;
    }

    //This will return -1 if they are in the system and 1 if they are not. 
    public static int insertUser(String username, String password){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
    //This will return -1 if they are in the system and 1 if they are not. 
    public static int checkUser(String username)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
         CallableStatement cstmt = conn.prepareCall("{? = call check_user(?)}");
         cstmt.registerOutParameter(1, Types.INTEGER);
         cstmt.setString(2, username);
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
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        final String QUERY = "SELECT movieid from watchlater where username = '" + user +"'";
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

    public static int insertWatched(String username, int movieID)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        final String QUERY = "SELECT movieid from watchedmovies where username = '" + user +"'";
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

    public static int insertSaved(String username, int movieID, String collectionID)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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

    // returns individual collection
    public static ArrayList<String[]> getSavedMovies(String user, String collectionID)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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

    // returns array of collection ids
    public static ArrayList<String[]> getUserCollections(String user)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        final String QUERY = "select collectionid from savedmovies where username = '" + user +"'";
        ArrayList<String[]> movies = new ArrayList<String[]>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt =  conn.createStatement();
        ResultSet rs  = stmt.executeQuery(QUERY);)
        {
            
            while(rs.next())
            {
                String[] curr = new String[1];
                curr[0] = rs.getString("collectionid");
                movies.add(curr);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return movies;
    }

    public static int insertComment(Comment c)
    {   
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_comment(?,?,?,?,?,?,?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setInt(c.getRatingId(), 2);
            cstmt.setInt(3, c.getRating());
            cstmt.setString(4, c.getUserName());
            cstmt.setInt(5, c.getMovieId());
            cstmt.setInt(c.getParentId(), 6);
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
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_likedcomment(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, c.getUserName());
            cstmt.setString(3, c.getRatingId());
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            CallableStatement cstmt2 = conn.prepareCall("{? = call check_dislikedcomment(?,?)}");
            cstmt2.registerOutParameter(1, Types.INTEGER);
            cstmt2.setString(2, c.getUserName());
            cstmt2.setString(3, c.getRatingId());
            cstmt2.execute();
            return returnCode;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    } 

    public static int insertDislikedComment(Comment c)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = call insert_dislikedcomment(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, c.getUserName());
            cstmt.setString(3, c.getRatingId());
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            CallableStatement cstmt2 = conn.prepareCall("{? = call check_dislikedcomment(?,?)}");
            cstmt2.registerOutParameter(1, Types.INTEGER);
            cstmt2.setString(2, c.getUserName());
            cstmt2.setString(3, c.getRatingId());
            cstmt2.execute();
            return returnCode;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1; 
    }

    public static boolean cheeckIfLikedComment(String username, String commentId)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = check_ifliked(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, username);
            cstmt.setString(3, commentId);
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            if(returnCode == 1)
                return true;
            else
                return false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false; 
    
    }

    public static boolean cheeckIfDislikedComment(String username, String commentId)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            CallableStatement cstmt = conn.prepareCall("{? = check_ifdisliked(?,?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, username);
            cstmt.setString(3, commentId);
            cstmt.execute();
            int returnCode = cstmt.getInt(1);
            if(returnCode == 1)
                return true;
            else
                return false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false; 
    }
}
