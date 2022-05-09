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
public interface Calculate {
     int calculateTot(Coincollect coininput);
    Coincollect calculateChange(int amountMoneyToReturn);
}
