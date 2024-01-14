/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.controller;

import com.itenas.projectuas.model.Hewan;
import com.itenas.projectuas.utilites.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M Ardhie Abdul Ghani
 */
public class ControllerHewan {
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.LogOn();
    
    public boolean insertHewan(String idHewan, String namaHewan, double berat, double harga, byte[] image){
        try {
            PreparedStatement stmCheck = con.prepareStatement("SELECT * FROM Hewan WHERE Hewan_ID = ?");
            stmCheck.setString(1, idHewan);
            ResultSet rs = stmCheck.executeQuery();

            if (rs.next()) {
                return false;
            }

            // Username is available, proceed with insertion
            String query = "INSERT INTO hewan (Hewan_ID, Nama_Hewan, Berat, Harga, Foto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, idHewan);
            stm.setString(2, namaHewan); 
            stm.setDouble(3, berat);
            stm.setDouble(4, harga);
            stm.setBytes(5, image); 
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            // Handle SQL errors appropriately
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<Hewan> showHewan(){
        List<Hewan> listHewan = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT* from Hewan");
            while (rs.next()){
                Hewan hewan = new Hewan();
                hewan.setIdHewan(rs.getString("Hewan_ID"));
                hewan.setNamaHewan(rs.getString("Nama_Hewan"));
                hewan.setBerat(rs.getDouble("Berat"));
                hewan.setHarga(rs.getDouble("Harga"));
                listHewan.add(hewan);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return listHewan;
    }
    
    public boolean updateHewan(String newId,String idHewan ,String namaHewan, double harga, double berat){
        String query = "UPDATE Hewan SET Hewan_ID = '"
                + newId + "', Nama = '" + namaHewan + "', Harga = " + harga + ", Berat = " + berat
                + " WHERE Hewan_ID = '" + idHewan + "'";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch(SQLException ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public boolean deleteHewan(String id){
        String query = "DELETE from Hewan where Hewan_id = '" + id + "'";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch(SQLException ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public byte[] getHewanPhoto(String idHewan){
        byte[] image = null;
        try {
        String query = "SELECT Foto FROM hewan WHERE Hewan_ID = '" + idHewan + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        // Pindahkan kursor ke baris pertama
        if (rs.next()) {
            image = rs.getBytes("Foto");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    return image;
    }
}