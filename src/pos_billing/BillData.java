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
public class BillData {
    
    private final ArrayList<BillEntity> itemsListWithQuantityAndTotalTax = new ArrayList<>();

    private BigDecimal totalSalesTax = new BigDecimal(0.00);
    private BigDecimal totalBasePrice = new BigDecimal(0.00);

    /**
     * Add items to this bill and calculates the changes in totalBasePrice & totalSalesTax;
     * @param item - Item to be added
     * @param quantity - How many quantity to be added
     */
    public void addItemToBill(Item item, int quantity){
        BigDecimal itemSalesTax = TaxCalculator.getInstance().calculateTax(item);

        totalSalesTax = totalSalesTax.add(itemSalesTax
                .multiply(new BigDecimal(quantity)));

        totalBasePrice = totalBasePrice.add(item.getPrice()
                .multiply(new BigDecimal(quantity)));
        
        itemsListWithQuantityAndTotalTax.add(new BillEntity(item,quantity,itemSalesTax));
    }
    
    /**
     * Returns total sales tax uptil now for this bill
     * @return - totalSalesTax
     */
    public BigDecimal getTotalSalesTax() {
        return totalSalesTax;
    }

    /**
     * Returns total base price uptil now for this bill
     * @return - totalBasePrice
     */
    public BigDecimal getTotalBasePrice() {
        return totalBasePrice;
    }
    
    /**
     * Returns list of items in this bill.
     * @return - Returns clone Object of list of items in this bill uptil now.
     */
    public ArrayList<BillEntity> getItemsListWithQuantityAndTotalTax() {
        ArrayList<BillEntity> cloneList = (ArrayList<BillEntity>)itemsListWithQuantityAndTotalTax.clone();
        return itemsListWithQuantityAndTotalTax;
    }
    
    class BillEntity{
        Item item;
        int quantity;
        BigDecimal totalTax;

        public BillEntity(Item item, int quantity, BigDecimal totalTax) {
            this.item = item;
            this.quantity = quantity;
            this.totalTax = totalTax;
        }
    }
}
