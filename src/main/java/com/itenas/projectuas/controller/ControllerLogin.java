/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.controller;

import com.itenas.projectuas.model.User;
import com.itenas.projectuas.utilites.AccountLoggedIn;
import com.itenas.projectuas.utilites.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class ControllerLogin {

    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.LogOn();

    public int Otorisasi(String user, String pwd) {
    int stat = 0;

    try {
        Statement stm = con.createStatement();

        // Check for admin first
        ResultSet rsAdmin = stm.executeQuery("SELECT * FROM admin WHERE username = '" + user + "' and password = '" + pwd + "'");
        if (rsAdmin.next() && Objects.equals(user, rsAdmin.getString("username")) && Objects.equals(pwd, rsAdmin.getString("password"))) {
            stat = 1;  // Admin found
        } else {
            // Check for user
            ResultSet rsUser = stm.executeQuery("SELECT * FROM user WHERE username = '" + user + "' and password = '" + pwd + "'");
            if (rsUser.next() && Objects.equals(user, rsUser.getString("username")) && Objects.equals(pwd, rsUser.getString("password"))) {
                stat = 2;  // User found
            }
        }

        rsAdmin.close();
        stm.close();

        return stat;
    }   catch (SQLException ex) {
            // Handle SQL errors appropriately
            // e.g., log the error, display a user-friendly message
            ex.printStackTrace();
            return stat;
        }
    }
    public User loginUser(String username, String pwd) {
    User user = null;
    String query = "SELECT * FROM user WHERE username = ? AND password = ?";
    
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, username);
        pstmt.setString(2, pwd);
        
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNama(rs.getString("nama"));
            user.setAlamat(rs.getString("alamat"));
            user.setNoTelp(rs.getString("nomor_telepon"));
            AccountLoggedIn.setCurrentUser(user);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return user;
}
}
