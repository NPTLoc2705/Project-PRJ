<%@page import="com.User.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" href="CSS/nav.css" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" />
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }
            h2 {
                color: #333;
            }
            .message {
                color: green;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            table, th, td {
                border: 1px solid #ccc;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            .actions {
                display: flex;
                gap: 10px;
            }
            .actions form {
                display: inline;
            }
            .actions input[type="submit"] {
                background-color: #f44336; /* Red */
                color: white;
                border: none;
                padding: 5px 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                cursor: pointer;
            }

            .clear-shelf:hover {
                background-color: #0056b3;
            }
            .back-link {
                margin-top: 20px;
                display: inline-block;
                color: #007bff;
                text-decoration: none;
                font-size: 16px;
            }
            .back-link:hover {
                text-decoration: underline;
            }
            .search-bar {
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar">
            <div class="navbar-logo">
                <a href="BookController"><img src="img/hinh.png"  alt="logo" /></a>
            </div>
            <ul class="navbar-list">
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
            <%} else {%>

            <li><a href="Login.jsp">Sign In</a></li>

            <%}%>
        </nav>
        <h2>Admin Page</h2>

        <c:if test="${not empty message}">
            <p class="message">${message}</p>
        </c:if>

        <h2>Users</h2>
        <div class="search-bar">
            <form action="admin" method="get">
                <input type="hidden" name="action" value="searchUser">
                <input type="text" name="searchUser" placeholder="Search Users by Username">
                <input type="submit" value="Search">
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userID}</td>
                        <td>${user.username}                                
                            <c:if test="${user.banned}">
                                <span style="color: green; font-weight: bold;">Banned</span>
                            </c:if>
                        </td>
                        <td>
                            <div class="actions">
                                <form action="admin" method="post">
                                    <input type="hidden" name="action" value="ban">
                                    <input type="hidden" name="userId" value="${user.userID}">
                                    <input type="submit" value="Ban upload">
                                </form>

                                <form action="admin" method="post">
                                    <input type="hidden" name="action" value="unban">
                                    <input type="hidden" name="userId" value="${user.userID}">
                                    <input type="submit" value="Unban">
                                </form>
                            </div>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h2>Books</h2>
        <div class="search-bar">
            <form action="admin" method="get">
                <input type="hidden" name="action" value="searchBook">
                <input type="text" name="searchBook" placeholder="Search Books by Title">
                <input type="submit" value="Search">
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>BookID</th>
                    <th>Title</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.title}</td>
                        <td>
                            <div class="actions">
                                <form action="./admin" method="post">
                                    <input type="hidden" name="action" value="deleteBook">
                                    <input type="hidden" name="bookId" value="${book.bookID}">
                                    <input type="submit" value="Delete">
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="js/script.js"></script>
    </body>
</html>
