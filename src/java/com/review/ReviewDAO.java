/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.review;

import com.books.BookDTO;
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
        System.out.println("hjferhjfbuerberhjb");
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            
            String getReview = "SELECT ReviewID, Rating, BookID, UserID, Comment FROM Review";
            PreparedStatement stmt = con.prepareStatement(getReview);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                int reviewID = rs.getInt("ReviewID");
                int rating = rs.getInt("Rating");
                int bookID = rs.getInt("BookID");
                int userID = rs.getInt("UserID");
                String comment = rs.getString("Comment");

                ReviewDTO review = new ReviewDTO();
                review.setReviewID(reviewID);
                review.setRating(rating);
                review.setBookID(bookID);
                review.setUserID(userID);
                review.setComment(comment);

                listReview.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listReview;
    }
    
    public BookDTO postReview(){
        try(Connection con = ConnectDb.ConnectDB.getConnect()){
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
}
