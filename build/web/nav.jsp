
<%@page import="com.User.UserDTO"%>
<nav class="navbar">
    <div class="navbar-logo">
        <a href="BookController"><img src="img/hinh.png"  alt="logo" /></a>
    </div>
    <ul class="navbar-list">
        <li>
            <div class="search">
                <form action="BookController" method="POST">          
                    <input type="text" name="keyword" value="${param.keyword}" placeholder="Search">

                </form>
            </div>
        </li>
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
   
    <style>
        a{
            color: black;
        }
    </style>
    <%}%>

</nav>
