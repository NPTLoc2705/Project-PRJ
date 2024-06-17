/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Tab135
 */
public class BookDAO {
 public BookDTO FileUploader(InputStream input,String Title,String Author,String Description) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()){
            String sql = "INSERT INTO  Books(Title, Author, Description,DownloadLink) ";
            sql +=" values(?,?,?,?)";
            String path = "D:\\PUBLIC_DB\\" + Title; 
            byte[] bytes = new byte[input.available()];
            
            // Read bytes and write to path
            int bytesRead = input.read(bytes);
            if (bytesRead > 0) {
                FileOutputStream outputBook = new FileOutputStream(path);
                outputBook.write(bytes, 0, bytesRead);
                outputBook.flush();
                outputBook.close();
                
            }
            try(PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, Title);
                stmt.setString(2,Author);
                stmt.setString(3,Description);
                stmt.setString(4, path);
                
                int rs = stmt.executeUpdate();
                if(rs >= 1){
                    BookDTO books = new BookDTO();
                    books.setTitle(Title);
                    books.setAuthor(Author);
                    books.setDescription(Description);
                    books.setDownloadLink(path);
                    return books;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }
   
}