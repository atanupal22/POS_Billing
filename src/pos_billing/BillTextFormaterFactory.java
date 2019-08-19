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
public class BillTextFormaterFactory {
    public BillTextFormater getBillTextFormater(String type, BillData billData){
        return new BillTextFormatWithFinalPrice(billData);
    }
}
