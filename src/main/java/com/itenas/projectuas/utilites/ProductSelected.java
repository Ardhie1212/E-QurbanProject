/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.projectuas.utilites;

import com.itenas.projectuas.model.Hewan;

/**
 *
 * @author M Ardhie Abdul Ghani
 */
public class ProductSelected {
    private static Hewan hewan;
    
    public static Hewan getHewan() {
        return hewan;
    }

    public static void setHewan(Hewan hewan) {
        ProductSelected.hewan = hewan;
    }
}
