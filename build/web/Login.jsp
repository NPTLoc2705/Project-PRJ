<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <title>Classic - Responsive Bootstrap 4.0 Template</title>
        <!--
    Classic Template
    http://www.templatemo.com/tm-488-classic
        -->
        <!-- load stylesheets -->
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
            />
        <!-- Google web font "Open Sans" -->
        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <!-- Bootstrap style -->
        <link rel="stylesheet" href="CSS/templatemo-style.css" />
        <!-- Templatemo style -->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="tm-header">
            <div class="container-fluid">
                <div class="tm-header-inner">
                    <div class="tm-header-logo">
                      
                    </div>


                    <!-- navbar -->
                    <nav class="navbar tm-main-nav">
                        <button
                            class="navbar-toggler hidden-md-up"
                            type="button"
                            data-toggle="collapse"
                            data-target="#tmNavbar"
                            >
                            &#9776;
                        </button>

                        <div class="collapse navbar-toggleable-sm" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <li class="nav-item">
                                    <a href="index.html" class="nav-link">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a href="about.html" class="nav-link">About</a>
                                </li>
                                <li class="nav-item active">
                                    <a href="Login.jsp" class="nav-link">Sign up</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>

        <div class="container" id="container">
            <div class="form-container sign-up">
                <form action="./SignUp">
                    <h1>Create Account</h1>
                    <span>or use your email for registeration</span>
                    <input type="text" placeholder="Name" name="user" />
                    <input type="email" placeholder="Email" name="email" />
                    <input type="password" placeholder="Ex:123" name="pass" />
                    <button>Sign Up</button>

                </form>
            </div>
            <div class="form-container sign-in">
                <form action="./Login" method="post">
                    <h1>Sign In</h1>
                    <span>or use your email password</span>
                    <input type="text" placeholder="Email or User Name" name="user" />
                    <input type="password" placeholder="Ex:123" name="pass" />
                    <a href="#">Forget Your Password?</a>
                    <button>Sign In</button>
                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Hello, Friend!</h1>
                        <p>
                            You must be new here,please use your personal details to use all
                            of sites features
                        </p>
                        <button class="hidden" id="login">Sign In</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Welcome Back!</h1>
                        <p>Enter your personal details to use all of site features</p>
                        <button class="hidden" id="register">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/login.js"></script>
    </body>
</html>
