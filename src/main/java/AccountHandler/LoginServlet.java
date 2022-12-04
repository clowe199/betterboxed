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

@WebServlet(urlPatterns = "/Login")
public class LoginServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        
        System.out.println("Made it to Login Credentials Servlet.");

        if (username == null || username.equals("") || password == null || password.equals("")) {
            session.setAttribute("message","Please enter credentials and try again.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            System.out.println("User credentials are empty in Login.");
            return;
        }
        else{
            System.out.println("Login credentials are entered.");
            
        }
    
    }
}
