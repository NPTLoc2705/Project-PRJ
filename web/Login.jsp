<%@page import="com.User.UserDTO"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <title>Classic - Responsive Bootstrap 4.0 Template</title>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" />
        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <link rel="stylesheet" href="CSS/nav.css" />
        <link rel="stylesheet" href="CSS/templatemo-style.css" />

    </head>
    <body>
        <nav class="navbar">
            <div class="navbar-logo">
                <a href="BookController"><img src="img/hinh.png"  alt="logo" /></a>
            </div>
            <ul class="navbar-list">
                <li>
                    <div class="search">
                        <form action="BookController" method="POST">          
                            <input type="text" name="keyword" value="${param.keyword}" placeholder="Search">
                            <i class="fa-solid fa-magnifying-glass"> </i>
                        </form>
                    </div>
                </li>
                <li><a href="BookController">Home</a></li>
                <li><a href="FileUpload.jsp">Upload</a></li>

                <% UserDTO user = (UserDTO) session.getAttribute("loginSession");
                    if (user != null
                            && user.isAdmin()) { %>
                <li class="profile-dropdown-list-item">
                    <a href="./admin?action=list" class="nav-link"
                       >Go to Admin Page</a
                    >
                </li>
            </ul>
            <% }%>
            <% HttpSession sessions = request.getSession(false);
                if (sessions.getAttribute("loginSession") != null) {%>
            <div class="profile-dropdown">
                <div onclick="toggle()" class="profile-dropdown-btn">
                    <div class="profile-img">

                    </div>
                    <span
                        >${sessionScope.loginSession.username}
                        <i class="fa-solid fa-angle-down"></i>
                    </span>
                </div>
                <ul class="profile-dropdown-list">
                    <li class="profile-dropdown-list-item">
                        <a href="User.jsp">                    
                            User
                        </a>
                    </li>

                    <li class="profile-dropdown-list-item">
                        <a href="Login?action=signout"> Log out
                        </a>
                    </li>
                </ul>
            </div>
            <%}%>
        </nav>

        <div class="container" id="container">
            <div class="form-container sign-up">
                <form action="./Login?action=signup" method = "Post">
                    <h1>Create Account</h1>
                    <span>or use your email for registeration</span>
                    <input type="text" placeholder="Name" name="user" />
                    <input type="email" placeholder="Email" name="email" />
                    <input type="password" placeholder="Ex:123" name="pass" />
                    <button>Sign Up</button>

                </form>
            </div>
            <div class="form-container sign-in">
                <form action="./Login?action=login" method="post">
                    <h1>Sign In</h1>
                    <span>or use your email password</span>
                    <input type="text" placeholder="Email or User Name" name="user" />
                    <input type="password" placeholder="Ex:123" name="pass" />
                    <style>
                        h3{
                            color:red;
                            font-size:80%;
                        }

                    </style>
                    <% String error = (String) request.getAttribute("error"); %>
                    <% if (error != null) {%>

                    <h3 color="red"> <%= error%> </h3>

                    <% }%>
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
