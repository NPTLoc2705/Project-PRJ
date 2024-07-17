<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
            />

        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <link rel="stylesheet" href="CSS/nav.css" />
        <link rel="stylesheet" href="CSS/User.css" />
        <link rel="stylesheet" href="CSS/templatemo-style.css" />



        <title>Document</title>
    </head>
    <body>

        <%@page import="com.User.UserDTO"%>
        <nav class="navbar">
            <div class="navbar-logo">
                <a href="BookController"><img src="img/hinh.png"  alt="logo" /></a>
            </div>
            <ul class="navbar-list">
                <li><a href="BookController">Home</a></li>               


                <% HttpSession sessions = request.getSession(false);

                    if (sessions.getAttribute(
                            "loginSession") != null) {%>
                <li><a href="FileUpload.jsp">Upload</a></li>
            </ul>
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
                        <a href="Login?action=detail&id=${sessionScope.loginSession.userID}">                    
                            User Profile
                        </a>
                    </li>
                    <% UserDTO user = (UserDTO) session.getAttribute("loginSession");
                        if (user != null
                                && user.isAdmin()) { %>
                    <li class="profile-dropdown-list-item">
                        <a href="./admin?action=list">Go to Admin Page</a>
                    </li>
                    <% }%>
                    <li class="profile-dropdown-list-item">
                        <a href="Login?action=signout"> Log out </a>
                    </li>
                </ul>
            </div>

            <%} else {%>
            <li><a href="Login.jsp">Upload</a></li>
            <li><a href="Login.jsp">Sign In</a></li>

            <%}%>

        </nav>


        <div class="container">
            <h2>Account Settings</h2>
            <form action="Login?action=edit&id=${requestScope.user.userID}" method="post">

                <h1>Welcome ${sessionScope.loginSession.username}</h1>
                <p><strong>Account Name　:</strong>　${requestScope.user.username}</p>
                <p><strong>Email　:</strong>　${requestScope.user.email}</p>
                <p><strong>Password　:</strong> ${requestScope.user.password}</p>
                <button type="submit">Edit</button>

            </form>
        </div>

        <script src="js/script.js"></script>
    </body>
</html>
