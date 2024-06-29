/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tab135
 */
public class ReviewDAO {

    public List<ReviewDTO> ListReview(int BookID) {
        List<ReviewDTO> listReview = new ArrayList<>();
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {

            String getReview = "SELECT r.ReviewID, r.Rating, r.BookID, r.UserID, r.Comment, u.UserName FROM Review r JOIN Users u ON r.UserID = u.UserID  Where r.BookID = ? ORDER BY r.ReviewID DESC";
            PreparedStatement stmt = con.prepareStatement(getReview);
            stmt.setInt(1, BookID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int reviewID = rs.getInt("ReviewID");
                int rating = rs.getInt("Rating");
                int bookID = rs.getInt("BookID");
                int userID = rs.getInt("UserID");
                String comment = rs.getString("Comment");
                String userName = rs.getString("UserName");

                ReviewDTO review = new ReviewDTO();
                review.setReviewID(reviewID);
                review.setRating(rating);
                review.setBookID(bookID);
                review.setUserID(userID);
                review.setComment(comment);
                review.setUserName(userName);

                listReview.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listReview;
    }

    public double getBookAverageRating(int bookID) {
        double averageRating = 0.0;
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String query = "SELECT AverageRating FROM Books WHERE BookID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, bookID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                averageRating = rs.getDouble("AverageRating");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return averageRating;
    }
    
        public String getBookDescription(int bookID) {
        String Description = "";
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String query = "SELECT Description FROM Books WHERE BookID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, bookID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Description = rs.getString("Description");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Description;
    }

    public ReviewDTO postReview(int Rating, int BookID, int UserID, String Comment) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectDb.ConnectDB.getConnect();
            con.setAutoCommit(false); 

            // Thêm review mới
            String postReview = "INSERT INTO Review (Rating, BookID, UserID, Comment) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(postReview);
            stmt.setInt(1, Rating);
            stmt.setInt(2, BookID);
            stmt.setInt(3, UserID);
            stmt.setString(4, Comment);
            int reviewRows = stmt.executeUpdate();

            if (reviewRows > 0) {
                // Cập nhật lại AverageRating của cuốn sách đã được thêm review
                String updateAverageRating
                        = "UPDATE Books "
                        + "SET AverageRating = ("
                        + "SELECT AVG(CAST(R.Rating AS FLOAT)) "
                        + "FROM Review R "
                        + "WHERE R.BookID = Books.BookID) "
                        + "WHERE BookID = ?";

                stmt = con.prepareStatement(updateAverageRating);
                stmt.setInt(1, BookID);
                stmt.executeUpdate();

                con.commit();

                // Trả về đối tượng ReviewDTO mới
                ReviewDTO review = new ReviewDTO();
                review.setRating(Rating);
                review.setBookID(BookID);
                review.setUserID(UserID);
                review.setComment(Comment);
                return review;
            } else {
                con.rollback(); // Rollback transaction nếu thêm review thất bại
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback(); // Rollback transaction khi gặp lỗi
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            // Dọn dẹp tài nguyên
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}