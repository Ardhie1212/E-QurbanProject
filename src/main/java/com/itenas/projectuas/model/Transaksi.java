/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.model;

import java.time.LocalDate;

public class Transaksi {
    private String invoice;
    private String namaHewan;
    private double berat;
    private String username;
    private LocalDate tanggalBeli;
    private double harga;
    private String namaTujuan;
    private String rekening;
    private String jenisBank;
    private double saldo;
    private double tagihan;
    private double selisih;
    private String nama;
    private String alamat;
    private String hewanId;

    public Transaksi() {
    }

    public Transaksi(String invoice, String namaHewan, double berat, String username, LocalDate tanggalBeli,
            double harga, String namaTujuan, String rekening, String jenisBank, double saldo, double tagihan, double selisih,
            String nama, String alamat, String hewanId) {
        this.invoice = invoice;
        this.namaHewan = namaHewan;
        this.berat = berat;
        this.username = username;
        this.tanggalBeli = tanggalBeli;
        this.harga = harga;
        this.namaTujuan = namaTujuan;
        this.rekening = rekening;
        this.jenisBank = jenisBank;
        this.saldo = saldo;
        this.tagihan = tagihan;
        this.selisih = selisih;
        this.nama = nama;
        this.alamat = alamat;
        this.hewanId = hewanId;
    }

    // Getter and Setter methods for the additional fields
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHewanId() {
        return hewanId;
    }

    public void setHewanId(String hewanId) {
        this.hewanId = hewanId;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(LocalDate tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNamaTujuan() {
        return namaTujuan;
    }

    public void setNamaTujuan(String namaTujuan) {
        this.namaTujuan = namaTujuan;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getJenisBank() {
        return jenisBank;
    }

    public void setJenisBank(String jenisBank) {
        this.jenisBank = jenisBank;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTagihan() {
        return tagihan;
    }

    public void setTagihan(double tagihan) {
        this.tagihan = tagihan;
    }

    public double getSelisih() {
        return selisih;
    }

    public void setSelisih(double selisih) {
        this.selisih = selisih;
    }

}