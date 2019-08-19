/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;

/**
 *
 * @author atanu
 */
public class Item {
    
    enum Type{
        BOOK (true),
        MEDICAL (true),
        FOOD (true),
        OTHERS (false);
        
        public boolean salesTaxExempted;
        
        Type(boolean salesTaxExempted){
            this.salesTaxExempted = salesTaxExempted;
        }
    }
    
    private String productID;
    private Type type;
    private BigDecimal price;
    private String name;
    private String description;
    private boolean imported;
    
    public Item(String productID, Type type, BigDecimal price, String name, String description, boolean imported){
        this.productID = productID;
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.imported = imported;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }
    
    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
    
}
