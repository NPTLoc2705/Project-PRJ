<%@page import="java.sql.PreparedStatement"%>
<%@page import="ConnectDb.ConnectDB"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Download</th>
                </tr>
            </thead>
            <tbody>

                <%
                    String input = request.getParameter("user");

                    try (Connection connection = ConnectDB.getConnect()) {

                        String sql = "SELECT * FROM UNAME WHERE Name = ?";
                        PreparedStatement run = connection.prepareCall(sql);

                        run.setString(1, input);

                        ResultSet result = run.executeQuery();

                        while (result.next()) {

                %>
                <tr>
                    <td><%= result.getString("Name")%></td>
                    <td><%= result.getString("Link")%></td>
                    <td><%=sql%></td>
                </tr>

                <%
                        }
                    } catch (Exception e) {
                        out.println("Error fetching books: " + e.getMessage());
                    }
                %>
            </tbody>
        </table>
    </body>
</html>