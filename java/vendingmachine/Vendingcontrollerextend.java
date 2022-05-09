/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author aakar
 */
public class Vendingcontrollerextend implements Vendingcontroller {
    
      private Calculate calculator = new CalcExtend();

   
    public Coincollect calculateChange(Vendingrequest request) {
        int total = calculator.calculateTot(request.coininput);
        int totalChange = total - request.item.getprice();
        return calculator.calculateChange(totalChange);
    }
}
