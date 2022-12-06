<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import = "pageNumber.*"%>
<%@ page import = "java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd&quot;&gt;">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta value="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
      window.onload = function(){
          movie1name = document.getElementById("movie1name");
          movie1name.innerHTML = getCookie("cookie1");

      }
      function getCookie(cname)
      {
        let name = cname + "=";
        let decodedCookie = decodeURIComponent(document.cookie);
        let ca = decodedCookie.split(';');
        for(let i = 0; i <ca.length; i++) {
          let c = ca[i];
          while (c.charAt(0) == ' ') {
            c = c.substring(1);
          }
          if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
          }
        }
        return "";
      }
    </script>
    <title>Main</title>
</head>
<body>
    <div id="nav">
        <nav class="navbar navbar-expand-lg bg-white">
        <div class="container-fluid" style="margin: 0px 40px;">
            <a class="navbar-brand" href="home.jsp">Better Box</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div>
            <div class="navbar-nav">
                <a class="nav-link align-self-end" href="./profile.jsp">Profile</a>
                <a class="nav-link align-self-end" href="./logout.html">Logout</a>
            </div>
            </div>
        </div>
        </nav>
    </div>
    <!-- Cookies Req:
        1. Movie Name
        2. Movie Description
        3. Movie Likes
        4. Movie Dislikes
        5. Movie 
    
    
    
    -->
    <div id="bodyWithoutFoot">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <h1 id="movie1name" class="fs-1 text"></h1>
                    <p></p>
                </div>
                <div class="col-lg-7">
                    <div class="row">
                        <div></div>
                    </div>
                </div>
    </div>

    <div class="container-fluid" id="footer">
        <footer class="py-3">
            <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="home.jsp" class="nav-link px-2 text-black">Home</a></li>
            </ul>
            <p class="text-center">2022 Better Boxd</p>
        </footer>
    </div>
</body>