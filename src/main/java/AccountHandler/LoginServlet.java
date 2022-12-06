package AccountHandler;
import java.io.IOException;
import java.net.URLEncoder;

import SQLDBConnector.SQLDBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Accounts.UserAccount;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        System.out.println("Entered User:"+username+"\nEntered Password: "+password);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (username == null || username.equals("") || password == null || password.equals("")) {
            Cookie message = new Cookie("message", URLEncoder.encode("Credentials empty. Please try again.", "UTF-8"));            
            response.addCookie(message);
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            System.out.println("User credentials are empty in Login.");
            return;
        }
        else{
            System.out.println("Login credentials are entered.");
            UserAccount tempAccount = new UserAccount(username); 
            if (tempAccount.checkUser(username) == (-1)) {
                Cookie message = new Cookie("message",URLEncoder.encode("User "+username+" has logged in successfully.","UTF-8"));
                Cookie userCookie = new Cookie("user", URLEncoder.encode(username,"UTF-8"));
                response.addCookie(userCookie);
                response.addCookie(message);
                RequestDispatcher rd = request.getRequestDispatcher("loggingIn.jsp");
                rd.forward(request, response);
                System.out.println("User has been loggged in");
            }
            else{
                System.out.println("Credentials are invalid.");
                Cookie message = new Cookie("message", URLEncoder.encode("Credentials invalid, please try again.", "UTF-8"));            
                response.addCookie(message);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
                
            }
        }
    
    }
}
