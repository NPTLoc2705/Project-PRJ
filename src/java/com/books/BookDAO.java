/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
public class BookDAO {

    public BookDTO FileUploader(InputStream input, String Title, String Author, String Description,InputStream CoverImage,String CoverName,String Imagepath) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            
            String sql = "INSERT INTO  Books(Title, Author, Description,DownloadLink,CoverImage) ";
            sql += " values(?,?,?,?,?)";
            String path = "D:\\PUBLIC_DB\\Books\\" + Title;
            String image_path =  "D:\\PUBLIC_DB\\Image\\"+ CoverName;
            File bookFile = new File(path);
            try (FileOutputStream outputBook = new FileOutputStream(bookFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    outputBook.write(buffer, 0, bytesRead);
                }
            }
            File imageFile = new File(image_path);
            try (FileOutputStream outputImage = new FileOutputStream(imageFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = CoverImage.read(buffer)) != -1) {
                    outputImage.write(buffer, 0, bytesRead);
                }
            }
            
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, Title);
                stmt.setString(2, Author);
                stmt.setString(3, Description);
                stmt.setString(4, path);
                stmt.setString(5, CoverName);

                int rs = stmt.executeUpdate();
                if (rs >= 1) {
                    BookDTO books = new BookDTO();
                    books.setTitle(Title);
                    books.setAuthor(Author);
                    books.setDescription(Description);
                    books.setDownloadLink(path);
                    books.setCover(CoverName);
                    return books;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   public List<BookDTO> list(String Title) {
        List<BookDTO> list = new ArrayList<>();
        try(Connection con = ConnectDb.ConnectDB.getConnect()) {         
            String sql = " SELECT BookID,Title, Description, CoverImage,AverageRating FROM Books WHERE Title LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, '%'+Title+'%');
            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int book_ID = rs.getInt("BookID");
                    String book_title = rs.getString("Title");
                    String book_Des = rs.getString("Description");
                    String book_cover = rs.getString("CoverImage");
                    double average_rating = rs.getDouble("AverageRating");
                    BookDTO book = new BookDTO();
                    book.setTitle(book_title);
                    book.setDescription(book_Des);
                    book.setCover(book_cover);
                    book.setAverageRating(average_rating);
                    book.setBookID(book_ID);
                    list.add(book);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details:" + ex.getMessage());
            ex.printStackTrace();

        }
        return list;
    }
   

}