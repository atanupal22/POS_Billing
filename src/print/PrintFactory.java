/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

/**
 *
 * @author atanu
 */
public class PrintFactory {
    public PrintToIO getPrintToIO(String type){
        return new PrintToConsole();
    }
}
