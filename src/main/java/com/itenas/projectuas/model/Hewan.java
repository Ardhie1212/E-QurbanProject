/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.model;

/**
 *
 * @author rizal
 */
public class Hewan {
    private String idHewan;
    private String namaHewan;
    private double berat;
    private double harga;

    public Hewan() {
    }

    public Hewan(String idHewan, String namaHewan, double berat, double harga) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.berat = berat;
        this.harga = harga;
    }

    public String getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(String idHewan) {
        this.idHewan = idHewan;
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

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
}
