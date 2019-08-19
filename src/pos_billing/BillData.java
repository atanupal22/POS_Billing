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

    final TaxCalculator taxCalculator = new TaxCalculator();
    
    public void addItemToBill(Item item, int quantity){
        BigDecimal itemSalesTax = taxCalculator.calculateTax(item);

        totalSalesTax = totalSalesTax.add(itemSalesTax
                .multiply(new BigDecimal(quantity)));

        totalBasePrice = totalBasePrice.add(item.getPrice()
                .multiply(new BigDecimal(quantity)));
        
        itemsListWithQuantityAndTotalTax.add(new BillEntity(item,quantity,itemSalesTax));
    }
    
    public BigDecimal getTotalSalesTax() {
        return totalSalesTax;
    }

    public BigDecimal getTotalBasePrice() {
        return totalBasePrice;
    }
    
    public ArrayList<BillEntity> getItemsListWithQuantityAndTotalTax() {
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
