/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;

/**
 * This is a reusable Object, if used frequently can be changed to singleton
 * @author atanu
 */
public class BillTextFormatWithFinalPrice extends BillTextFormater{
    
    /**
     * Empty constructor so that BillData can be set later.
     */
    public BillTextFormatWithFinalPrice(){}
    
    /**
     * Constructor to inject Bill data object
     * @param billData
     */
    public BillTextFormatWithFinalPrice(BillData billData){
        super(billData);
    }
    
    /**
     * Generates bill text with quantity, final price of each item including taxes,
     * total Sales tax in given bill & total price of the bill.
     * @return - String representation of Bill Data.
     */
    @Override
    public String generateBillText(){
        
        if(billData == null){
            throw new NullPointerException("Bill Data is null hence bill text can not be created");
        }
        
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
