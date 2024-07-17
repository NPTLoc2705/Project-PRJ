/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tab135
 */
public class BookDAO {

    public BookDTO FileUploader(String Title, String Author, String Description, String CoverName, int UserID) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {

            String sql = "INSERT INTO  Books(Title, Author, Description,DownloadLink,CoverImage,UserID) ";
            sql += " values(?,?,?,?,?,?)";
            String image_path = "D:\\PUBLIC_DB\\Image\\" + CoverName;
            String path = "D:\\PUBLIC_DB\\Books\\" + Title;

            try (PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, Title);
                stmt.setString(2, Author);
                stmt.setString(3, Description);
                stmt.setString(4, path);
                stmt.setString(5, CoverName);
                stmt.setInt(6, UserID);

                int rs = stmt.executeUpdate();
                if (rs >= 1) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int bookID = generatedKeys.getInt(1);
                            BookDTO book = new BookDTO();
                            book.setBookID(bookID);
                            book.setTitle(Title);
                            book.setAuthor(Author);
                            book.setDescription(Description);
                            book.setDownloadLink(path);
                            book.setCover(CoverName);
                            return book;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public void saveBookCategories(int bookID, String[] categories) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = "INSERT INTO BookCategory (CategoryID, BookID) VALUES (?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                for (String category : categories) {
                    int categoryID = Integer.parseInt(category);
                    stmt.setInt(1, categoryID);
                    stmt.setInt(2, bookID);
                    stmt.addBatch();
                }
                stmt.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BookDTO> list(String Title, int offset, int mode) {
        List<BookDTO> list = new ArrayList<>();
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = " SELECT BookID,Title, Description, CoverImage,AverageRating from Books  WHERE Title like ? ";
            if (mode != 0) {
                sql += "ORDER BY bookid offset ? rows fetch first 6 rows only";
            }
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + Title + '%');
            if (mode != 0) {
                stmt.setInt(2, offset);
            }
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
            String sql = "SELECT b.BookID, b.Title, b.Author, b.Description, b.CoverImage, b.AverageRating, b.DownloadLink, u.UserName, c.Category FROM Books b JOIN Users u ON b.UserID = u.UserID LEFT JOIN BookCategory bc ON b.BookID = bc.BookID LEFT JOIN Category c ON bc.CategoryID = c.CategoryID WHERE b.BookID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, Title);
            ResultSet rs = stmt.executeQuery();
            BookDTO book = new BookDTO();
            if (rs != null) {
                while (rs.next()) {
                    int book_ID = rs.getInt("BookID");
                    String book_title = rs.getString("Title");
                    String book_author = rs.getString("Author");
                    String book_Des = rs.getString("Description");
                    String book_cover = rs.getString("CoverImage");
                    double average_rating = rs.getDouble("AverageRating");
                    String book_link = rs.getString("DownloadLink");
                    String Username = rs.getString("UserName");         
                    book.setTitle(book_title);
                    book.setAuthor(book_author);
                    book.setDescription(book_Des);
                    book.setCover(book_cover);
                    book.setAverageRating(average_rating);
                    book.setDownloadLink(book_link);
                    book.setBookID(book_ID);
                    book.setUsername(Username);
                    String category = rs.getString("Category");
                        if (category != null) {
                            book.addCategory(category);
                        }
                }
                 return book;
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
        String sql = " DELETE FROM Review WHERE BookID = ?; DELETE FROM Books WHERE BookID = ?";
        try (Connection cn = ConnectDb.ConnectDB.getConnect();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
