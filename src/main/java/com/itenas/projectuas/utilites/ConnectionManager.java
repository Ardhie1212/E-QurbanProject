/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.utilites;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rizal
 */
public class ConnectionManager {
    private Connection con;
    private String Driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/e-qurban";
    private String Username = "root";
    private String Password = "";
    
    public Connection LogOn(){
        try {
            Class.forName(Driver).newInstance();
            con = DriverManager.getConnection(url, Username, Password);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    public void logOff(){
        try {
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
