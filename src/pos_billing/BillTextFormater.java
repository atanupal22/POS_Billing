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
    
    /**
     * Empty constructor so that BillData can be set later.
     */
    public BillTextFormater(){}

    /**
     * Constructor to inject Bill data object
     * @param billData
     */
    public BillTextFormater(BillData billData){
        this.billData = billData;
    }
    
    /**
     * Abstract method to generate Bill text to be printed in desired format.
     * @return - Bill Data in text format.
     */
    abstract public String generateBillText();
    
    public BillData getBillData() {
        return billData;
    }

    public void setBillData(BillData billData) {
        this.billData = billData;
    }
}
