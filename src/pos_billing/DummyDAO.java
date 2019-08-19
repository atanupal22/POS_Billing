/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author atanu
 */
public class DummyDAO {
    public ArrayList<Item> queryOne(){
        Item item1 = new Item(generateRandomID(), Item.Type.BOOK, new BigDecimal("12.49"), "Harry Potter", "book", false);
        Item item2 = new Item(generateRandomID(), Item.Type.OTHERS, new BigDecimal("14.99"), "The Wall (Pink Floyd)", "music cd", false);
        Item item3 = new Item(generateRandomID(), Item.Type.FOOD, new BigDecimal("0.85"), "Kitkat", "chocolate bar", false);
        
        ArrayList<Item> itemsList = new ArrayList<Item>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        
        return itemsList;
    }
    
    public ArrayList<Item> queryTwo(){
        Item item1 = new Item(generateRandomID(), Item.Type.FOOD, new BigDecimal("10.00"), "Ferrero Rocher", "imported chocolate bar", true);
        Item item2 = new Item(generateRandomID(), Item.Type.OTHERS, new BigDecimal("47.50"), "Perfume", "imported bottle of perfume", true);
        
        ArrayList<Item> itemsList = new ArrayList<Item>();
        itemsList.add(item1);
        itemsList.add(item2);
        
        return itemsList;
    }
    
    public ArrayList<Item> queryThree(){
        Item item1 = new Item(generateRandomID(), Item.Type.OTHERS, new BigDecimal("27.99"), "Perfume", "imported bottle of perfume", true);
        Item item2 = new Item(generateRandomID(), Item.Type.OTHERS, new BigDecimal("18.99"), "Perfume local", "bottle of perfume", false);
        Item item3 = new Item(generateRandomID(), Item.Type.MEDICAL, new BigDecimal("9.75"), "Saridon", "packet of headache pills", false);
        Item item4 = new Item(generateRandomID(), Item.Type.FOOD, new BigDecimal("11.25"), "Ferrero Rocher", "imported chocolate bar", true);
        
        ArrayList<Item> itemsList = new ArrayList<Item>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        
        return itemsList;
    }
    
    public String generateRandomID(){
        return Integer.toString((int) (Math.random() * 1000000));
    }
}
