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
    public List<ReviewDTO> ListReview() {
        List<ReviewDTO> listReview = new ArrayList<>();
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            
            String getReview = "SELECT r.ReviewID, r.Rating, r.BookID, r.UserID, r.Comment, u.UserName FROM Review r JOIN Users u ON r.UserID = u.UserID ORDER BY r.ReviewID DESC";
            PreparedStatement stmt = con.prepareStatement(getReview);
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
    
    public ReviewDTO postReview(int Rating, int BookID, int UserID, String Comment){
        try(Connection con = ConnectDb.ConnectDB.getConnect()){
            
            String postReview = "Insert into Review (Rating,BookID,UserID,Comment) values (?,?,?,?) ";
              try(PreparedStatement stmt = con.prepareStatement(postReview)){
                stmt.setInt(1, Rating);
                stmt.setInt(2,BookID);
                stmt.setInt(3,UserID);
                stmt.setString(4, Comment);
               int rs = stmt.executeUpdate(); //trả về số dòng update 
                    if (rs != 0){
                        ReviewDTO review = new ReviewDTO();
                        review.setRating(Rating);
                        review.setUserID(UserID);
                        review.setComment(Comment);
                        return review;                  
                    }
             }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
}
