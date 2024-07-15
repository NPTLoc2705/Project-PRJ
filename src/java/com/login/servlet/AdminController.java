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
        System.out.println(action);

        if ("list".equals(action)) {
            List<UserDTO> users = userDao.getAllUsers();
            for (UserDTO user : users) {
                if (userDao.checkBan(user.getUserID()) != 0) {
                    user.setBanned(true);
                }
            }

            List<BookDTO> books = bookDao.list("", 0, 0);

            request.setAttribute("users", users);
            request.setAttribute("books", books);

            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else if ("ban".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            userDao.banUser(userId);
            response.sendRedirect("./admin?action=list");

        } else if ("unban".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            userDao.unbanUser(userId);
            response.sendRedirect("./admin?action=list");
        } else if ("deleteBook".equals(action)) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            bookDao.delete(bookId);
            response.sendRedirect("./admin?action=list");

        } else if ("searchUser".equals(action)) {
            String searchUser = request.getParameter("searchUser");
            List<UserDTO> users = userDao.searchUsers(searchUser);
            for (UserDTO user : users) {
                user.setBanned(true);
            }
            List<BookDTO> books = bookDao.list("", 0, 0);
            request.setAttribute("users", users);
            request.setAttribute("books", books);
            request.getRequestDispatcher("admin.jsp").forward(request, response);

        } else if ("searchBook".equals(action)) {
            String searchBook = request.getParameter("searchBook");
            List<UserDTO> users = userDao.getAllUsers();
            List<BookDTO> books = bookDao.list(searchBook, 0, 0);
            request.setAttribute("users", users);
            request.setAttribute("books", books);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }

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
