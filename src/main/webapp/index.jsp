<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Main</title>
</head>
<body>
  <div id="nav">
    <nav class="navbar navbar-expand-lg bg-white">
      <div class="container-fluid" style="margin: 0px 40px;">
        <a class="navbar-brand" href="./index.jsp">Better Box</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div>
          <div class="navbar-nav">
            <a class="nav-link align-self-end" href="./login.jsp">Login</a>
            <a class="nav-link align-self-end" href="./register.jsp">Register</a>
          </div>
        </div>
      </div>
    </nav>
  </div>
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
    <!-- Search Bar here -->    
    <div class="gapp"></div>
    <!-- Movie listings here -->
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <div class="card mb-4">
            <img src="images/Temp.png">
          </div>
        </div>
        <div class="col-md-9">
            <h1 class="card-title"> Movie Name Here</h1>
            <p class="card-text"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            <p class="rating">rating here</p>
            <p class="likes">Likes # here</p>
          </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <div class="card mb-4">
            <img src="images/Temp.png">
          </div>
        </div>
        <div class="col-md-9">
            <h1 class="card-title"> Movie Name Here</h1>
            <p class="card-text"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            <p class="rating">rating here</p>
            <p class="likes">Likes # here</p>
          </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <div class="card mb-4">
            <img src="images/Temp.png">
          </div>
        </div>
        <div class="col-md-9">
            <h1 class="card-title"> Movie Name Here</h1>
            <p class="card-text"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            <p class="rating">rating here</p>
            <p class="likes">Likes # here</p>
          </div>
      </div>
      </div>
  </div>  
    <div class="gapp"></div>
    <!-- footer? -->
    <div class="container-fluid" id="footer">
      <footer class="py-3">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
          <li class="nav-item"><a href="./index.jsp" class="nav-link px-2 text-black">Home</a></li>
        </ul>
        <p class="text-center">2022 Better Boxd</p>
      </footer>
    </div>
    
  </body>
</html>