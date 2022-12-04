<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Login</title>
</head>
<body>
<div id="background">
    <div id="nav">
        <nav class="navbar navbar-expand-lg bg-white">
          <div class="container-fluid" style="margin: 0px 40px;">
            <a class="navbar-brand" href="index.jsp">Better Box</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link align-self-end" href="./login.jsp">Login</a>
                <a class="nav-link align-self-end" href="./register.jsp">Register</a>
              </div>
            </div>
          </div>
        </nav>
      </div>
    <section class="h-100 gradient-form" style="background-color: #555555;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card rounded-3 text-black" id="card">
                    <div class="row g-0">
                        <div class="col-lg-6">
                            <div class="card-body p-md-5 mx-md-4">
                                <div class="text-center">
                                    <img src="https://thumbs.dreamstime.com/b/big-open-clapper-board-movie-reel-cinema-icon-set-movie-film-elements-flat-design-cinema-movie-time-flat-icons-f-95500226.jpg"
                                        style="width: 185px;" alt="logo">
                                    <h4 class="mt-1 mb-5 pb-1">Better Box</h4>
                                </div>
                                <form action="login" method="post">
                                    <p>Please login to your account</p>
                                    <div class="form-outline mb-4">
                                        <input type="username" id="Username" class="form-control" name="username"/>
                                        <label class="form-label" for="Username">Username</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input type="password" id="password" class="form-control" name="password"/>
                                        <label class="form-label" for="password">Password</label>
                                    </div>
                                    <div class="text-center pt-1 mb-5 pb-1">
                                        <button class="btn btn-primary btn-block fa-lg mb-3" type="Register">Login</button>
                                    </div>
                                </form>
                                    <div class="d-flex align-items-center justify-content-center pb-4">
                                        <p class="mb-0 me-2">Don't have an account?</p>
                                        <a href="register.jsp"><button type="button" class="btn btn-outline-danger">Create new</button></a>
                                    </div>
                            </div>
                        </div>
                        <div id="rightColumn" class="col-lg-6 d-flex align-items-center gradient-custom-2">
                            <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                <h4 class="mb-4">Find that movie you've been reminiscent of today!</h4>
                                <p class="small mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                                exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </section>







</div>

</body>
</html>