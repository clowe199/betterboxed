package AccountHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (urlPatterns = "/movie")
public class MovieServlet extends HttpServlet {
    public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String curUser = null;
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                curUser = cookie.getValue();
            }
            if(cookie.getName().equals("movie")){
            
            }
        }
        // Testing whether or not servert transport of info works properly
        System.out.println(session.getServletContext().getAttribute("user"));
        
    
    
        
        response.sendRedirect("movie.jsp");
    }    
}
