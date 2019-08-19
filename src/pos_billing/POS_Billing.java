/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.util.ArrayList;

/**
 *
 * @author atanu
 */
public class POS_Billing {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Item> itemsList = new DummyDAO().queryOne();
                
        BillHandler billHandler = new BillHandler();
        
        itemsList.forEach( item -> {
            int quantity = 1; //can get random quantity or get it from user input
            
            billHandler.addItemToBill(item, quantity);
        });
        
        billHandler.showInConsole();
    }
}
