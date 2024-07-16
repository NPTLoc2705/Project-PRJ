<!DOCTYPE html>
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
                <li><a href="FileUpload.jsp">Upload</a></li>


            </ul>

            <% HttpSession sessions = request.getSession(false);

                if (sessions.getAttribute(
                        "loginSession") != null) {%>

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
                        <a href="Login?action=detail&id=${requestScope.userID}">                    
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

            <li><a href="Login.jsp">Sign In</a></li>

            <%}%>

        </nav>


        <div class="container">
            <h2>Account Settings</h2>
            <form action="Login?action=update&id=${requestScope.user.userID}" method="post">
                <label for="full_name">Account Name</label>
                <input type="text" id="full_name" name="full_name" value="${requestScope.user.username}">

                <label for="email_address">Email</label>
                <input type="email" id="email_address" name="email_address" value="${requestScope.user.email}" readonly>

                <label for="new_password">Password</label>
                <input type="password" id="new_password" name="new_password"  value="${requestScope.user.password}">
                <button type="submit">Save</button>
            </form>
        </div>

        <script src="js/script.js"></script>
    </body>
</html>
