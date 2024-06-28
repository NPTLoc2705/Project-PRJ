package com.login.servlet;

import com.User.UserDTO;
import com.review.ReviewDAO;
import com.review.ReviewDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
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
        int bookID = Integer.parseInt(request.getParameter("id"));

        if (action == null) {
            // Lấy danh sách review
            List<ReviewDTO> list = dao.ListReview(bookID);

            // Lấy AverageRating
            double averageRating = dao.getBookAverageRating(bookID);

            // Đặt các thuộc tính vào request
            request.setAttribute("reviewList", list);
            request.setAttribute("averageRating", averageRating);
            request.setAttribute("ID", bookID);
            // Chuyển tiếp đến trang JSP
            request.getRequestDispatcher("./bookPage3.jsp").forward(request, response);
        } else if (action.equals("submitReview")) {
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
                            dao.postReview(rate_, bookID, user.getUserID(), comment);
                        }

                        // Sau khi submit review, lấy AverageRating mới nhất
                        double averageRating = dao.getBookAverageRating(bookID);

                        // Lấy danh sách review cập nhật
                        List<ReviewDTO> list = dao.ListReview(bookID);

                        // Đặt các thuộc tính vào request
                        request.setAttribute("reviewList", list);
                        request.setAttribute("averageRating", averageRating);

                        // Chuyển tiếp đến trang JSP
                        request.getRequestDispatcher("./bookPage3.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
