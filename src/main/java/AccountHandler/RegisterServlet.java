package AccountHandler;
import java.io.IOException;
import java.rmi.ServerException;
import SQLDBConnector.SQLDBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
            session.setAttribute("message","Please enter credentials and try again.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            System.out.println("User credentials are empty for registration.");
            return;
        }
       //Adds them to the database 
        else{
            SQLDBConnector.insertUser(username, password);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
            System.out.println("User has been added and loggged in");
        }

    }
    
    
}
