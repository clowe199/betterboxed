package AccountHandler;
import java.util.List;
import Accounts.UserAccount;
import Api.TMDBController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();

        String curUser = (String) session.getAttribute("username");
        System.out.println("Current user: " + curUser);

        UserAccount tempAccount = new UserAccount(curUser);
        TMDBController apiAccess = new TMDBController();

        List<Integer> movieList= tempAccount.displayHighlyRatedMovies();
        
        String movieName = apiAccess.getMovieData(movieList.get(0)).getTitle();
        session.setAttribute("movie1name", movieName);
        
        String movie2Name = apiAccess.getMovieData(movieList.get(1)).getTitle();
        session.setAttribute("movie2name", movie2Name);
        
        String movie3Name = apiAccess.getMovieData(movieList.get(2)).getTitle();
        session.setAttribute("movie3name", movie3Name);
    
    }
}
