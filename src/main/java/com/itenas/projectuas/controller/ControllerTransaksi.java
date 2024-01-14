/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.controller;

import com.itenas.projectuas.model.Hewan;
import com.itenas.projectuas.model.Transaksi;
import com.itenas.projectuas.model.User;
import com.itenas.projectuas.utilites.AccountLoggedIn;
import com.itenas.projectuas.utilites.ConnectionManager;
import com.itenas.projectuas.utilites.ProductSelected;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M Ardhie Abdul Ghani
 */
public class ControllerTransaksi {

    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.LogOn();

    public boolean insertTransaksi(User user, Hewan hewan, LocalDate tanggalBeli, 
            String namaTujuan, String rekening, String jenisBank, Double saldo, Double tagihan, double selisih) {
        user = AccountLoggedIn.getCurrentUser();
        hewan = ProductSelected.getHewan();

        String query = "INSERT INTO Transaksi (Username, Hewan_ID, Tanggal_Beli, Nama_Tujuan, "
                + "Rekening, Jenis_Bank, Saldo, Tagihan, Selisih) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hewan.getIdHewan());
            preparedStatement.setString(3, tanggalBeli.toString());
            preparedStatement.setString(4, namaTujuan);
            preparedStatement.setString(5, rekening);
            preparedStatement.setString(6, jenisBank);
            preparedStatement.setDouble(7, saldo);
            preparedStatement.setDouble(8, tagihan);
            preparedStatement.setDouble(9, selisih);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Transaksi> showTransaksi(User user) {
        List<Transaksi> listtTransaksi = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String query = "SELECT transaksi.Invoice, user.Username, user.Nama, user.Alamat, hewan.Hewan_ID, "
                + "transaksi.Tanggal_beli, hewan.Nama_Hewan, hewan.Berat, hewan.Harga, "
                + "transaksi.Nama_Tujuan, transaksi.Jenis_Bank, transaksi.Saldo, "
                + "transaksi.Tagihan, transaksi.Selisih "
                + "FROM transaksi "
                + "JOIN hewan ON transaksi.Hewan_ID = hewan.Hewan_ID "
                + "JOIN user ON user.username = transaksi.username "
                + "WHERE user.username = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setInvoice(rs.getString("Invoice"));
                transaksi.setNamaHewan(rs.getString("Nama_Hewan"));
                transaksi.setBerat(rs.getDouble("Berat"));
                transaksi.setHarga(rs.getDouble("Harga"));
                transaksi.setUsername(rs.getString("Username"));
                transaksi.setNama(rs.getString("Nama"));
                transaksi.setAlamat(rs.getString("Alamat"));
                transaksi.setHewanId(rs.getString("Hewan_ID"));
                transaksi.setTanggalBeli(LocalDate.parse(rs.getString("Tanggal_beli"), formatter));
                transaksi.setNamaTujuan(rs.getString("Nama_Tujuan"));
                transaksi.setJenisBank(rs.getString("Jenis_Bank"));
                transaksi.setSaldo(rs.getDouble("Saldo"));
                transaksi.setTagihan(rs.getDouble("Tagihan"));
                transaksi.setSelisih(rs.getDouble("Selisih"));

                listtTransaksi.add(transaksi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log or handle the exception according to your application's needs
        }
        return listtTransaksi;
    }

    public List<Transaksi> showTransaksiAdmin() {
        List<Transaksi> listtTransaksi = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String query = "SELECT transaksi.Invoice, user.Username, user.Nama, user.Alamat, hewan.Hewan_ID, "
                + "transaksi.Tanggal_beli, hewan.Nama_Hewan, hewan.Berat, hewan.Harga, "
                + "transaksi.Nama_Tujuan, transaksi.Rekening, transaksi.Jenis_Bank, transaksi.Saldo, "
                + "transaksi.Tagihan, transaksi.Selisih "
                + "FROM transaksi "
                + "JOIN hewan ON transaksi.Hewan_ID = hewan.Hewan_ID "
                + "JOIN user ON user.username = transaksi.username";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setInvoice(rs.getString("Invoice"));
                transaksi.setNamaHewan(rs.getString("Nama_Hewan"));
                transaksi.setBerat(rs.getDouble("Berat"));
                transaksi.setHarga(rs.getDouble("Harga"));
                transaksi.setUsername(rs.getString("Username"));
                transaksi.setNama(rs.getString("Nama"));
                transaksi.setAlamat(rs.getString("Alamat"));
                transaksi.setHewanId(rs.getString("Hewan_ID"));
                transaksi.setTanggalBeli(LocalDate.parse(rs.getString("Tanggal_beli"), formatter));
                transaksi.setNamaTujuan(rs.getString("Nama_Tujuan"));
                transaksi.setRekening(rs.getString("Rekening"));
                transaksi.setJenisBank(rs.getString("Jenis_Bank"));
                transaksi.setSaldo(rs.getDouble("Saldo"));
                transaksi.setTagihan(rs.getDouble("Tagihan"));
                transaksi.setSelisih(rs.getDouble("Selisih"));

                listtTransaksi.add(transaksi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log or handle the exception according to your application's needs
        }
        return listtTransaksi;
    }

}