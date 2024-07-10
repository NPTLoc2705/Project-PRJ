/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tab135
 */
public class BookDAO {

    public BookDTO FileUploader(InputStream input, String Title, String Author, String Description, InputStream CoverImage, String CoverName, String Imagepath, int UserID) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {

            String sql = "INSERT INTO  Books(Title, Author, Description,DownloadLink,CoverImage,UserID) ";
            sql += " values(?,?,?,?,?,?)";
            String path = "D:\\PUBLIC_DB\\Books\\" + Title;
            String image_path = "D:\\PUBLIC_DB\\Image\\" + CoverName;
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
                stmt.setInt(6, UserID);

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
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = " SELECT BookID,Title, Description, CoverImage,AverageRating FROM Books WHERE Title LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + Title + '%');
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

    public BookDTO load(int Title) {

        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = " SELECT BookID,Title,Author, Description, CoverImage,AverageRating,DownloadLink FROM Books WHERE BookID = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, Title);
            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int book_ID = rs.getInt("BookID");
                    String book_title = rs.getString("Title");
                    String book_author = rs.getString("Author");
                    String book_Des = rs.getString("Description");
                    String book_cover = rs.getString("CoverImage");
                    double average_rating = rs.getDouble("AverageRating");
                    String book_link = rs.getString("DownloadLink");

                    BookDTO book = new BookDTO();
                    book.setTitle(book_title);
                    book.setAuthor(book_author);
                    book.setDescription(book_Des);
                    book.setCover(book_cover);
                    book.setAverageRating(average_rating);
                    book.setDownloadLink(book_link);
                    book.setBookID(book_ID);
                    return book;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details:" + ex.getMessage());
            ex.printStackTrace();

        }
        return null;
    }

    public BookDTO FileDownloader(int id) {
        try (Connection conn = ConnectDb.ConnectDB.getConnect()) {
            String sql = "Select DownloadLink, Title  from Books where BookID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BookDTO book = new BookDTO();
                    String book_link = rs.getString("DownloadLink");
                    String Title = rs.getString("Title");
                    book.setDownloadLink(book_link);
                    book.setTitle(Title);
                    return book;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        String sql = " DELETE FROM Review WHERE BookID = ? ";
        sql += " Delete FROM Books WHERE BookID = ? ";
        try (Connection cn = ConnectDb.ConnectDB.getConnect()) {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error at delete BookDAO:Detail " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

}
