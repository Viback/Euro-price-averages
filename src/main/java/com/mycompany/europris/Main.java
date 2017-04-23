/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.europris;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Vikke
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        
        //Read JSON file
        FileReader fr = new FileReader("euroInUsd.json");
        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject) jp.parse(fr);
        JSONArray ja = (JSONArray) jo.get("EuroInUSD");
        ArrayList<Europrice> prices = new ArrayList();
        
        for(int i = 0; i < ja.size(); i++)
        {
            JSONObject jsonElement = (JSONObject) ja.get(i);
            String date = jsonElement.get("Date").toString();
            String pricestring = jsonElement.get("Price").toString();
            double price = Double.parseDouble(pricestring);
            
            Europrice europrice = new Europrice(date, price);  
            prices.add(europrice);
        }
        
        //Count the moving average for the last 20 days
        double total = 0;
        int count = 0;
        double average =0;
        for(int i = 0; i < ja.size(); i++)
        {
        total += prices.get(i).getPrice();
        count++;
        if (count > 20)
        {
        total -= prices.get(i-20).getPrice();
        }
        if (count < 20)
        {
        average = total/count;
        }
        else average = total/20;
        
        System.out.println("Date : " + prices.get(i).getDate());
        System.out.println("Price : " + prices.get(i).getPrice());
        System.out.println("Moving average : " + average);
        //export output into excel and draw a chart
        }
    }
    
}
