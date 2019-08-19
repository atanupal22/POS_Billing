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
public class BillTextFormatWithFinalPrice extends BillTextFormater{
    
    public BillTextFormatWithFinalPrice(BillData billData){
        super(billData);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String generateBillText(){
        
        StringBuilder billText = new StringBuilder("");
                
        billData.getItemsListWithQuantityAndTotalTax().forEach( billEntity -> {
            
            Item item = billEntity.item;
            int quantity = billEntity.quantity;
            BigDecimal itemSalesTax = billEntity.totalTax;
            
            billText.append(quantity).append(" ")
                    .append(item.getName())
                    .append(" : ")
                    .append(item.getPrice().add(itemSalesTax).multiply(new BigDecimal(quantity)));
            billText.append("\n\r");
        });
        
        billText.append("Sales Taxes : ")
                .append(billData.getTotalSalesTax())
                .append("\n\r");
        billText.append("Total : ")
                .append(billData.getTotalBasePrice().add(billData.getTotalSalesTax()))
                .append("\n\r");
        
        return billText.toString();
    }

}
