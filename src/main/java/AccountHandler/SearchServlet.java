package AccountHandler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import Accounts.UserAccount;
import Api.TMDBController;
import info.movito.themoviedbapi.model.MovieDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        // Getting the current user
        String curUser =null;
        // curUser = (String) session.getServletContext().getAttribute("user");
        Cookie[] cookies = request.getCookies();
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
        // ...

        String searchClause = (String) request.getParameter("searchClause");
        
        List<MovieDb> FilmsFound = apiAccess.searchMovieName(searchClause);

        // Get the movie1cookie so we can reuse it later
        for (Cookie cookie : cookies)
        {
            if(cookie.getName().equals("cookie1")){
                String movieName = apiAccess.getMovieData(FilmsFound.get(0).getId()).getTitle().replaceAll("\\s", "_");
                cookie.setValue(URLEncoder.encode(movieName, "UTF-8"));
                response.addCookie(cookie);
            }
            if(cookie.getName().equals("cookie2")){
                String movieName = apiAccess.getMovieData(FilmsFound.get(1).getId()).getTitle().replaceAll("\\s", "_");
                cookie.setValue(URLEncoder.encode(movieName, "UTF-8"));
                response.addCookie(cookie);
            }
            if(cookie.getName().equals("cookie3")){
                String movieName = apiAccess.getMovieData(FilmsFound.get(2).getId()).getTitle().replaceAll("\\s", "_");
                cookie.setValue(URLEncoder.encode(movieName, "UTF-8"));
                response.addCookie(cookie);
            }
        }

        
        String movie4Name = apiAccess.getMovieData(FilmsFound.get(3).getId()).getTitle().replaceAll("\\s", "_");
        Cookie movie4NameCookie;
        try {
            movie4NameCookie = new Cookie("cookie4", URLEncoder.encode(movie4Name, "UTF-8"));
            response.addCookie(movie4NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String movie5Name = apiAccess.getMovieData(FilmsFound.get(4).getId()).getTitle().replaceAll("\\s", "_");
        Cookie movie5NameCookie;
        try {
            movie5NameCookie = new Cookie("cookie5", URLEncoder.encode(movie5Name, "UTF-8"));
            response.addCookie(movie5NameCookie);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("search.jsp");

    }
    
}
