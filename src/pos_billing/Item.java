/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;

/**
 * Bean class for Item, assuming this will be connected to DAO/ORM
 * @author atanu
 */
public class Item {
    
    /**
     * Enum of Item types & if that type is exempted from sales tax or not
     */
    public enum Type{

        BOOK (true),
        MEDICAL (true),
        FOOD (true),
        OTHERS (false);

        public final boolean salesTaxExempted;
        
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
    
    /**
     *
     * @param productID
     * @param type
     * @param price
     * @param name
     * @param description
     * @param imported
     */
    public Item(String productID, Type type, BigDecimal price, String name, String description, boolean imported){
        this.productID = productID;
        this.type = type;
        this.price = price;
        this.name = name;
        this.description = description;
        this.imported = imported;
    }

    /**
     * Returns Type of the Item
     * @return
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets Type of the item.
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Returns Base Price of the Item
     * @return
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets Base Price of the item.
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns Name of the Item
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Name of the item.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Description of the Item
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets Description of the item.
     * @param Description
     */
    public void setDescription(String Description) {
        this.description = Description;
    }
    
    /**
     * Returns weather this item is imported or not
     * @return
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * Sets if this item is imported or not.
     * @param imported
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }
    
}
