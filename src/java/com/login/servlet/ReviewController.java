package com.login.servlet;

import com.User.UserDTO;
import com.books.BookDAO;
import com.books.BookDTO;
import com.review.ReviewDAO;
import com.review.ReviewDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReviewController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        System.out.println(action);
        ReviewDAO dao = new ReviewDAO();
        BookDAO bd = new BookDAO();

        if (action == null) {
            Integer id = null;
            try {
                id = Integer.parseInt(request.getParameter("bookid"));
            } catch (NumberFormatException e) {
                log("ID in review detail error");
            }
            List<ReviewDTO> list = dao.ListReview(id);
            request.setAttribute("reviewList", list);
            request.getRequestDispatcher("./bookPage3.jsp").forward(request, response);
        } else if (action.equals("detail")) {
            Integer id = null;
            try {
                id = Integer.parseInt(request.getParameter("bookid"));
            } catch (NumberFormatException e) {
                log("ID in review detail error");
            }
            BookDTO rd = null;
            if (id != null) {
                rd = bd.load(id);
            }
            request.setAttribute("object", rd);
            List<ReviewDTO> list = dao.ListReview(id);
            request.setAttribute("reviewList", list);
            request.getRequestDispatcher("./bookPage3.jsp").forward(request, response);
        } 
        
        else if (action.equals("submitReview")) {
            Integer id = null;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                log("ID in review detail error");
            }
            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO) session.getAttribute("loginSession");

            if (user != null) {
                try (Connection conn = ConnectDb.ConnectDB.getConnect()) {
                    String get_user = "SELECT UserName FROM Users WHERE UserID = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(get_user)) {
                        stmt.setInt(1, user.getUserID());

                        String rate = request.getParameter("rate");
                        String comment = request.getParameter("comment");
                        if (rate != null && comment != null) {
                            int rate_ = Integer.parseInt(rate);
                            dao.postReview(rate_, id, user.getUserID(), comment);
                        }

                        // Sau khi submit review, lấy AverageRating mới nhất
                        double averageRating = dao.getBookAverageRating(id);


                        // Chuyển tiếp đến trang JSP
                        response.sendRedirect("./Bookdetail?action=detail&bookid="+id);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                response.sendRedirect("./Login.jsp");
            }
        } else if (action.equals("delete")) {
            Integer id_review = null;
            Integer id = null;
            try {
                id_review = Integer.parseInt(request.getParameter("reviewid"));
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException ex) {
                log("Parameter id has wrong format");
            }
            

            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO) session.getAttribute("loginSession");
            if (user != null) {
                dao.delete(id_review);
                
            response.sendRedirect("./Bookdetail?action=detail&bookid="+id);
            } else {
                response.sendRedirect("./Login.jsp");
            }
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
        return "Short description";
    }
}
