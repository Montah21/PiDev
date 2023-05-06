/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khadamni.entities;

/**
 *
 * @author mouty
 */
public class Produit {
    private int id;
    private String nom;
    private int prix;
    private int stock ;
    private byte[] image;

    public Produit(){}
    public Produit(int id, String nom, int prix, int stock, byte[] image) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.image = image;
    }

    public Produit(String nom, int prix, int stock, byte[] image) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
}
