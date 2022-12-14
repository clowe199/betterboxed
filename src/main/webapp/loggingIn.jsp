<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import = "pageNumber.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
    <body>
        <%
        //allow access only if session exists
        String user = null;
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.jsp");
        }
        else 
            user = (String) request.getSession(false).getServletContext().getAttribute("user");
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) 
                {
                    userName = cookie.getValue();
                }
            }
        }
        %>
        <h3>Hi <%=userName %>, Login successful.%></h3>
        <br>
        User=<%=userName %>
        <br>
        <form action="home" method="post">
            <input type="submit" value="login">
        </form>
    </body> 
</html>