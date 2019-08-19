/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

/**
 *
 * @author atanu
 */
public abstract class BillTextFormater {
    
    BillData billData;
    
    public BillTextFormater(BillData billData){
        this.billData = billData;
    }
    
    abstract public String generateBillText();
}
