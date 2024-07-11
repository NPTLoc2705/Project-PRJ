package com.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public UserDTO login(String username, String password) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = "SELECT u.UserID, u.UserName, a.AdminID FROM Users u "
                    + "LEFT JOIN Admins a ON u.UserID = a.UserID "
                    + "WHERE (u.UserName = ? AND u.Password = ?) OR (u.Email = ? AND u.Password = ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, username);
                stmt.setString(4, password);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setUserID(rs.getInt("UserID"));
                    user.setUsername(rs.getString("UserName"));
                    // Check if the user is an admin
                    if (rs.getInt("AdminID") != 0) {
                        user.setAdmin(true);
                    }
                    return user;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public UserDTO signup(String email, String username, String password) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            // Check if user exists
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

            // Sign up user
            String sql = "INSERT INTO Users(Email, UserName, Password) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, username);
                stmt.setString(3, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted >= 1) {
                    UserDTO user = new UserDTO();
                    user.setEmail(email);
                    user.setUsername(username);
                    user.setPassword(password);
                    return user;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public List<UserDTO> searchUsers(String search) {
        List<UserDTO> users = new ArrayList<>();
        String sql = "SELECT UserID, UserName FROM Users WHERE UserName LIKE ?";
        try (Connection con = ConnectDb.ConnectDB.getConnect();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + search + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setUserID(rs.getInt("UserID"));
                    user.setUsername(rs.getString("UserName"));
                    users.add(user);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = "SELECT UserID, UserName FROM Users";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("UserName"));
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return users;
    }

    public void banUser(int userId) {
        try (Connection con = ConnectDb.ConnectDB.getConnect()) {
            String sql = "UPDATE Users SET IsBanned = 1 WHERE UserID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error in UserDAO - banUser method: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
