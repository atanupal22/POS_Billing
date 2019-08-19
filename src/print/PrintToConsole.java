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
public class PrintToConsole implements PrintToIO{

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    
}
