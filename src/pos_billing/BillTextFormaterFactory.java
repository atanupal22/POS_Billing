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

    /**
     * Factory to generate Bill text formater objects based on end user needs.
     * @param type - Which type Format is requested
     * @param billData - the Bill Data for whom the text to be generated.
     * @return
     */
    public BillTextFormater getBillTextFormater(String type, BillData billData){
        return new BillTextFormatWithFinalPrice(billData);
    }
}
