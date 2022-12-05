package AccountHandler;
import java.io.IOException;
import SQLDBConnector.SQLDBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
            session.setAttribute("message","Please enter credentials and try again.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            System.out.println("User credentials are empty in Login.");
            return;
        }
        else{
            System.out.println("Login credentials are entered.");
            UserAccount tempAccount = new UserAccount(username); 

            if (tempAccount.createAccount(username, password) == (-1)) {
                session.setAttribute("message","User "+username+" login has been successful.");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            }
            else{
                session.setAttribute("message", "User credentials are invalid.");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
                
            }
        }
    
    }
}
