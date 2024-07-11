package com.login.servlet;

import com.books.BookDAO;
import com.books.BookDTO;
import com.User.UserDAO;
import com.User.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDAO userDao = new UserDAO();
        BookDAO bookDao = new BookDAO();

        if (action != null) {
            if ("ban".equals(action)) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                userDao.banUser(userId);
                response.sendRedirect("admin");
                return;
            } else if ("deleteBook".equals(action)) {
                int bookId = Integer.parseInt(request.getParameter("bookId"));
                bookDao.delete(bookId);
                response.sendRedirect("admin");
                return;
            } else if ("searchUser".equals(action)) {
                String searchUser = request.getParameter("searchUser");
                List<UserDTO> users = userDao.searchUsers(searchUser);
                // Set isBanned field if needed
                for (UserDTO user : users) {
                    user.setBanned(true); // Example of setting isBanned flag
                }
                List<BookDTO> books = bookDao.list("", 0, 0);
                request.setAttribute("users", users);
                request.setAttribute("books", books);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                return;

            } else if ("searchBook".equals(action)) {
                String searchBook = request.getParameter("searchBook");
                List<UserDTO> users = userDao.getAllUsers();
                List<BookDTO> books = bookDao.list(searchBook, 0, 0);
                request.setAttribute("users", users);
                request.setAttribute("books", books);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                return;
            }
        }

        List<UserDTO> users = userDao.getAllUsers();
        // Set isBanned field if needed
        for (UserDTO user : users) {
            user.setBanned(true); // Example of setting isBanned flag
        }
        List<BookDTO> books = bookDao.list("", 0, 0);

        request.setAttribute("users", users);
        request.setAttribute("books", books);

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Admin Controller handling user banning, book deletion, and listing books and users";
    }
}
