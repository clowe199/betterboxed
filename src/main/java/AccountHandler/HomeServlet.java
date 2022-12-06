package AccountHandler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import Accounts.UserAccount;
import Api.TMDBController;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String curUser =null;
        
        if(cookies != null) {
            for(Cookie cookie :cookies){
                if(cookie.getName().equals("user")){
                    curUser = cookie.getValue();
                }
            }
        }
        
        System.out.println("Current user: " + curUser);
        
        UserAccount tempAccount = new UserAccount(curUser);
        TMDBController apiAccess = new TMDBController();

        List<Integer> movieList= tempAccount.displayHighlyRatedMovies();
        
        String movie1Name = apiAccess.getMovieData(movieList.get(0)).getTitle().replaceAll("\\s", "_");
        Cookie movie1NameCookie;
        try {
            movie1NameCookie = new Cookie("movie1Name", URLEncoder.encode(movie1Name, "UTF-8"));
            response.addCookie(movie1NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        String movie2Name = apiAccess.getMovieData(movieList.get(1)).getTitle().replaceAll("\\s", "_");
        Cookie movie2NameCookie;
        try {
            movie2NameCookie = new Cookie("movie2Name", URLEncoder.encode(movie2Name, "UTF-8"));
            response.addCookie(movie2NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        String movie3Name = apiAccess.getMovieData(movieList.get(2)).getTitle().replaceAll("\\s", "_");
        Cookie movie3NameCookie;
        try {
            movie3NameCookie = new Cookie("movie3Name", URLEncoder.encode(movie3Name, "UTF-8"));
            response.addCookie(movie3NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        response.sendRedirect("home.jsp");
    }
}
