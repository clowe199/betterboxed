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
  <form action="home">
  <div id="bodyWithoutFoot">
    <!-- Navbar Hear -->
    <div id="hero-slide-nav">
      <div class="carousel slide" data-bs-ride="carousel" >
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="10000">
            <img id="slideShowImage" src="images/Temp.png" class="d-block w-50" alt="...">
          </div>
          <div class="carousel-item" data-bs-interval="2000">
            <img id="slideShowImage" src="images/Temp.png" class="d-block w-50" alt="...">
          </div>
          <div class="carousel-item">
            <img id="slideShowImage" src="images/Temp.png" class="d-block w-50" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
    <div class="gapp"></div>
    <!-- Movie listings here -->
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <div class="card mb-4">
            <img src="images/Temp.png">
          </div>
        </div>
        <%
          String user = null;
          if(session.getAttribute("user") == null){
              response.sendRedirect("login.jsp");
          }
          else 
              user = (String) session.getAttribute("user");
          String movie1Name = null;
          String movie2Name = null;
          String movie3Name = null;
          Cookie[] cookies = request.getCookies();
          if(cookies !=null)
          {
            for(Cookie cookie : cookies)
            {
              if(cookie.getName().equals("move1NameCookie")) 
              {
                movie1Name = cookie.getValue();
              }
              if(cookie.getName().equals("move2NameCookie")) 
              {
                movie2Name = cookie.getValue();
              }
              if(cookie.getName().equals("move3NameCookie")) 
              {
                movie3Name = cookie.getValue();
              }
            }
          }
        
        %>
        <div class="col-md-9">
            <h1 class="card-title" value="${movie1name}"> <%out.println(movie1Name);%></h1>
            <p class="card-text" value="${movie1desc}"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            <p class="rating" value="${movie1rating}">rating here</p>
            <p class="likes" value="${movie1likes}">Likes # here</p>
          </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <div class="card mb-4">
            <img src="${movie1img}" alt="images/Temp.png">
          </div>
        </div>
        <div class="col-md-9">
          <h1 class="card-title" value="${movie2name}"> <%out.println(movie2Name);%></h1>
          <p class="card-text" value="movie2desc"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
          <p class="rating" value="movie2rating">rating here</p>
          <p class="likes" value="movie2likes">Likes # here</p>
          </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <div class="card mb-4">
            <img src="images/Temp.png">
          </div>
        </div>
        <div class="col-md-9">
          <h1 c:out class="card-title" value="${movie3name}"> <%out.println(movie3Name);%></h1>
          <p class="card-text" value="movie3desc"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
          <p class="rating" value="movie3rating">rating here</p>
          <p class="likes" value="movie3likes">Likes # here</p>
          </div>
      </div>
    </div>
  </div>
  </form>  
  <div class="gapp"></div>
  <!-- footer? -->
  <div class="container-fluid" id="footer">
    <footer class="py-3">
      <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item"><a href="home.jsp" class="nav-link px-2 text-black">Home</a></li>
      </ul>
      <p class="text-center">2022 Better Boxd</p>
    </footer>
  </div>
    
  </body>
</html>