<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
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
                    <td>${user.username}</td>
                    <td>
                        <div class="actions">
                            <form action="admin" method="post">
                                <input type="hidden" name="action" value="ban">
                                <input type="hidden" name="userId" value="${user.userID}">
                                <input type="submit" value="Ban">
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
                            <form action="admin" method="post">
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
</body>
</html>
