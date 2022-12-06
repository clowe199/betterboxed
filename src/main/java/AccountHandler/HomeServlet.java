package AccountHandler;
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
        
        String movieName = apiAccess.getMovieData(movieList.get(0)).getTitle();
        Cookie movie1name;
        try {
            movie1name = new Cookie(movieName, URLEncoder.encode(movieName, "UTF-8"));
            response.addCookie(movie1name);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        String movie2Name = apiAccess.getMovieData(movieList.get(1)).getTitle();
        Cookie movie2NameCookie;
        try {
            movie2NameCookie = new Cookie(movie2Name, URLEncoder.encode(movieName, "UTF-8"));
            response.addCookie(movie2NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        String movie3Name = apiAccess.getMovieData(movieList.get(2)).getTitle();
        Cookie movie3NameCookie;
        try {
            movie3NameCookie = new Cookie(movie3Name, URLEncoder.encode(movieName, "UTF-8"));
            response.addCookie(movie3NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
}
