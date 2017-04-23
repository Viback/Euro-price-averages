/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.europris;

/**
 *
 * @author Vikke
 */
public class Europrice {
    private String date;
    private double price;
    
    public Europrice(String date, double price)
    {
        this.date = date;
        this.price = price;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public double getPrice()
    {
        return price;
    }
}
