/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author atanu
 */
public class TaxCalculator {
    
    private final BigDecimal salesTax = new BigDecimal(10.00);
    private final BigDecimal importDuty = new BigDecimal(5.00);
    
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
