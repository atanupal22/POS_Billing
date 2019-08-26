/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Maintains list of taxes and their values & calculations of all taxes for given item.
 * Singleton class as the calculations should remain same throughout the application.
 * @author atanu
 */
public class TaxCalculator {
    
    private static TaxCalculator instance;
        
    private final BigDecimal salesTax = new BigDecimal(10.00);
    private final BigDecimal importDuty = new BigDecimal(5.00);
    
    private TaxCalculator(){}
    
    public static TaxCalculator getInstance(){
        if(instance==null){
            synchronized (TaxCalculator.class){
                if(instance==null){
                    instance = new TaxCalculator();
                }
            }
        }
        return instance;
    }

    /**
     * Calculates tax of given item based on its type and if its imported
     * @param item
     * @return - Total tax to be applied on this item.
     */
    public BigDecimal calculateTax(Item item){
        BigDecimal totalTax = new BigDecimal(0.00);
        if(!item.getType().salesTaxExempted)
            totalTax = totalTax.add(salesTax);

        if(item.isImported())
            totalTax = totalTax.add(importDuty);

        return item.getPrice().multiply(totalTax)
                .divide(new BigDecimal(100.00))
                .setScale(2, RoundingMode.UP);
    }
    
}
