/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.utilites;

import com.itenas.projectuas.model.Transaksi;
import java.time.LocalDate;

/**
 *
 * @author M Ardhie Abdul Ghani
 */
public class Transaction {
    private static double selisih;
    private static double transfer;
    private static LocalDate tanggal;

    public static LocalDate getTanggal() {
        return tanggal;
    }

    public static void setTanggal(LocalDate tanggal) {
        Transaction.tanggal = tanggal;
    }
    
    public static double getSelisih() {
        return selisih;
    }

    public static void setSelisih(double selisih) {
        Transaction.selisih = selisih;
    }

    public static double getTransfer() {
        return transfer;
    }

    public static void setTransfer(double transfer) {
        Transaction.transfer = transfer;
    }
    
}
