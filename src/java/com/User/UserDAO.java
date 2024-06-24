/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO{
    
    public UserDTO login(String username, String password){
         try(Connection con = ConnectDb.ConnectDB.getConnect()) {
                String sql = "select UserID, UserName, Password from Users ";
                sql +=" where UserName = ? and Password = ?";
            try(PreparedStatement stmt = con.prepareStatement(sql);){
                stmt.setString(1, username);
                stmt.setString(2,password);
                
                ResultSet rs = stmt.executeQuery(); //Quẻy trả về kết quả
                    if (rs.next()){
                        UserDTO user = new UserDTO();
                        user.setUserID(rs.getInt("UserID"));
                        user.setUsername(rs.getString("UserName"));
                        return user;                  
                    }
            }
                
            } catch (SQLException ex) {                
                System.out.println("Error in servlet. Details:" + ex.getMessage());
                ex.printStackTrace();
                
            }
        return null;
        
    }
     public UserDTO signup(String email, String username, String password){
    try (Connection con = ConnectDb.ConnectDB.getConnect()) {
        // Check User exist
        String checkSql = "SELECT COUNT(*) FROM Users WHERE Email = ? OR UserName = ?";
        try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
            checkStmt.setString(1, email);
            checkStmt.setString(2, username);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return null;
                }
            }
        }
        
        //Signup user
        String sql = "INSERT INTO Users(Email, UserName, Password) values(?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, username);
            stmt.setString(3, password);

            int rowsInserted = stmt.executeUpdate(); // Returns number of rows inserted
            if (rowsInserted >= 1) {
                UserDTO user = new UserDTO();
                user.setEmail(email);
                user.setUsername(username);
                user.setPassword(password);
                return user;
            }
        }
    } catch (SQLException ex) {                
                System.out.println("Error in servlet. Details:" + ex.getMessage());
                ex.printStackTrace();
                
            }
        return null;
        
    }
   
}
