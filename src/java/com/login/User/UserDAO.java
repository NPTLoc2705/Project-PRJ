/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO{
    
    public UserDTO login(String username, String password){
         try(Connection con = ConnectDb.ConnectDB.getConnect()) {
                String sql = "select UserName, Password from users ";
                sql +=" where UserName = ? and Password = ?";
            try(PreparedStatement stmt = con.prepareStatement(sql);){
                stmt.setString(1, username);
                stmt.setString(2,password);
                
                ResultSet rs = stmt.executeQuery();
                    if (rs.next()){
                        UserDTO user = new UserDTO();
                        user.setPassword(rs.getString("Password"));
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
         try(Connection con = ConnectDb.ConnectDB.getConnect()) {
                String sql = "INSERT INTO  Users(Email, UserName, Password) ";
                sql +=" values(?,?,?)";
            try(PreparedStatement stmt = con.prepareStatement(sql);){
                stmt.setString(1, email);
                stmt.setString(2, username);
                stmt.setString(3, password);
                
                    int rs = stmt.executeUpdate();
                    if (rs >= 1){
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
