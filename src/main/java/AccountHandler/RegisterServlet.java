package AccountHandler;
import java.io.IOException;
import java.net.URLEncoder;
import java.rmi.ServerException;
import Accounts.UserAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        // session.setAttribute("username", session);
        System.out.println("Entered User:"+username+"\nEntered Password: "+password);
        
        
        //If user doesn't enter anything in one or both of the fields
        if (username == null || username.equals("") || password == null || password.equals("")) {
            Cookie message = new Cookie("message",URLEncoder.encode("Please enter credentials and try again.","UTF-8"));
                response.addCookie(message);
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            System.out.println("User credentials are empty for registration.");
            return;
        }
        //Adds them to the database 
        else{
            UserAccount newUser = new UserAccount(username);
            int accountStatus = newUser.createAccount(username, password);
            if (accountStatus != -1) {
                session.setAttribute("user", username);
                Cookie message = new Cookie("message",URLEncoder.encode("User "+username+" registered successfully.","UTF-8"));
                Cookie userCookie = new Cookie("user", URLEncoder.encode(username, "UTF-8"));
                response.addCookie(userCookie);
                response.addCookie(message);
                response.sendRedirect("loggingIn.jsp");
                System.out.println("User has been added and loggged in");
            }
            else{
                Cookie message = new Cookie("message",URLEncoder.encode("User already exists. Please try different credentials.","UTF-8"));
                response.addCookie(message);
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
                System.out.println("User could not be added");
            }
        }
    }
    
    
}
